package com.techelevator.dataImport;

import com.techelevator.dataImport.JdbcDataInputDao;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataImport {

    public static void main(String[] args) {


        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/final_capstone");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        JdbcDataInputDao importData = new JdbcDataInputDao(dataSource);
        importData.updateBasicData();
        importData.updateTopicData();

    }

}