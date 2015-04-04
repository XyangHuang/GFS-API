package com.hxy.gfs.resource;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.hxy.gfs.MockUtil;
import com.hxy.gfs.model.container.QuestionnaireList;
import com.hxy.gfs.service.QuestionnaireService;
import com.hxy.gfs.utils.JsonUtil;

@Component
@Path("questionnaires")
public class QuestionnaireResource extends BaseResource 
{
    @Resource
    private QuestionnaireService questionnaireService;
    
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuestionnaires() {
        QuestionnaireList questionnaireList = new QuestionnaireList();
        
        for (int i = 0; i < 5; i++)
        {
            questionnaireList.addQuestionnaire(MockUtil.mockQuestionnaire());
        }
        
        return JsonUtil.getJsonStringFromPojo(questionnaireList);
    }
}
