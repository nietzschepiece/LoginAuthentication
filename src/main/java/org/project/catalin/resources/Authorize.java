package org.project.catalin.resources;

import org.project.catalin.model.Authorization;
import org.project.catalin.model.ClientDetails;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by cci on 05.11.2017.
 */
@Path("/authorize")
public class Authorize {
    ClientDetails clientDetails = ClientDetails.getInstance();

    @Context
    HttpServletRequest request;
    @Context
    HttpServletResponse response;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthorizationCode() throws URISyntaxException {
        Authorization authCode = new Authorization();
        authCode.setCode("AUTHORIZATION_CODE");
        URI uri = new URI(clientDetails.getRedirectUri() + "&code=" + authCode.getCode());

        return Response.temporaryRedirect(uri).build();
    }

    @GET
    public void getAuthorizationPage() throws ServletException, IOException {

        request.getRequestDispatcher("/authorize.jsp")
                .forward(request, response);

    }
}
