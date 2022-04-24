package com.sandbox.springboot.runner;

import com.sandbox.springboot.es.TestBlog;
import com.sandbox.springboot.neo4j.PersonRepository;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

//@Component
public class ESRunner implements ApplicationRunner {

//    @Autowired
//    private TestBlogRepository testBlogRepository;

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
//        testBlogRepository.save(testBlog);
    }
}
