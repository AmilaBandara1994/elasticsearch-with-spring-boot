package com.amila.springbootelasticsearchapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
public class SpringBootElasticsearchAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootElasticsearchAppApplication.class, args);
    }

}
