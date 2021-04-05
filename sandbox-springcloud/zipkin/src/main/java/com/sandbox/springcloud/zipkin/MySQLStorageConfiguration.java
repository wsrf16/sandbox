package com.sandbox.springcloud.zipkin;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import zipkin.storage.mysql.MySQLStorage;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class MySQLStorageConfiguration {
//    @Bean
//    @Primary
//    public MySQLStorage mySQLStorage(DataSource datasource) {
//        return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
//    }
//}
