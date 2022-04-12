package com.techelevator.services;

import com.techelevator.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class ResponseService {

    // == fields ==
    private static final String DEFAULT_RESPONSE_MESSAGE = "Sorry, I didn't find anything relevant. Here's a motivational quote:";
    QuoteService quoteService = new QuoteService();
    JokeService jokeService = new JokeService();

    // == constructor ==

    @Autowired
    public ResponseService(QuoteService quoteService, JokeService jokeService) {
        this.quoteService = quoteService;
        this.jokeService = jokeService;
    }

    // == methods ==

    public ResponseObject getResponseForQuery(String query, Principal principal){
        ResponseObject response = new ResponseObject();

        // code to populate response object

        if(response.getMessage() == null){
            return getDefaultResponse();
        }

        return response;
    }

    public ResponseObject getResponseForQueryInTopic(String query, String topic, Principal principal){
        ResponseObject response = new ResponseObject();

        // code to populate response object

        if(response.getLinks().isEmpty()){
            return getDefaultResponse();
        }

        return response;
    }

    public ResponseObject getJoke(){
        ResponseObject response = new ResponseObject();
        String joke = jokeService.getJoke();

        response.setMessage("Here's a joke:\n" + joke);

        return response;
    }

    ResponseObject getMotivationalQuote(){
        ResponseObject response = new ResponseObject();
        String quote = quoteService.getMotivationalQuote();
        response.setMessage(quote);
        return response;
    }

    // for now, the default response is just a motivational quote.
    public ResponseObject getDefaultResponse(){
        return getMotivationalQuote();
    }


}
