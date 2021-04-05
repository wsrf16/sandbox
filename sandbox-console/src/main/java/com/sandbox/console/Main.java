package com.sandbox.console;

import com.aio.portable.swiss.suite.storage.nosql.file.FilePO;
import com.sandbox.console.async.CallableTest;
import com.sandbox.console.buddy.sample.BuddyMysqlSample;
import com.sandbox.console.buddy.sample.BuddySampleA;
import com.sandbox.console.ng.Ngx;

import java.util.*;


public class Main {
    // -javaagent:./sandbox-javaagent/target/sandbox-javaagent-0.0.1-SNAPSHOT.jar=Hello
    // -javaagent:D:\NutDisk\Program\Resource\Library\Java\_solution\Project\sandbox\sandbox-javaagent\target\sandbox-javaagent-0.0.1-SNAPSHOT.jar=Hello
    // -javaagent:./sandbox-javaagent/target/sandbox-javaagent-0.0.1-SNAPSHOT.jar=Hello
    public static void main(String[] args) throws Exception {
        if (1 == 1)
            return;

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        String[] strings = {"1", "2"};
        Singleton.main(strings);



        BitSet bitSet = new BitSet();
        bitSet.set(5);
        bitSet.or(new BitSet(){{set(7);}});
        bitSet.or(new BitSet(){{set(2);}});
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1", "222222222222");
        map.put("1", "222222222222");
        BitSet bitSet111111_ = new BitSet() {{
            set(7);
        }};

        FilePO jCache = FilePO.singletonInstance("db");
        String table = "test1";
        jCache.set("key1", map, table);
        List<String> keys = jCache.keys(table);
        List<String> tables = jCache.tables();
        Map key1 = jCache.get("key1", Map.class, table);
        Map key2 = jCache.get( "key1", Map.class, table);
        FilePO.removeDatabase("default");


//        ErPrinter proxy = new ErPrinterHandler(new ErPrinterImpl()).createProxy();
//        proxy.out();
//        ErPrinter proxy1 = JDKHandler.<ErPrinterImpl>createProxy(new ErPrinterHandler());
//        proxy1.out();


//        Trans trans = null;
//        ServiceLoader<Trans> serviceLoader = ServiceLoader.load(Trans.class);
//        Iterator<Trans> searchs = serviceLoader.iterator();
//        if (searchs.hasNext()) {
//            trans = searchs.next();
//            trans = trans;
//        }
        new CallableTest().main();

        String s = MD5.encrytMD5("1");
        Ngx.todo();
//        File logbackFile = new File("./conf/logback.xml");
//        if (logbackFile.exists()) {
//            LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//            JoranConfigurator configurator = new JoranConfigurator();
//            configurator.setContext(lc);
//            lc.reset();
//            try {
//                configurator.doConfigure(logbackFile);
//            }
//            catch (JoranException e) {
//                e.printStackTrace(System.err);
//                System.exit(-1);
//            }
//        }



//        Excel2Pdf.excel2pdf("d:/1.xlsx");



//        new NettySample().todo(args);
        new BuddySampleA().print();
        new BuddyMysqlSample().statichello();

        BuddyMysqlSample buddyMysqlSample = new BuddyMysqlSample();
        buddyMysqlSample.dynamichello();
        buddyMysqlSample.todo();

//        new LockTest().main();
//        NotifyTest.main(null);

//        new DriverClass().todo();

        System.out.println("Hello World!");
        System.in.read();

    }


}





