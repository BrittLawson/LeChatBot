package com.techelevator.services;

import com.techelevator.model.Hit;
import com.techelevator.model.HitListData;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HitListDataBuilder {

    public HitListData getHitListDataFromListOfHits(List<Hit> hitList){
        HitListData hitListData = new HitListData();

        return hitListData;
    }

    public List<String> getSortedCategories(List<Hit> rawHitList){
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
