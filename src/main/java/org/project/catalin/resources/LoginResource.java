package org.project.catalin.resources;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.project.catalin.model.ClientDetails;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;

import static org.project.catalin.resources.Basic64Filter.isUserAuthorised;

/**
 * Authorization Server consumes :
 * client_id = Application ID which requests the server (ex: demoapp)
 * redirect_uri = Where the service redirects after authorization code is granted
 * response_type
 * scope = Level of access (ex: read/write)
 */
@Path("/login")
public class LoginResource {

    ClientDetails clientDetails = ClientDetails.getInstance();

    @Context
    HttpServletRequest request;
    @Context
    HttpServletResponse response;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validateUserCredentials(@HeaderParam("Authorization") String auth) {

        if (isUserAuthorised())
            return Response.status(Response.Status.OK)
                    .entity("User authorized! DemoApp")
                    .build();

        else
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("User is not authorized !")
                    .build();
    }

    @GET
    public void getLoginPage(@QueryParam("client_id") String clientId,
                             @QueryParam("redirect_uri") String redirectUri,
                             @QueryParam("scope") String scope) throws ServletException, IOException {
        setClientDetails(clientId, redirectUri);

        request.getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }

    private void setClientDetails(String clientId, String redirectUri) {
        clientDetails.setClientId(clientId);
        clientDetails.setRedirectUri(redirectUri);
    }

}
