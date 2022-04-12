package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseObject {

    // == fields ==

    private String message;
    private List<ResponseLink> responseLinks = new ArrayList<>();


    // == constructors ==
    public ResponseObject(){}
    public ResponseObject(String message, List<ResponseLink> responseLinks){
        this.message = message;
        this.responseLinks = responseLinks;
    }

    // == methods ==


    public String getMessage() {
        return message;
    }

    public ResponseObject setMessage(String message) {
        this.message = message;
        return this;
    }

    public List<ResponseLink> getLinks() {
        return new ArrayList<ResponseLink>(responseLinks);
    }

    public ResponseObject setLinks(List<ResponseLink> responseLinks) {
        this.responseLinks = responseLinks;
        return this;
    }

    public void addLink(ResponseLink responseLink){
        responseLinks.add(responseLink);
    }
}
