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

    public HitListData getHitListDataFromQueryAndListOfHits(String query, List<Hit> hitList){
        reset();
        analyzeHitList(hitList);
        hitListData.setQuery(query);
        return hitListData;
    }

    public void analyzeHitList(List<Hit> hitList){

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

    public void populateCategories(){

        if(categoryFrequency == null){
            throw new IllegalStateException("categoryFrequencyMap must be instantiated before calling this method.");
        }

        for(String category : categoryFrequency.keySet()){
            sortedCategoriesList.add(category);
        }

        Collections.sort(sortedCategoriesList, (o1, o2) -> {

            if(o1.equals("pathway")) return -1;
            if(o2.equals("pathway")) return 1;

            if(!categoryFrequency.containsKey(o2)) return -1;
            if(!categoryFrequency.containsKey(o1)) return 1;

            return categoryFrequency.get(o2) - categoryFrequency.get(o1);
        });

    }

    public void populateTopics(){

        if(topicFrequency == null){
            throw new IllegalStateException("topicFrequency map must be instantiated before calling this method.");
        }

        for(String topic : topicFrequency.keySet()){
            sortedTopicsList.add(topic);
        }

        Collections.sort(sortedTopicsList, (o1, o2) -> {

            if(!topicFrequency.containsKey(o2)) return -1;
            if(!topicFrequency.containsKey(o1)) return 1;

            return topicFrequency.get(o2) - topicFrequency.get(o1);
        });

    }

    public void populateFrequencyTables(List<Hit> hitList){

        for(Hit hit : hitList){

            String topic = hit.getTopic();
            String category = hit.getCategory();

            addOrIncrementTopic(topic);
            addOrIncrementCategory(category);

        }

    }

    public void populateSortedHitList(List<Hit> hitList){

        if(categoryFrequency == null || topicFrequency == null){
            throw new IllegalStateException();
        }

        sortedHitList = new ArrayList<>(new HashSet<>(hitList));

        Collections.sort(sortedHitList, (o1, o2) -> {
            if(o1.getCategory().equals(o2.getCategory())){
                return topicFrequency.get(o2.getTopic()) - topicFrequency.get(o1.getTopic()) ;
            } else {
                if(o1.getCategory().equals("pathway")) return -1;
                if(o2.getCategory().equals("pathway")) return 1;
                return categoryFrequency.get(o2.getCategory()) - categoryFrequency.get(o1.getCategory());
            }
        });
    }

    public void addOrIncrementTopic(String topic){
        Integer i = topicFrequency.putIfAbsent(topic, 1);
        if(i != null){
            topicFrequency.put(topic, i+1);
        }
    }

    public void addOrIncrementCategory(String category){
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

    // for testing
    public List<String> getSortedCategoriesList(){
        return sortedCategoriesList;
    }

    public List<String> getSortedTopicsList(){
        return sortedTopicsList;
    }

    public List<Hit> getSortedHitList(){
        return sortedHitList;
    }

    public int getCategoryFrequency(String category){
        return categoryFrequency.get(category);
    }

    public int getTopicFrequency(String topic){
        return topicFrequency.get(topic);
    }

}
