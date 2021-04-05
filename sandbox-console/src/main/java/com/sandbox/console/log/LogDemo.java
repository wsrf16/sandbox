package com.sandbox.console.log;


import com.aio.portable.swiss.suite.log.LogHub;

public class LogDemo {
    // 同步日志
    static LogHub logAsync = LogFactory.logHub();
    // 异步日志
    static LogHub log = LogFactory.logHub();

    public static void todo() {
        try {
            int c = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            log.e("错误日志", "在计算1/0时抛出异常！", e);
        }

        int a = 1;
        int b = 2;
        int c = a + b;
        log.d("调试日志", "计算结果{}+{}={}", new Object[]{a, b, c});

        Order order = new Order();
        order.setId("123456789");
        order.setName("订单名称");
        log.d("订单记录", order);


    }

    static class Order {
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
