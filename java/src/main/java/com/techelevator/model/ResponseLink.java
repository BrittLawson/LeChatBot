package com.techelevator.model;

public class ResponseLink {

    // == fields ==

    private String message;
    private String url;
    private String frontendRoutingParam;

    // == constructor ==

    public ResponseLink(String message, String url, String frontendRoutingParam) {
        this();
        this.frontendRoutingParam = frontendRoutingParam;
        this.message = message;
        this.url = url;
    }

    public ResponseLink(){}

    // == methods ==

    public String getFrontendRoutingParam() {
        return frontendRoutingParam;
    }

    public ResponseLink setFrontendRoutingParam(String frontendRoutingParam) {
        this.frontendRoutingParam = frontendRoutingParam;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseLink setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ResponseLink setUrl(String url) {
        this.url = url;
        return this;
    }
}
