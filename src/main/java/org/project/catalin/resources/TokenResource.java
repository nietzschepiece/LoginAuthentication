package org.project.catalin.resources;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;


/**
 * Created by cci on 07.11.2017.
 */
@Path("/token")
public class TokenResource {

    @POST
    public Response getToken(@QueryParam("client_id") String clientId,
                             @QueryParam("client_secret") String clientSecret,
                             @QueryParam("grant_type") String grantType,
                             @QueryParam("authorization_code") String authCode) throws UnsupportedEncodingException {


        String jwt = Jwts.builder()
                .setSubject("subject")
                .setExpiration(new Date(1300819380))
                .claim("name", "Catalin")
                .claim("scope", "admin")
                .signWith(
                        SignatureAlgorithm.HS256,
                        "secret".getBytes("UTF-8")
                )
                .compact();

        String header = "Bearer " + jwt;
        return Response.ok().header("Authorization",header).build();
    }



}
