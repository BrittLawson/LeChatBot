package com.techelevator.services;

import com.techelevator.model.Hit;
import com.techelevator.model.HitListData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class HitListDataBuilderTest {

    private HitListDataBuilder sut;
    private Hit testHitOne = new Hit();
    private Hit testHitTwo = new Hit();
    private Hit testHitThree = new Hit();
    private Hit testHitFour = new Hit();

    @Before
    public void setup(){
        sut = new HitListDataBuilder();
    }

    @Test
    public void populateCategories_properly_sorts_categories(){

        sut.addOrIncrementCategory("A");
        sut.addOrIncrementCategory("B");
        sut.addOrIncrementCategory("B");
        sut.addOrIncrementCategory("B");
        sut.addOrIncrementCategory("B");
        sut.addOrIncrementCategory("C");
        sut.addOrIncrementCategory("C");
        sut.addOrIncrementCategory("C");
        sut.addOrIncrementCategory("pathway");

        sut.populateCategories();

        List<String> expected = new ArrayList<>(List.of("pathway", "B", "C", "A"));

        Assert.assertEquals(expected, sut.getSortedCategoriesList());

    }

    @Test
    public void populateTopics_properly_sorts_topics(){
        sut.addOrIncrementTopic("AA");
        sut.addOrIncrementTopic("AA");
        sut.addOrIncrementTopic("AA");
        sut.addOrIncrementTopic("BB");
        sut.addOrIncrementTopic("BB");
        sut.addOrIncrementTopic("CC");
        sut.addOrIncrementTopic("DD");
        sut.addOrIncrementTopic("DD");
        sut.addOrIncrementTopic("DD");
        sut.addOrIncrementTopic("DD");

        sut.populateTopics();

        List<String> expected = new ArrayList<>(List.of("DD", "AA", "BB", "CC"));

        Assert.assertEquals(expected, sut.getSortedTopicsList());
    }

    @Test
    public void populateSortedHitList_properly_populates_hitlist(){

        sut.addOrIncrementTopic("AA");
        testHitOne.setTopic("AA");

        sut.addOrIncrementTopic("BB");
        testHitTwo.setTopic("BB");

        sut.addOrIncrementTopic("CC");
        sut.addOrIncrementTopic("CC");
        testHitThree.setTopic("CC");

        sut.addOrIncrementTopic("DD");
        testHitFour.setTopic("DD");


        sut.addOrIncrementCategory("A");
        testHitOne.setCategory("A");

        sut.addOrIncrementCategory("pathway");
        testHitTwo.setCategory("pathway");

        sut.addOrIncrementCategory("C");
        sut.addOrIncrementCategory("C");
        testHitThree.setCategory("C");

        sut.addOrIncrementCategory("C");
        testHitFour.setCategory("C");

        List<Hit> hitlist = new ArrayList<>(List.of(testHitOne, testHitTwo, testHitThree, testHitFour));
        List<Hit> expected = new ArrayList<>(List.of(testHitTwo, testHitThree, testHitFour, testHitOne));

        sut.populateSortedHitList(hitlist);

        for(Hit h : sut.getSortedHitList()){
            System.out.println("Category: " + h.getCategory() + " - " + sut.getCategoryFrequency(h.getCategory()));
            System.out.println("Topic: " + h.getTopic() + " - " + sut.getTopicFrequency(h.getTopic()));
            System.out.println();
        }

        Assert.assertEquals(expected, sut.getSortedHitList());

    }

    @Test
    public void getHitListDataFromQueryAndListOfHits(){
        testHitOne.setTopic("AA");
        testHitTwo.setTopic("BB");
        testHitThree.setTopic("CC");
        testHitFour.setTopic("DD");

        testHitOne.setCategory("A");
        testHitTwo.setCategory("pathway");
        testHitThree.setCategory("C");
        testHitFour.setCategory("C");

        List<Hit> hitlist = new ArrayList<>(List.of(testHitOne, testHitTwo, testHitThree, testHitThree, testHitFour));

        HitListData hitListData = sut.getHitListDataFromQueryAndListOfHits("test", hitlist);

        List<Hit> actualSortedHitList = hitListData.getSortedHitList();
        List<Hit> expectedSortedHitList = new ArrayList<>(List.of(testHitTwo, testHitThree, testHitFour, testHitOne));

        Assert.assertEquals(expectedSortedHitList, actualSortedHitList);

        String actualTopCategory = hitListData.getCategoriesList().get(0);
        String expectedTopCategory = "pathway";

        Assert.assertEquals(expectedTopCategory, actualTopCategory);

    }

}
