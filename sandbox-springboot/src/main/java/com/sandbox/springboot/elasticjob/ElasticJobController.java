package com.sandbox.springboot.elasticjob;

//import com.dangdang.ddframe.job.config.JobCoreConfiguration;
//import com.dangdang.ddframe.job.config.JobRootConfiguration;
//import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;
//import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
//import com.dangdang.ddframe.job.lite.api.JobScheduler;
//import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
//import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
//import com.example.springbootmaster.elasticjob.job.MyElasticDataflowJob;
//import com.example.springbootmaster.elasticjob.job.MyElasticSimpleJob;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////@RestController
////@RequestMapping("ElasticJob")
//public class ElasticJobController {
//
//
//    @GetMapping("start")
//    public void start(){
//        new JobScheduler(createRegistryCenter(), createSimpleJobConfiguration()).init();
////        new JobScheduler(createRegistryCenter(), createDataflowJobConfiguration()).init();
//    }
//
//
//    // bean
//    private static CoordinatorRegistryCenter createRegistryCenter() {
//        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(
//                new ZookeeperConfiguration("47.104.190.82:2181", "new-elastic-job-demo"));
//        regCenter.init();
//        return regCenter;
//    }
//
//    private static LiteJobConfiguration createSimpleJobConfiguration() {
//        // 定义作业核心配置
//        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("SimpleJobDemo", "0/15 * * * * ?", 10).build();
//        // 定义SIMPLE类型配置
//        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, MyElasticSimpleJob.class.getCanonicalName());
//        // 定义Lite作业根配置
//        LiteJobConfiguration simpleJobConfiguration = LiteJobConfiguration.newBuilder(simpleJobConfig).build();
//
//        return simpleJobConfiguration;
//
//    }
//
//    private static LiteJobConfiguration createDataflowJobConfiguration() {
//        // 定义作业核心配置
//        JobCoreConfiguration dataflowCoreConfig = JobCoreConfiguration.newBuilder("DataflowJob", "0/30 * * * * ?", 10).build();
//        // 定义DATAFLOW类型配置
//        DataflowJobConfiguration dataflowJobConfig = new DataflowJobConfiguration(dataflowCoreConfig, MyElasticDataflowJob.class.getCanonicalName(), true);
//        // 定义Lite作业根配置
//        LiteJobConfiguration dataflowJobConfiguration = LiteJobConfiguration.newBuilder(dataflowJobConfig).build();
//
//        return dataflowJobConfiguration;
//    }
//}
