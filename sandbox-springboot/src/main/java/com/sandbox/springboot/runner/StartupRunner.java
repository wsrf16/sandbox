package com.sandbox.springboot.runner;

import com.sandbox.springboot.annotation.ContextConfiguration;
import com.sandbox.springboot.statement.FSMEvents;
import com.sandbox.springboot.statement.FSMStates;
import com.sandbox.springboot.utils.TT2Enum;
import com.sandbox.springboot.utils.TestEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

/**
 * Created by MPC on 2018/3/16.
 */
@Component
@Order(1)
//@GreaterThan(target = "mmmm", value = "nnnnnn")
//@ContextConfiguration(locations = "abc", value = "cba")
public class StartupRunner implements CommandLineRunner {
    @Autowired
    private StateMachine<FSMStates, FSMEvents> stateMachine;




    @Override
    public void run(String... args) throws Exception {
        ContextConfiguration declaredAnnotation1 = StartupRunner.class.getDeclaredAnnotation(ContextConfiguration.class);
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 11111111 <<<<<<<<<<<<<");


        TT2Enum f1 = TT2Enum.F1;
        TestEnum testEnum = EnumSugar.addEnum(TestEnum.class, "namename", new Class[]{int.class, String.class, String.class}, new Object[]{2, "desc", "extra"});
        String name = testEnum.name();
        System.out.println(EnumSet.allOf(TestEnum.class));


        stateMachine.start();
        System.out.println("------");
        stateMachine.sendEvent(FSMEvents.ToB);
        System.out.println("------");
//        stateMachine.sendEvent(FSMEvents.ToC);
//        System.out.println("------");
//        stateMachine.sendEvent(FSMEvents.ToD);
//        System.out.println("------");
//        stateMachine.sendEvent(FSMEvents.ToA);
        stateMachine.stop();
        System.exit(0);
    }

}
