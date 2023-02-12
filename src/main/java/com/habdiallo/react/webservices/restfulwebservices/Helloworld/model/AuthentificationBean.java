package com.habdiallo.react.webservices.restfulwebservices.Helloworld.model;

public class AuthentificationBean {

    private String message;

    public AuthentificationBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("AuthentificationBean [message=%s]", message);
    }
}
