package com.sandbox.console;

import com.sandbox.console.buddy.Bar;
import com.sandbox.console.buddy.Foo;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.*;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class ByteBuddySample {

    static class TimeInterceptor  {
        @RuntimeType
        public static Object intercept(@Origin Method method,
                                       @SuperCall Callable<?> callable) throws Exception {
            long start = System.currentTimeMillis();
            try {
                // 原有函数执行
                return callable.call();
            } finally {
                System.out.println(method + ": took " + (System.currentTimeMillis() - start) + "ms");
            }
        }
    }


    @interface Secured {
        String user();
    }
    static class SecurityInterceptor {
        static String user = "ANONYMOUS";
        static void intercept(@Origin Method method) {
            if (!method.getAnnotation(Secured.class).user().equals(user)) {
                throw new IllegalStateException("Wrong user");
            }
        }
    }


    public static void main() throws NoSuchMethodException, IllegalAccessException, InstantiationException {
        ByteBuddyAgent.install();
//        Foo foo = new Foo();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        classLoader = Thread.currentThread().getContextClassLoader();
        ClassReloadingStrategy classLoadingStrategy = ClassReloadingStrategy.fromInstalledAgent();
        ClassLoadingStrategy.Default wrapper = ClassLoadingStrategy.Default.WRAPPER;
        TypePool typePool = TypePool.Default.of(classLoader);
        ConstructorStrategy.Default noConstructors = ConstructorStrategy.Default.NO_CONSTRUCTORS;


//        {
//            new ByteBuddy(ClassFileVersion.JAVA_V8)
//                    .subclass(Object.class)
//                    .implement(MInterface.class)
//
//                    .method(ElementMatchers.named("m")).intercept(DefaultMethodCall.prioritize(MInterface.class))
//
//                    .defineField("qux", String.class)
//                    .make()
//                    .load(Foo.class.getClassLoader(), wrapper);
//
//            if (1 == 2)
//                System.exit(0);
//        }

        {
            DynamicType.Loaded<?> out = new ByteBuddy()
                    .redefine(Bar.class)
                    .implement(MInterface.class)
                    .name("com.sandbox.console.Foo1")
//                    .modifiers(Visibility.PUBLIC)
//                    .defineConstructor(Visibility.PUBLIC)
//                    .intercept(MethodCall.invoke(Bar.class.getDeclaredConstructor()))

                    .make()
                    .load(Foo.class.getClassLoader(), wrapper);
            Class<?> loaded = out.getLoaded();
            Foo foo1 = new Foo();
            Object o = loaded.newInstance();

            String m = foo1.m();

//            Class<? extends Bar> clazz = out.getLoaded();
//            try {
//                Bar bar = clazz.newInstance();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
        }
        {
            DynamicType.Unloaded<Printer> unloaded = new ByteBuddy()
                    .with(new NamingStrategy.AbstractBase() {
                        @Override
                        public String name(TypeDescription superClass) {
                            return "i.love.ByteBuddy." + superClass.getSimpleName();
                        }
                    })
//                    .redefine(typePool.describe("foo.Bar").resolve(), ClassFileLocator.ForClassLoader.of(classLoader))
                    .redefine(Printer.class)
//                    .subclass(Object.class)
                    .name(Foo.class.getName())
                    .name("example.Type")


                    .implement(Main.class)
                    .defineField("qux", String.class)
                    .method(ElementMatchers.named("first")).intercept(FixedValue.value("One!"))
                    .method(ElementMatchers.named("second").and(ElementMatchers.takesArgument(1, String.class))).intercept(FixedValue.value("Two!"))
                    .method(ElementMatchers.named("out")).intercept(MethodDelegation.to(ErrPrinter.class))

                    .method(ElementMatchers.named("toString")
                            .and(ElementMatchers.returns(String.class)
                                    .and(ElementMatchers.takesArgument(0, String.class)))
                    ).intercept(FixedValue.value("Hello World!"))
                    .method(ElementMatchers.<MethodDescription>any()).intercept(MethodDelegation.to(TimeInterceptor.class))

//                    .intercept(MethodDelegation.to(Main.class))
//                .method(ElementMatchers.named("err"))
                    .method(ElementMatchers.isAnnotatedWith(Secured.class))
                    .intercept(MethodDelegation.to(SecurityInterceptor.class)
                            .andThen(SuperMethodCall.INSTANCE))

                    .make();
            DynamicType.Loaded<Printer> loaded = unloaded.load(classLoader, classLoadingStrategy);
            Class<? extends Printer> clazz = loaded.getLoaded();
        }

        Printer.out("aaa");


    }
}
