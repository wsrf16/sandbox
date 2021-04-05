package com.sandbox.springboot;

import com.sandbox.springboot.db.Entity.BookStore;
import com.sandbox.springboot.db.Service.BookStoreService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.exporter.MetricsServlet;
import io.prometheus.client.hotspot.DefaultExports;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.ValueOperations;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Random;

//@ConfigurationProperties
//@EnableAutoConfiguration

//@RestController
@Controller
@RequestMapping("/")
@Api("HomeController类接口")
public class HomeController {
    public String index() {
        return "Hello Spring Boot!";
    }


    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/getHello", method = RequestMethod.GET)
    @ResponseBody
    public String getHello() {
        return "Hello Spring Boot!";
    }


    @Autowired(required = false)
    private BookStoreService bookStoreService;

    @ApiOperation(value = "添加一本书")
    @ResponseBody
    @RequestMapping(value = "/insertBook", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public String insertBook() {
        BookStore bookStore = new BookStore("brave heart", "William Shakespeare");
        bookStoreService.save(bookStore);
        return "结果" + bookStore.getId();
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/page", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "size", value = "按每页size条记录进行分页", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public List<BookStore> page(Integer size, Integer page) {
        List<BookStore> ret = bookStoreService.page(size, page);
        return ret;
    }


//    @Autowired
//    RedisCache redisCache;

//    ValueOperations<String, String> cache() {
//        return redisCache.getStringStringValueOperations();
//    }
//
//    @ApiOperation(value = "写入缓存")
//    @RequestMapping(value = "/setCache", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "key", value = "key值", required = true, dataType = "String", paramType = "query"),
//            @ApiImplicitParam(name = "val", value = "val值", required = true, dataType = "String", paramType = "query")
//    })
//    @ResponseBody
//    public String setCache(String key, String val) {
//        cache().set(key, val);
//        return val;
//    }

//    @ApiOperation(value = "缓存读取")
//    @RequestMapping(value = "/getCache", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
//    @ApiImplicitParam(name = "key", value = "key值", required = true, dataType = "String", paramType = "query")
//    @ResponseBody
//    public String getCache(String key) {
//        return cache().get(key);
//    }


    @Autowired
    private AmqpTemplate rabbitTemplate;

    @GetMapping(value = "/send")
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }


    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        DefaultExports.initialize();
        return new ServletRegistrationBean(new MetricsServlet(), "/metrics");
    }


    private static Random random = new Random();

    private static final Counter requestTotal = Counter.build()
            .name("my_sample_counter")
            .labelNames("status")
            .help("A simple Counter to illustrate custom Counters in Spring Boot and Prometheus").register();

    @GetMapping("/endpoint")
    public void endpoint() {
        if (random.nextInt(2) > 0) {
            requestTotal.labels("success").inc();
        } else {
            requestTotal.labels("error").inc();
        }
    }


//    @Bean
//    public Counter requestTotalCountCollector(){
//        return  Counter.build()
//                .name("http_requests_total")
//                .labelNames("path", "method", "code")
//                .help("http请求总计数").register(collectorRegistry);
//    }

//    @Bean
//    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
//        new PrometheusMeterRegistry(PrometheusConfig.DEFAULT).
//        return registry -> registry.config().commonTags("region", "us-east-1");
//    }
}
