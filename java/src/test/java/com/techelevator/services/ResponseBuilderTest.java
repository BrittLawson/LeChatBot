package com.techelevator.services;

import com.techelevator.model.Hit;
import com.techelevator.model.HitListData;
import com.techelevator.model.ResponseLink;
import com.techelevator.model.ResponseObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class ResponseBuilderTest {

    private ResponseBuilder sut;

    @Before
    public void setup(){
        sut = new ResponseBuilder();
    }

    @Test
    public void buildDefaultResponse_returns_expected_response_object(){
        ResponseObject ro = sut.buildDefaultResponse();
        String defaultResponsePrefix = "Sorry, I didn't find anything relevant. Here's a meowtivational quote:";
        Assert.assertTrue(ro.getMessage().contains(defaultResponsePrefix));
    }

    @Test
    public void getJoke_returns_expected_response_object(){
        ResponseObject ro = sut.getJoke();
        String jokePrefix = "Here's a joke:";
        Assert.assertTrue(ro.getMessage().contains(jokePrefix));
    }

    @Test
    public void buildResponseWithMessage_returns_expected_response_object(){

        String testMessage = "One Two Three";

        ResponseObject ro  = sut.buildResponseWithMessage(testMessage);

        Assert.assertEquals(testMessage, ro.getMessage());

    }

    @Test
    public void getTodaysWordleSolution_returns_expected_response_object(){
        ResponseObject ro = sut.getTodaysWordleSolution();
        String expectedMessage = "Did you do today's Wordle yet? I think the word starts with";
        Assert.assertTrue(ro.getMessage().contains(expectedMessage));
    }

    @Test
    public void getResponseLinkFromHit_returns_expected_response_link(){
        Hit testHit = new Hit();
        testHit.setCategory("A");
        testHit.setTopic("B");
        testHit.setExternalUrl("google.com");

        testHit.setModule("Module 1, Lesson 1");

        ResponseLink actual = sut.getResponseLinkFromHit(testHit);
        String expectedMessage = "Here's a link about B. This topic was covered in Module 1, Lesson 1.";

        Assert.assertEquals(expectedMessage, actual.getMessage());

    }

    @Test(expected = IllegalArgumentException.class)
    public void generateResponse_throws_exception_if_passed_null(){
        sut.generateResponse(null);
    }

    @Test
    public void generateResponse_returns_empty_object_if_no_hits(){

        HitListData hitListData = new HitListData();
        ResponseObject ro = sut.generateResponse(hitListData);

        Assert.assertTrue(ro.isEmpty());

    }

    @Test
    public void generateResponse_returns_expected_response_object(){

        HitListDataBuilder hitListDataBuilder = new HitListDataBuilder();

        Hit testHitOne = new Hit();
        Hit testHitTwo = new Hit();
        Hit testHitThree = new Hit();
        Hit testHitFour = new Hit();

        testHitOne.setTopic("AA");
        testHitTwo.setTopic("employer follow-up");
        testHitThree.setTopic("CC");
        testHitFour.setTopic("DD");

        testHitOne.setCategory("A");
        testHitTwo.setCategory("pathway");
        testHitThree.setCategory("C");
        testHitFour.setCategory("C");

        testHitOne.setExternalUrl("google.com");
        testHitTwo.setExternalUrl("google.com");
        testHitThree.setExternalUrl("google.com");
        testHitFour.setExternalUrl("google.com");

        testHitOne.setModule("Module 1, Lesson 1");
        testHitTwo.setModule("Module 1, Lesson 2");
        testHitThree.setModule("Module 1, Lesson 3");
        testHitFour.setModule("Module 1, Lesson 4");


        List<Hit> hitlist = new ArrayList<>(List.of(testHitOne, testHitTwo, testHitThree, testHitThree, testHitFour));

        HitListData hld = hitListDataBuilder.getHitListDataFromQueryAndListOfHits("test", hitlist);

        ResponseObject ro = sut.generateResponse(hld);

        int actualSize = ro.getLinks().size();
        int expectedSize = 4;

        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertTrue(ro.getMessage().contains("pathway"));

    }


}
