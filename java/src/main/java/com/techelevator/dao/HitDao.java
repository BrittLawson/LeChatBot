package com.techelevator.dao;

import com.techelevator.model.Hit;

import java.util.List;

public interface HitDao {

   List<Hit> getHits(List<String> keywords);

}
