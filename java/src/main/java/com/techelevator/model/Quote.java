package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quote {

    // == fields ==
    @JsonProperty("q")
    private String quote;
    @JsonProperty("a")
    private String author;

    // == constructor ==

    public Quote(String quote, String author) {
        this();
        this.quote = quote;
        this.author = author;
    }

    public Quote(){}

    // == methods ==

    public String getQuote() {
        return quote;
    }

    public Quote setQuote(String quote) {
        this.quote = quote;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Quote setAuthor(String author) {
        this.author = author;
        return this;
    }
}
