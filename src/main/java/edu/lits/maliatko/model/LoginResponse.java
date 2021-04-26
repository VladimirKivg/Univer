package edu.lits.maliatko.model;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    private final String jwttoken;
    private final String user;

    public LoginResponse(String jwttoken, String user) {
        this.jwttoken = jwttoken;
        this.user = user;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getUser() {
        return user;
    }
}