package com.techelevator.dao;

import com.techelevator.model.Hit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcHitDao implements HitDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcHitDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hit> getHits(List<String> keywords) {
        List<Hit> hitList = new ArrayList<>();

        for(String word: keywords) {

            String sql =
            "SELECT DISTINCT topic, category, module_name, lesson_name, external_link_url " +
            "FROM topic " +
            "JOIN category USING (category_id) " +
            "JOIN modules USING (module_id) " +
            "JOIN lesson USING (lesson_id) " +
            "JOIN external_link USING (external_link_id) " +
            "JOIN topic_to_keyword USING (topic_id) " +
            "JOIN keyword USING (keyword_id) " +
            "WHERE keyword.keyword ILIKE ? ;";


            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, word);

            while (results.next()) {
                Hit thisHit = mapRowToHit(results);
                hitList.add(thisHit);
            }

        }
        return hitList;
    }

    private Hit mapRowToHit(SqlRowSet rs) {
        Hit hit = new Hit();

        hit.setTopic(rs.getString("topic"));
        hit.setCategory(rs.getString("category"));
        hit.setModule(rs.getString("module_name")+ ", " +rs.getString("lesson_name") );
        hit.setExternalUrl(rs.getString("external_link_url"));

        return hit;
    }


}




