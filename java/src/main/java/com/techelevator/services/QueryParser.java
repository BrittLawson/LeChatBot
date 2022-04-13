package com.techelevator.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryParser {

    // == fields ==

    // == constructor ==

    // == methods ==

    // takes in a query string, returns a list of potential keywords
    public List<String> getPotentialKeywordsFromQuery(String query){
        List<String> keywordsList = new ArrayList<>();

        // get rid of anything that is not a space or an alpha char
        query = query.replaceAll("[^A-Za-z0-9 ]", "").toLowerCase();

        // split query into separate words
        // "This is an example query"->["This", "is", "an" ..]
        String[] wordArray = query.split(" ");

        // add one-word phrases to keyword list
        for(String word: wordArray){
            keywordsList.add(word);
        }

        // loop through wordArray and build all two-word phrases
        for (int i = 0; i < wordArray.length - 1; i++) {

            // combine current word with next word
            // "This, is, an, example, query"

            String currentWord = wordArray[i];
            String nextWord = wordArray[i + 1];

            String combined = currentWord + " " + nextWord;

            // add that to our list
            keywordsList.add(combined);
        }

        // uncomment to include three-word phrases:

        /*
        for (int i = 0; i < wordArray.length - 2; i++) {

            // combine current word with next word
            // "This, is, an, example, query"

            String currentWord = wordArray[i];
            String nextWord = wordArray[i + 1];
            String nextNextWord = wordArray[i + 2];

            String combined = currentWord + " " + nextWord + " " + nextNextWord;

            // add that to our list
            keywordsList.add(combined);
        }
        */

        return keywordsList;
    }


}
