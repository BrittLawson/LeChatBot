package com.techelevator.dataImport;

import java.util.List;

public interface DataInputDao {

    void clearData();
    void populateData();

    int populateCategory(String category);

    int populateModule(String module);

    int populateLesson(String lesson);

    int populateExternalLink(String external_link);

    int populateTopic(String topic, int category, int module, int lesson, int externalLink);

    int populateKeyword(String keyword);

    void populateTopicToKeyword(int topicId, int keywordId);

    int getCategoryId(String category);

    int getModuleId(String module);

    int getLessonId(String lesson);

    int getTopicId(String topic);

    int getExternalLinkId(String link);

    int getKeywordId(String keyword);




}
