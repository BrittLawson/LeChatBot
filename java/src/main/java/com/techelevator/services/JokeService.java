package com.techelevator.services;

import com.techelevator.model.Joke;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

    // == fields ==
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_BASE_URL = "https://icanhazdadjoke.com/";

    // == constructors ==

    // == methods ==
    public String getJoke(){
        String joke = null;
        try{
            Joke response =
                    restTemplate.getForObject(API_BASE_URL, Joke.class);
            joke = response.getJoke();
        } catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return joke;
    }

}
