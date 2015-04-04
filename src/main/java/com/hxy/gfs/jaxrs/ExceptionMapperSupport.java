package com.hxy.gfs.jaxrs;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.hxy.gfs.exception.BaseException;
import com.hxy.gfs.exception.LoginException;
import com.hxy.gfs.exception.ServiceErrorException;
import com.hxy.gfs.exception.ServiceWarningException;
import com.hxy.gfs.exception.UnAuthorizedException;
import com.hxy.gfs.i18n.MessageBuilder;
import com.hxy.gfs.i18n.MessageKeys;
import com.hxy.gfs.utils.CommonUtil;
import com.hxy.gfs.utils.SpringUtil;

@Provider
public class ExceptionMapperSupport implements ExceptionMapper<Exception> {

    private static final Logger LOGGER = Logger.getLogger(ExceptionMapperSupport.class);

    @Context
    private HttpServletRequest webRequest;

    @Override
    public Response toResponse(Exception exception) {
        MessageBuilder messageBuilder = SpringUtil.getBean(MessageBuilder.class);
        Locale locale = CommonUtil.getLocaleFromRequest(webRequest);

        if (exception instanceof ServiceErrorException) {
            ServiceErrorException serviceErrorException = (ServiceErrorException) exception;
            String code = serviceErrorException.getCode();
            String message = messageBuilder.buildMessage(code, serviceErrorException.getParam(),
                            serviceErrorException.getMessage(), locale);
            Status status = Status.INTERNAL_SERVER_ERROR;
            JSONObject responseJson = getResponseJson("error", message, serviceErrorException.getDetails(),
                            serviceErrorException);
            LOGGER.error(responseJson.toString());
            LOGGER.error(message, serviceErrorException);
            return Response.ok(responseJson.toString(), MediaType.APPLICATION_JSON).status(status).build();
        } else if (exception instanceof ServiceWarningException) {
            ServiceWarningException serviceWarningException = (ServiceWarningException) exception;
            String code = serviceWarningException.getCode();
            String message = messageBuilder.buildMessage(code, serviceWarningException.getParam(),
                            serviceWarningException.getMessage(), locale);
            Status status = Status.PRECONDITION_FAILED;
            JSONObject responseJson = getResponseJson("warning", message, serviceWarningException.getDetails(),
                            serviceWarningException);
            LOGGER.error(responseJson.toString());
            LOGGER.error(message, serviceWarningException);
            return Response.ok(responseJson.toString(), MediaType.APPLICATION_JSON).status(status).build();
        } else if (exception instanceof UnAuthorizedException) {
            UnAuthorizedException unAuthorizedException = (UnAuthorizedException) exception;
            String message = messageBuilder.buildMessage(MessageKeys.FORBIDDEN, "403 Forbidden", locale);
            Status status = Status.UNAUTHORIZED;
            JSONObject responseJson = getResponseJson("error", message, unAuthorizedException.getDetails(),
                            unAuthorizedException);
            LOGGER.warn(message, exception);
            return Response.ok(responseJson.toString(), MediaType.APPLICATION_JSON).status(status).build();
        } else if (exception instanceof LoginException) {
            LoginException loginException = (LoginException) exception;
            String message = messageBuilder.buildMessage(MessageKeys.USER_NAME_OR_PASSWORD_IS_WRONG,
                            "User Name or password is wrong", locale);
            Status status = Status.PRECONDITION_FAILED;
            JSONObject responseJson = getResponseJson("warning", message, loginException.getDetails(), loginException);
            LOGGER.warn(message, exception);
            return Response.ok(responseJson.toString(), MediaType.APPLICATION_JSON).status(status).build();
        } else {
            String message = messageBuilder.buildMessage(MessageKeys.INTERNAL_SERVER_ERROR, "Internal server error",
                            locale);
            Status status = Status.INTERNAL_SERVER_ERROR;
            JSONObject responseJson = getResponseJson("error", message, ((BaseException) exception).getDetails(),
                            exception);
            LOGGER.error(exception.getMessage(), exception);
            return Response.ok(responseJson.toString(), MediaType.APPLICATION_JSON).status(status).build();
        }
    }

    private JSONObject getResponseJson(String type, String message, Collection<?> details, Exception exception) {
        JSONObject responseJson = new JSONObject();
        responseJson.put("type", "warning");
        responseJson.put("message", message);
        JSONObject moreJson = new JSONObject();
        JSONArray detailJsonArray = new JSONArray();
        detailJsonArray.addAll(details);
        moreJson.put("detail", detailJsonArray);
        moreJson.put("cause", getExceptionStackTrace(exception));
        responseJson.put("more", moreJson);
        return responseJson;
    }

    private String getExceptionStackTrace(Exception exception) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            exception.printStackTrace(pw);
            return sw.toString();
        } catch (Exception e2) {
            return "bad getErrorInfoFromException";
        }

    }
}
