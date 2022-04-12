package com.techelevator.model;

public class Joke {

    // == fields ==
    private String joke;

    // == constructors ==
    public Joke(String joke){
        this();
        this.joke = joke;
    }

    public Joke(){}

    // == methods ==

    public String getJoke() {
        return joke;
    }

    public Joke setJoke(String joke) {
        this.joke = joke;
        return this;
    }
}
