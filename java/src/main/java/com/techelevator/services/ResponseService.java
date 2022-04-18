package com.techelevator.services;

import com.techelevator.dao.HitDao;
import com.techelevator.model.Hit;
import com.techelevator.model.HitListData;
import com.techelevator.model.ResponseObject;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;

@Component
public class ResponseService {

    // == fields ==
    private HitDao hitDao;
    private HitListDataBuilder hitListDataBuilder;
    private ResponseBuilder responseBuilder;
    private QueryParser queryParser;


    // == constructor ==

    public ResponseService(HitDao hitDao, HitListDataBuilder hitListDataBuilder, ResponseBuilder responseBuilder, QueryParser queryParser) {
        this.hitDao = hitDao;
        this.hitListDataBuilder = hitListDataBuilder;
        this.responseBuilder = responseBuilder;
        this.queryParser = queryParser;
    }


    // == methods ==

    public ResponseObject getResponseForQuery(String query, Principal principal){

        if(query.toLowerCase().contains("wordle")){
            return getTodaysWordleSolution();
        }

        HitListData hitListData = getHitListDataForQuery(query);
        ResponseObject response = responseBuilder.getResponseObjectFromHitListData(hitListData);
        return response;

    }

    public ResponseObject getJoke(){
        return responseBuilder.getJoke();
    }

    public ResponseObject getMotivationalQuote(){
        return responseBuilder.getMotivationalQuote();
    }

    public ResponseObject getDefaultResponse(){
        return responseBuilder.buildDefaultResponse();
    }

    public ResponseObject getTodaysWordleSolution(){
        return responseBuilder.getTodaysWordleSolution();
    }

    private HitListData getHitListDataForQuery(String query){
        List<Hit> hitList = getHitListForQuery(query);
        return hitListDataBuilder.getHitListDataFromQueryAndListOfHits(query, hitList);
    }

    private List<Hit> getHitListForQuery(String query){
        List<String> keywords = queryParser.getPotentialKeywordsFromQuery(query);
        return hitDao.getHits(keywords);
    }



}
