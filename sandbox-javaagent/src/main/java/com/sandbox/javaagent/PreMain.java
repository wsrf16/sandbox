package com.sandbox.javaagent;

import com.aio.portable.swiss.suite.bytecode.bytebuddy.AgentBuilderSugar;
import com.aio.portable.swiss.suite.bytecode.bytebuddy.interceptorpoint.MethodInterceptorPoint;
import com.aio.portable.swiss.suite.bytecode.bytebuddy.interceptorpoint.TypeInterceptorPoint;
import com.aio.portable.swiss.suite.bytecode.bytebuddy.sample.annotation.JavaAgentInterceptor;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.Collection;


public class PreMain {
    public static void main(String[] args) {
        System.out.println("Hello World! PreMain.main");
    }


    public static void sample(Instrumentation inst) {
        // step one
        Collection<MethodInterceptorPoint> methodInterceptorPointCollection = new ArrayList<>();
        methodInterceptorPointCollection.add(new MethodInterceptorPoint(ElementMatchers.<MethodDescription>any(), MethodDelegation.to(CustomInterceptDelegation.class)));
        methodInterceptorPointCollection.add(new MethodInterceptorPoint(ElementMatchers.<MethodDescription>named("statichello"), MethodDelegation.to(CustomInterceptDelegation.class)));
        AgentBuilder.Transformer transformer = AgentBuilderSugar.buildTransformer(methodInterceptorPointCollection);

        // step two
        Collection<TypeInterceptorPoint> typeInterceptorCollection = new ArrayList<>();
        typeInterceptorCollection.add(new TypeInterceptorPoint(ElementMatchers.named("com.mysql.cj.jdbc.ConnectionImpl"), transformer));
        typeInterceptorCollection.add(new TypeInterceptorPoint(ElementMatchers.named("java.sql.DriverManager"), transformer));
        typeInterceptorCollection.add(new TypeInterceptorPoint(ElementMatchers.nameStartsWith("java.sql"), transformer));
        typeInterceptorCollection.add(new TypeInterceptorPoint(ElementMatchers.nameStartsWith("com.sandbox.console"), transformer));


        AgentBuilderSugar.attachInterceptor(new AgentBuilder.Default(), typeInterceptorCollection)
                .installOn(inst);
    }







    public static void premain(String agentOps, Instrumentation inst)
    {
        System.out.println("Hello World! PreMain.premain(String agentOps, Instrumentation inst)");
        System.out.println("agentOps:" + agentOps);


//        inst.addTransformer(new MyTransformer());

        AgentBuilderSugar.interceptorToAnyMethod(MethodDelegation.to(CustomInterceptDelegation.class).andThen(MethodDelegation.to(MonitorInterceptDelegation.class)), inst,
//        AgentBuilderSugar.interceptorToAnyMethod(MethodDelegation.to(CustomInterceptor.class), inst,
                ElementMatchers.named("com.mysql.cj.jdbc.ConnectionImpl"),
                ElementMatchers.named("java.sql.DriverManager"),
                ElementMatchers.nameStartsWith("java.sql"),
                ElementMatchers.nameStartsWith("com.sandbox.console.buddy.sample"),
                ElementMatchers.isAnnotatedWith(JavaAgentInterceptor.class)
        );
    }






    public static void premain(String agentOps)
    {
        System.out.println("Hello World! PreMain.premain(String agentOps)");
        System.out.println(agentOps);
    }

}
