package com.techelevator.services;


import com.techelevator.model.Quote;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class QuoteService {

    // == fields ==
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_BASE_URL = "https://zenquotes.io/api/random";

    // == constructors ==

    // == methods ==
    public String getMotivationalQuote(){
        String formattedQuote = null;
        try{
            Quote[] response =
                    restTemplate.getForObject(API_BASE_URL, Quote[].class);
            formattedQuote = "\"" + response[0].getQuote() + "\" - " + response[0].getAuthor();
        } catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return formattedQuote;
    }

}
