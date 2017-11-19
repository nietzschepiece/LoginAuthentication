package org.project.catalin.resources;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import java.io.IOException;

/**
 * Created by cci on 05.11.2017.
 */

@Path("/demoApp")
public class DemoApp {
    @Context
    HttpServletRequest request;
    @Context
    HttpServletResponse response;


    @GET
    public void getCredentialsForm() throws ServletException, IOException {
        request.getRequestDispatcher("/DemoApp.jsp")
                .forward(request, response);
    }

    @POST
    public void getCallback() throws ServletException, IOException {
        request.getRequestDispatcher("/DemoAppSucces.jsp")
                .forward(request, response);
    }
}
