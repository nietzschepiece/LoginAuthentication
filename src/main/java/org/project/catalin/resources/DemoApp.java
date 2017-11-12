package org.project.catalin.resources;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
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
    public String getCredentialsForm() {
        try {
            request.getRequestDispatcher("/DemoApp.jsp")
                    .forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "da";
    }
}
