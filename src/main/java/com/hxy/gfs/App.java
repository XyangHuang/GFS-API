package com.hxy.gfs;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * Hello world!
 *
 */
@ApplicationPath("/*")
public class App extends ResourceConfig 
{
    public App( String[] args )
    {
        packages("com.hxy.gfs");
        register(JacksonJsonProvider.class);
    }
}
