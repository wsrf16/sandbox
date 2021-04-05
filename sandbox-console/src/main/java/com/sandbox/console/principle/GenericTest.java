package com.sandbox.console.principle;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GenericTest {
    public static void main() {
        Generic<Integer> genericInteger = new Generic<Integer>();
        Generic<Number> genericNumber = new Generic<Number>();

        // it will throw Exception
//         show(genericInteger);
        showFields(genericNumber);
        System.out.println();
        showClass(new Generic1<Map<String, Integer>>());
    }

    public static <T extends Map<String, Integer>> void showClass(Generic<T> obj) {
        ParameterizedType[] parameterizedTypes = (ParameterizedType[]) obj.getClass().getTypeParameters();
        for (ParameterizedType parameterizedType : parameterizedTypes) {
            System.out.println("getActualTypeArguments");
            Arrays.stream(parameterizedType.getActualTypeArguments()).forEach(c -> System.out.println(c.getTypeName()));

            System.out.println("getOwnerType");
            System.out.println(parameterizedType.getOwnerType().getTypeName());

            System.out.println("getRawType");
            System.out.println(parameterizedType.getRawType().getTypeName());
        }
    }

    public static <T> void showFields(Generic<T> obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getGenericType() instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();

                System.out.println("getActualTypeArguments");
                Arrays.stream(parameterizedType.getActualTypeArguments()).forEach(c -> System.out.println(c.getTypeName()));

                System.out.println("getOwnerType");
                System.out.println(parameterizedType.getOwnerType() == null ? null : parameterizedType.getOwnerType().getTypeName());

                System.out.println("getRawType");
                System.out.println(parameterizedType.getRawType().getTypeName());

                System.out.println();
            }
        }
    }

    static class Generic<T> {
        List<String> field1;
        List field2;
        Map<String, Integer> field3;
        Map.Entry<Long, Short> field4;
    }

    static class Generic1<T> extends Generic<T> {

    }
}
