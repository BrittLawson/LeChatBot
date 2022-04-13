package com.techelevator.dataImport;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class JdbcDataInputDao implements DataInputDao {

    private JdbcTemplate jdbcTemplate;


    private static final String DELIMITER_REGEX = ",";
    private static final String DELIMITER_KEYWORD_REGEX = "\\|";
    public static final String INPUT_FILE_PATH = "src/main/resources/chatbot_data.csv";

    private File inputFile;



    public JdbcDataInputDao(DataSource dataSource){

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        inputFile = new File(INPUT_FILE_PATH);

    }

    private List<String> categories = new ArrayList<>();
    private List<String> modules = new ArrayList<>();
    private List<String> lessons = new ArrayList<>();
    private List<String> external_links = new ArrayList<>();
    private List<String> topics = new ArrayList<>();
    private List<String> keywords = new ArrayList<>();

    @Override
    public void updateBasicData() {
        try(Scanner scanner = new Scanner(inputFile)){
            int lineCount = 0;
            while(scanner.hasNextLine()){
                lineCount++;
                String line = scanner.nextLine();
                if(lineCount == 1) continue;
                if(line.equals("")) continue;

                String[] data = line.split(DELIMITER_REGEX);

                String category = data[3];
                String module = "Module " + data[4].substring(1,2);
                String lesson = "Lesson " + data[4].substring(3);
                String external_link = data[5];

                if (!categories.contains(category) && category != null) categories.add(category);
                if (!modules.contains(module) && !module.equals("")) modules.add(module);
                if (!lessons.contains(lesson) && !lesson.equals("")) lessons.add(lesson);
                if (!external_links.contains(external_link) && !external_link.equals("")) external_links.add(external_link);

            }
            //populate category, module, and lesson data
            populateCategories(categories);
            populateModules(modules);
            populateLessons(lessons);
            populateExternalLinks(external_links);

        } catch (IOException e){
            System.out.println("Error reading from file " + inputFile.getPath());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateTopicData() {

        try(Scanner scanner = new Scanner(inputFile)){
            int lineCount = 0;
            while(scanner.hasNextLine()){
                lineCount++;
                String line = scanner.nextLine();
                if(lineCount == 1) continue;
                if(line.equals("")) continue;

                String[] data = line.split(DELIMITER_REGEX);

                String topic = data[1];
                String category = data[3];
                String keywordString = data[2];
                String module = "Module " + data[4].substring(1,2);
                String lesson = "Lesson " + data[4].substring(3);
                String external_link = data[5];

                int categoryId = 0;
                int moduleId = 0;
                int lessonId = 0;
                int externalLinkId = 0;

                if (!topics.contains(category) && topic != null) topics.add(topic);
                if (!module.equals("")) categoryId = getCategoryId(category);
                if (!module.equals("")) moduleId = getModuleId(module);
                if (!lesson.equals("")) lessonId = getLessonId(lesson);
                if (!external_link.equals("")) externalLinkId= getExternalLinkId(external_link);

                int topicId = populateTopic(topic, categoryId, moduleId, lessonId, externalLinkId);

                String[] keywordData = keywordString.split(DELIMITER_KEYWORD_REGEX);

                for(String keyword:keywordData){
                    keyword = keyword.trim();
                    int keywordId = 0;
                    if (!keywords.contains(keyword) && keyword != null) {
                        keywords.add(keyword);
                        keywordId = populateKeyword(keyword);
                    } else{
                        keywordId = getKeywordId(keyword);
                    }
                    populateTopicToKeyword(topicId, keywordId);
                }
            }

        } catch (IOException e){
            System.out.println("Error reading from file " + inputFile.getPath());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void populateCategories(List<String> categories) {
        for(String category:categories){
            String sql = "INSERT INTO category (category) VALUES (?);";
            jdbcTemplate.update(sql, category);
        }
    }

    @Override
    public void populateModules(List<String> modules) {
        for(String module:modules){
            String sql = "INSERT INTO modules (module_name) VALUES (?);";
            jdbcTemplate.update(sql, module);
        }
    }

    @Override
    public void populateLessons(List<String> lessons) {
        for(String lesson:lessons){
            String sql = "INSERT INTO lesson (lesson_name) VALUES (?);";
            jdbcTemplate.update(sql, lesson);
        }
    }

    @Override
    public void populateExternalLinks(List<String> external_links) {
        for(String link: external_links){
            String sql = "INSERT INTO external_link (external_link_url) VALUES (?);";
            jdbcTemplate.update(sql, link);
        }
    }

    @Override
    public int populateTopic(String topic, int category, int module, int lesson, int externalLink) {
        String sql = "INSERT INTO topic (topic, category_id, module_id, lesson_id, external_link_id) VALUES (?,?,?,?,?) RETURNING topic_id;";
        return jdbcTemplate.queryForObject(sql, int.class, topic, category, module, lesson, externalLink);
    }

    @Override
    public int populateKeyword(String keyword) {
            String sql = "INSERT INTO keyword (keyword) VALUES (?) RETURNING keyword_id;";
            return jdbcTemplate.queryForObject(sql, int.class, keyword);
    }

    @Override
    public void populateTopicToKeyword(int topicId, int keywordId) {
        String sql = "INSERT INTO topic_to_keyword (topic_id, keyword_id) VALUES (?,?);";
        jdbcTemplate.update(sql, topicId, keywordId);
    }


    @Override
    public int getCategoryId(String category) {
        String sql = "SELECT category_id FROM category WHERE category = ?;";
        return jdbcTemplate.queryForObject(sql, int.class, category);
    }

    @Override
    public int getModuleId(String module) {
        String sql = "SELECT module_id FROM modules WHERE module_name = ?;";
        return jdbcTemplate.queryForObject(sql, int.class, module);
    }

    @Override
    public int getLessonId(String lesson) {
        String sql = "SELECT lesson_id FROM lesson WHERE lesson_name = ?;";
        return jdbcTemplate.queryForObject(sql, int.class, lesson);
    }

    @Override
    public int getTopicId(String topic) {
        String sql = "SELECT topic_id FROM topic WHERE topic = ?;";
        return jdbcTemplate.queryForObject(sql, int.class, topic);
    }

    @Override
    public int getExternalLinkId(String link) {
        String sql = "SELECT external_link_id FROM external_link WHERE external_link_url = ?;";
        return jdbcTemplate.queryForObject(sql, int.class, link);
    }

    @Override
    public int getKeywordId(String keyword) {
        String sql = "SELECT keyword_id FROM keyword WHERE keyword = ?;";
        return jdbcTemplate.queryForObject(sql, int.class, keyword);
    }

}
