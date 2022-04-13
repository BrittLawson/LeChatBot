package com.techelevator.services;

import com.techelevator.model.HitListData;
import com.techelevator.model.ResponseObject;
import org.springframework.stereotype.Service;

@Service
public class ResponseBuilder {

    // == fields ==
    private static final String DEFAULT_RESPONSE_MESSAGE = "Sorry, I didn't find anything relevant. Here's a motivational quote:\n";
    private QuoteService quoteService;
    private JokeService jokeService;
    private WordleService wordleService;

    // == constructor ==
    public ResponseBuilder(QuoteService quoteService, JokeService jokeService, WordleService wordleService) {
        this.quoteService = quoteService;
        this.jokeService = jokeService;
        this.wordleService = wordleService;
    }

    // == methods ==

        // public

    public ResponseObject getResponseObjectFromHitListData(HitListData h) {

        ResponseObject response = generateResponse(h);


        if (response.isEmpty()) {
            response = buildDefaultResponse();
        }

        return response;
    }

    public ResponseObject buildDefaultResponse() {

        String quote = quoteService.getMotivationalQuote();
        String message = DEFAULT_RESPONSE_MESSAGE + "\n" + quote;
        return buildResponseWithMessage(message);

    }

    public ResponseObject getMotivationalQuote() {

        String quote = quoteService.getMotivationalQuote();
        String message = "Here's a motivational quote:\n" + quote;
        return buildResponseWithMessage(message);

    }

    public ResponseObject getJoke() {

        String joke = jokeService.getJoke();
        String message = "Here's a joke:\n" + joke;
        return buildResponseWithMessage(joke);

    }

    public ResponseObject buildResponseWithMessage(String message){
        ResponseObject response = new ResponseObject();
        response.setMessage(message);
        return response;
    }

    public ResponseObject getTodaysWordleSolution(){
        String wordleSolution = wordleService.getTodaysWordleSolution();
        String message = "Did you do today's wordle yet? I think the word was " + wordleSolution;
        return buildResponseWithMessage(message);
    }

        // private

    private ResponseObject generateResponse(HitListData h){


        

        return new ResponseObject();
    }


}
