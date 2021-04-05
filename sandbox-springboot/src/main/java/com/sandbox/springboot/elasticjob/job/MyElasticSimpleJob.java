package com.sandbox.springboot.elasticjob.job;

//import com.dangdang.ddframe.job.api.ShardingContext;
//import com.dangdang.ddframe.job.api.simple.SimpleJob;
//
//import java.text.MessageFormat;
//
//public class MyElasticSimpleJob implements SimpleJob {
//    @Override
//    public void execute(ShardingContext shardingContext) {
//        System.out.println(MessageFormat.format("任务名：{0}, 总片数：{1}, parameter={2}", shardingContext.getJobName(), shardingContext.getShardingTotalCount(), shardingContext.getJobParameter()));
//        switch (shardingContext.getShardingItem()) {
//            case 0:
//                System.out.println("do something by sharding item 0");
//                break;
//            case 1:
//                System.out.println("do something by sharding item 1");
//                break;
//            case 2:
//                System.out.println("do something by sharding item 2");
//                break;
//            case 3:
//                System.out.println("do something by sharding item 2");
//                break;
//            case 4:
//                System.out.println("do something by sharding item 2");
//                break;
//            // case n: ...
//        }
//    }
//}
