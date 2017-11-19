package org.project.catalin.resources;

import org.glassfish.jersey.internal.util.Base64;
import org.project.catalin.ConfigHandler;
import org.project.catalin.service.MongoDatabaseService;
import org.project.catalin.service.SQLDatabaseService;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

/**
 * Created by cci on 29.09.2017.
 *
 * Class that - verifies the Authorization Header ( Ex: Authorization : Basic Q2F0YWxpbjpMb2xpcG9wMjI= )
 *            - validates data with database ( SQL / NoSQL depending in case )
 * Responses : Success 200 - Auth validated
 *             Fail 401 - Not authorized
 */
@Provider
public class Basic64Filter implements ContainerRequestFilter {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
    private static final String URL_SECURED = "login";
    protected static boolean userAuthorised;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (requestContext.getUriInfo().getPath().contains(URL_SECURED)) {
            List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
            if (authHeader != null && authHeader.size() > 0) {
                String authToken = authHeader.get(0);
                authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
                String decodedString = Base64.decodeAsString(authToken);
                StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
                String user = tokenizer.nextToken();
                String pass = tokenizer.nextToken();

                try {
                    if (validateDB(user, pass)) {
                        setUserAuthorised(true);
                        return;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            setUserAuthorised(false);
        }
    }

    public boolean validateDB(String user, String pass) throws SQLException {
        Optional<String> database = Optional.empty();
        try {
            ConfigHandler configHandler = new ConfigHandler();
            database = Optional.of(configHandler.getDatabaseName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (database.get()) {
            case "MongoDB":
                if (MongoDatabaseService.validateLogin(user, pass)) return true;
                break;
            case "SQL":
                if (SQLDatabaseService.validateLogin(user, pass)) return true;
                break;
            default:
                System.out.println("No database selected");
        }
        return false;
    }

    protected static boolean isUserAuthorised() {
        return userAuthorised;
    }

    private void setUserAuthorised(boolean userAuthorised) {
        this.userAuthorised = userAuthorised;
    }
}
