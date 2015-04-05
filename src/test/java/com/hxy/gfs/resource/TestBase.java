package com.hxy.gfs.resource;

import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.sf.json.JSONObject;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hxy.gfs.constants.Constants;
import com.hxy.gfs.service.UserService;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class TestBase extends JerseyTest {

    private static final String CONTAINER_GRIZZLY = "org.glassfish.jersey.test.grizzly.GrizzlyTestContainerFactory";
    protected static String userToken;

    @Override
    protected Application configure() {
        set(TestProperties.CONTAINER_FACTORY, CONTAINER_GRIZZLY);
        return new ResourceConfig().packages("com.hxy.gfs");
    }

    @Resource
    private UserService userService;

    protected Response doPost(String path, String token, String postBody) {
        return target(path).request().header(Constants.HEADER_X_AUTH_HEADER, token)
                        .post(Entity.entity(postBody, MediaType.APPLICATION_JSON_TYPE));
    }

    protected Response doPost(String path, String token) {
        return doPost(path, token, "");
    }

    protected Response doPost(String path, String token, JSONObject postBody) {
        return doPost(path, token, postBody.toString());
    }

    protected Response doPut(String path, String token, String postBody) {
        return target(path).request().header(Constants.HEADER_X_AUTH_HEADER, token)
                        .put(Entity.entity(postBody, MediaType.APPLICATION_JSON_TYPE));
    }

    protected Response doPut(String path, String token) {
        return doPut(path, token, "");
    }

    protected Response doPut(String path, String token, JSONObject postBody) {
        return doPut(path, token, postBody.toString());
    }

    protected Response doDelete(String path, String token) {
        return target(path).request().header(Constants.HEADER_X_AUTH_HEADER, token).delete();
    }

    protected Response doGet(String path, String token) {
        return target(path).request().header(Constants.HEADER_X_AUTH_HEADER, token).get();
    }

    protected Response doGetWithQueryParam(String path, String token, Map<String, String> queryParam) {
        WebTarget webTarget = target(path);
        for (Entry<String, String> entry : queryParam.entrySet()) {
            webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
        }
        return webTarget.request().header(Constants.HEADER_X_AUTH_HEADER, token).get();
    }
}
