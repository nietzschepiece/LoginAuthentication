package org.project.catalin.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;


/**
 * Created by cci on 07.11.2017.
 */
@Path("/token")
public class TokenResource {

    @POST
    public Response getToken(@QueryParam("client_id") String clientId,
                             @QueryParam("client_secret") String clientSecret,
                             @QueryParam("grant_type") String grantType,
                             @QueryParam("authorization_code") String authCode){


        //RESPONSE ; acces_token, token_type, expires_in, refresh_token:

         return Response.ok().entity("token").build();
    }



}
