package com.sandbox.springboot.runner;

import com.sandbox.springboot.es.TestBlog;
import com.sandbox.springboot.es.TestBlogRepository;

import com.sandbox.springboot.neo4j.PersonRepository;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

//@Component
public class ESRunner implements ApplicationRunner {

    @Autowired
    private TestBlogRepository testBlogRepository;

    @Autowired
    TransportClient transportClient;

    @Autowired
    PersonRepository personRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        TestBlog testBlog = new TestBlog();
        testBlog.setId(System.currentTimeMillis());
        testBlog.setName("明纸");
        testBlog.setDescription("okokok");
        testBlogRepository.save(testBlog);

        int i = 0;
        if (i == 0)
            return;
        return;
    }
}
