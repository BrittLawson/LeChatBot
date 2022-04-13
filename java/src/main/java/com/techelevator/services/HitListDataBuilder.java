package com.techelevator.services;

import com.techelevator.model.Hit;
import com.techelevator.model.HitListData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HitListDataBuilder {

    // == fields ==

    private HitListData hitListData;
    private int numUniqueCategories;
    private int numUniqueTopics;
    private Map<String, Integer> categoryFrequency;
    private Map<String, Integer> topicFrequency;
    private List<Hit> sortedHitList;
    private List<String> sortedCategoriesList;
    private List<String> sortedTopicsList;

    // == constructor ==

    public HitListDataBuilder(){
        reset();
    }

    // == methods ==

    public HitListData getHitListDataFromListOfHits(List<Hit> hitList){
        reset();
        analyzeHitList(hitList);
        return hitListData;
    }

    private void analyzeHitList(List<Hit> hitList){

        populateFrequencyTables(hitList);

    }

    private void populateFrequencyTables(List<Hit> hitList){
        for(Hit hit : hitList){

            String topic = hit.getTopic();
            String category = hit.getCategory();

            addOrIncrementTopic(topic);
            addOrIncrementCategory(category);

        }
    }

    private void addOrIncrementTopic(String topic){
        Integer i = topicFrequency.putIfAbsent(topic, 1);
        if(i != null){
            topicFrequency.put(topic, i+1);
        }
    }

    private void addOrIncrementCategory(String category){
        Integer i = categoryFrequency.putIfAbsent(category, 1);
        if(i != null){
            topicFrequency.put(category, i+1);
        }
    }


    private void reset(){
        numUniqueCategories = 0;
        numUniqueTopics = 0;

        Map<String, Integer> categoryFrequency = new HashMap<>();
        Map<String, Integer> topicFrequency = new HashMap<>();
        List<Hit> sortedHitList = new ArrayList<>();
        List<String> categoriesList = new ArrayList<>();
        List<String> topicsList = new ArrayList<>();
    }

    private List<String> getSortedCategories(List<Hit> rawHitList){
        return null;
    }

    public List<String> getSortedTopics(List<Hit> rawHitList){
        return null;
    }

    private List<Hit> getSortedHits(List<Hit> rawHitList){

        Map<Hit, Integer> hitFrequencyMap = new HashMap<>();

        for(Hit h : rawHitList){
            Integer i = hitFrequencyMap.putIfAbsent(h, 1);

            if(i != null){
                hitFrequencyMap.put(h, i + 1);
            }
        }

        return null;
    }
}
