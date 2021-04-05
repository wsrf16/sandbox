package com.sandbox.springboot.es;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "testblog", type = "article")
//@Document(indexName = "testblog", type = "article", shards = 1, replicas = 0, refreshInterval = "-1")
public class TestBlog implements Serializable {
    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TestBlog(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public TestBlog() {
    }
}