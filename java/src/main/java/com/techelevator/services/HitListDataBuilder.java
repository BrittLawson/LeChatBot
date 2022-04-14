package com.techelevator.services;

import com.techelevator.model.Hit;
import com.techelevator.model.HitListData;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HitListDataBuilder {

    // == fields ==

    private HitListData hitListData;
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
        populateSortedHitList(hitList);
        populateCategories();
        populateTopics();

        hitListData.setSortedHitList(sortedHitList);
        hitListData.setCategoriesList(sortedCategoriesList);
        hitListData.setTopicsList(sortedTopicsList);
        hitListData.setCategoryFrequency(categoryFrequency);
        hitListData.setTopicFrequency(topicFrequency);
        hitListData.setNumUniqueCategories(sortedCategoriesList.size());
        hitListData.setNumUniqueTopics(sortedTopicsList.size());

    }

    private void populateCategories(){
        for(String category : categoryFrequency.keySet()){
            sortedCategoriesList.add(category);
        }

        Collections.sort(sortedCategoriesList, (o1, o2) -> {

            if(!categoryFrequency.containsKey(o2)) return -1;
            if(!categoryFrequency.containsKey(o2)) return 1;

            return categoryFrequency.get(o2) - categoryFrequency.get(o1);
        });

    }

    private void populateTopics(){
        for(String topic : topicFrequency.keySet()){
            sortedTopicsList.add(topic);
        }

        Collections.sort(sortedTopicsList, (o1, o2) -> {

            if(!topicFrequency.containsKey(o2)) return -1;
            if(!topicFrequency.containsKey(o1)) return 1;

            return topicFrequency.get(o2) - topicFrequency.get(o1);
        });

    }

    private void populateFrequencyTables(List<Hit> hitList){

        for(Hit hit : hitList){

            String topic = hit.getTopic();
            String category = hit.getCategory();

            addOrIncrementTopic(topic);
            addOrIncrementCategory(category);

        }

    }

    private void populateSortedHitList(List<Hit> hitList){
        sortedHitList = new ArrayList<>(new HashSet<>(hitList));

        Collections.sort(sortedHitList, (o1, o2) -> {
            if(o1.getCategory().equals(o2.getCategory())){
                return topicFrequency.get(o2.getTopic()) - topicFrequency.get(o1.getTopic()) ;
            } else {
                return categoryFrequency.get(o2.getCategory()) - categoryFrequency.get(o2.getCategory());
            }
        });
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
            categoryFrequency.put(category, i+1);
        }
    }

    private void reset(){
        categoryFrequency = new HashMap<>();
        topicFrequency = new HashMap<>();
        sortedHitList = new ArrayList<>();
        sortedCategoriesList = new ArrayList<>();
        sortedTopicsList = new ArrayList<>();
        hitListData = new HitListData();
    }
}
