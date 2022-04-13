package com.techelevator.controller;
import com.techelevator.model.ResponseObject;
import com.techelevator.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@CrossOrigin
public class ChatResponseController {

    // == fields ==
    private ResponseService responseService;

    // == constructor ==
    @Autowired
    public ChatResponseController(ResponseService responseService){
        this.responseService = responseService;
    }

    // == methods ==
    @RequestMapping(path = "/response", method = RequestMethod.GET)
    public ResponseObject getResponseForQuery(@RequestParam String query, Principal principal) {
        return responseService.getResponseForQuery(query, principal);
    }

    @RequestMapping(path = "/response/{topic}", method = RequestMethod.GET)
    public ResponseObject getResponseForQuery(@RequestParam String query, @PathVariable String topic, Principal principal) {
        return responseService.getResponseForQueryInTopic(query, topic, principal);
    }

    @RequestMapping(path = "/response/default", method = RequestMethod.GET)
    public ResponseObject getDefaultResponse() {
        return responseService.getDefaultResponse();
    }

    @RequestMapping(path = "/response/joke", method = RequestMethod.GET)
    public ResponseObject getJoke(){
        return responseService.getJoke();
    }

    @RequestMapping(path = "/response/wordle", method = RequestMethod.GET)
    public ResponseObject getTodaysWordleSolution(){
        return responseService.getTodaysWordleSolution();
    }


}
