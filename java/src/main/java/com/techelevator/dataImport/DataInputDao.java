package com.techelevator.dataImport;

import java.util.List;

public interface DataInputDao {

    void updateBasicData();

    void updateTopicData();

    void populateCategories(List<String> categories);

    void populateModules(List<String> modules);

    void populateLessons(List<String> lessons);

    void populateExternalLinks(List<String> external_links);

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
