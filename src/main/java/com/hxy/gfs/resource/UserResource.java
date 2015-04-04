package com.hxy.gfs.resource;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.hxy.gfs.i18n.MessageBuilder;
import com.hxy.gfs.model.Student;
import com.hxy.gfs.model.container.Query;
import com.hxy.gfs.service.UserService;
import com.hxy.gfs.utils.JsonUtil;

@Component
@Path("users")
public class UserResource extends BaseResource {

    @Resource
    private UserService userService;
    @Resource
    MessageBuilder messageBuilder;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers() {
        return "";
    }

    /**
     * Create a new user
     * 
     * @param inString
     *            The post body of user pojo
     * @return The created user
     */
    @POST
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public void create(String inString) {
        Student pojo = JsonUtil.getPojoFromJsonString(inString, Student.class);
        userService.create(pojo);
    }

    @PUT
    @Path("{userid}")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateUser(@PathParam(value = "userid") long userSid) {
        return "";
    }

    @DELETE
    @Path("{userid}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteUser(@PathParam(value = "userid") long userSid) {
        return "delete success";
    }

    @GET
    @Path("{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserById(@PathParam(value = "userid") String userId) {
        return JsonUtil.getJsonStringFromPojo("");
    }

    @GET
    @Path("entity/search_term")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByPage(@BeanParam Query query) {
        return null;
    }
}
