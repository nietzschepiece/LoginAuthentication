package org.project.catalin.model;

/**
 * Created by cci on 07.11.2017.
 */

//Singleton Pattern
public class ClientDetails {
    private static ClientDetails instance = null;

    public String clientId;
    public String redirectUri;

    public static ClientDetails getInstance(){
        if (instance==null){
            instance = new ClientDetails();
        }
        return instance;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }
}
