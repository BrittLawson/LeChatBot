package com.techelevator.services;

import com.techelevator.model.Hit;
import com.techelevator.model.HitListData;
import com.techelevator.model.ResponseLink;
import com.techelevator.model.ResponseObject;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ResponseBuilder {

    // == fields ==
    private static final String DEFAULT_RESPONSE_MESSAGE = "Sorry, I didn't find anything relevant. Here's a meowtivational quote:\n";
    private QuoteService quoteService;
    private JokeService jokeService;
    private WordleService wordleService;

    private final List<String> prefixes = new ArrayList<>(
            List.of("Sure, I can help you with ",
                    "Yes, let me show you what I know about ",
                    "Ok, you want to know about ",
                    "I'd love to help you with ",
                    "That's a meow-mazing question! Here's what I know on the topic of ",
                    "Purrrfect question! Here's some information about ")
    );



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
        String message = "Here's a meowtivational quote:\n" + quote;
        return buildResponseWithMessage(message);

    }

    public ResponseObject getJoke() {

        String joke = jokeService.getJoke();
        String message = "Here's a joke:\n" + joke;
        return buildResponseWithMessage(message);

    }

    public ResponseObject buildResponseWithMessage(String message){
        ResponseObject response = new ResponseObject();
        response.setMessage(message);
        return response;
    }

    public ResponseObject getTodaysWordleSolution(){
        String wordleSolution = wordleService.getTodaysWordleSolution();
        String message = "Did you do today's Wordle yet? I think the word starts with \"" + wordleSolution.charAt(0) + "\"";
        return buildResponseWithMessage(message);
    }

        // private

    private ResponseObject generateResponse(HitListData hitListData){

        ResponseObject ro = new ResponseObject();


            if( ! hitListData.isEmpty() ) {

            String topCategory = hitListData.getCategoriesList().get(0);

            if(hitListData.getCategoriesList().contains("joke")){
                return getJoke();
            }

            if(hitListData.getCategoriesList().contains("quote")){
                return getMotivationalQuote();
            }

            Collections.shuffle(prefixes);
            String messagePrefix = prefixes.get(0);
            String messageSuffix = topCategory;


            List<ResponseLink> responseLinks = new ArrayList<>();

            if(hitListData.getNumUniqueTopics()==1){
                messageSuffix = hitListData.getTopicsList().get(0);
            }

            if(hitListData.getQuery().contains("help")){
                messagePrefix = "Sure, I can help mew! ";
                messageSuffix = "";
            }

            ro.setMessage(messagePrefix + messageSuffix);


            for(Hit hit : hitListData.getSortedHitList()){

                ResponseLink responseLink = getResponseLinkFromHit(hit);

                if(responseLink != null){
                    responseLinks.add(responseLink);
                }

            }

            for(ResponseLink link : responseLinks){
                ro.addLink(link);
            }
        }

        return ro;
    }

    private ResponseLink getResponseLinkFromHit(Hit hit){

        ResponseLink responseLink = null;

        String category = hit.getCategory();

        if(!category.equals("pathway")){
            responseLink = new ResponseLink();
            if(hit.getModule().equals("Module 0, Lesson 0")){
                responseLink.setMessage("Here's a link about " + hit.getTopic() + ".") ;
            }
            else responseLink.setMessage("Here's a link about " + hit.getTopic() + ". " + "This topic was covered in " + hit.getModule() + ".") ;
            responseLink.setUrl(hit.getExternalUrl());
        } else {
            responseLink = new ResponseLink();
            responseLink.setMessage("Here's a link for " + hit.getTopic() + ".");
            responseLink.setFrontendRoutingParam(getRoutingParam(hit.getTopic()));
        }

        return responseLink;
    }

    private String getRoutingParam(String topic){

        Map<String, String> topicToRoutingKeywordsMap = new HashMap<>();

        topicToRoutingKeywordsMap.put("employer follow-up", "EmployerFollowUp");
        topicToRoutingKeywordsMap.put("interview fashion", "InterviewFashion");
        topicToRoutingKeywordsMap.put("interview preparation", "InterviewPrep");
        topicToRoutingKeywordsMap.put("sample STAR interview question", "StarQuestions");

        if(topicToRoutingKeywordsMap.containsKey(topic)){
            return topicToRoutingKeywordsMap.get(topic);
        }

        else throw new IllegalArgumentException("Bad! Topic param must be one of the meow-gic ones in our map.");

    }


}
