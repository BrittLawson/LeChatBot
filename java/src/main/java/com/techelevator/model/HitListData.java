package com.techelevator.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HitListData {

    // == fields ==

    private int numUniqueCategories;
    private int numUniqueTopics;

    private Map<String, Integer> categoryFrequency;
    private Map<String, Integer> topicFrequency;
    private List<Hit> sortedHitList;
    private List<String> categoriesList;
    private List<String> topicsList;
    private String query;

    // == constructor ==

    // == methods  ==

    public boolean isEmpty(){
        return numUniqueCategories == 0 &&
                numUniqueTopics == 0;
    }

    // == getters and setters ==

    public int getNumUniqueCategories() {
        return numUniqueCategories;
    }

    public HitListData setNumUniqueCategories(int numUniqueCategories) {
        this.numUniqueCategories = numUniqueCategories;
        return this;
    }

    public int getNumUniqueTopics() {
        return numUniqueTopics;
    }

    public HitListData setNumUniqueTopics(int numUniqueTopics) {
        this.numUniqueTopics = numUniqueTopics;
        return this;
    }

    public Map<String, Integer> getCategoryFrequency() {
        return categoryFrequency;
    }

    public HitListData setCategoryFrequency(Map<String, Integer> categoryFrequency) {
        this.categoryFrequency = categoryFrequency;
        return this;
    }

    public Map<String, Integer> getTopicFrequency() {
        return topicFrequency;
    }

    public HitListData setTopicFrequency(Map<String, Integer> topicFrequency) {
        this.topicFrequency = topicFrequency;
        return this;
    }

    public List<Hit> getSortedHitList() {
        return sortedHitList;
    }

    public HitListData setSortedHitList(List<Hit> sortedHitList) {
        this.sortedHitList = sortedHitList;
        return this;
    }

    public List<String> getCategoriesList() {
        return categoriesList;
    }

    public HitListData setCategoriesList(List<String> categoriesList) {
        this.categoriesList = categoriesList;
        return this;
    }

    public List<String> getTopicsList() {
        return topicsList;
    }

    public HitListData setTopicsList(List<String> topicsList) {
        this.topicsList = topicsList;
        return this;
    }

    public String getQuery() {
        return query;
    }

    public HitListData setQuery(String query) {
        this.query = query;
        return this;
    }
}
