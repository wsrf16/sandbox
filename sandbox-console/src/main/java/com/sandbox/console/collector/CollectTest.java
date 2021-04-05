package com.sandbox.console.collector;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectTest {
    public void test(){
        List<MA> list = new ArrayList<MA>();
        list.add(MA.instance("A", 1));
        list.add(MA.instance("A", 2));
        list.add(MA.instance("A", 3));
        list.add(MA.instance("A", 4));
        list.add(MA.instance("B", 11));
        list.add(MA.instance("B", 12));
        list.add(MA.instance("B", 12));
        list.add(MA.instance("C", 21));
        list.add(MA.instance("C", 22));
        //Function.identity()

        List<Integer> array = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};


        Map<String, Long> map1 = list.stream().collect(Collectors.groupingBy(MA::getKey, Collectors.counting()));
        Map<String, Integer> map2 = list.stream().collect(Collectors.groupingBy(MA::getKey, Collectors.summingInt(MA::getValue)));

        Map<String, List<String>> map3 = list.stream().collect(Collectors.groupingBy(MA::getKey, Collectors.mapping(MA::getKey, Collectors.toList())));

        String[] cityArr = {"Beijing", "Shanghai", "Chengdu"};
        String[] cityArr11 = new String[] {"Beijing", "Shanghai", "Chengdu"};

        Set<String> sset = Stream.of("You", "may", "assume").collect(Collectors.toSet());
        //Stream<Integer> stream1 = Arrays.stream(1, 2, 3);
        Stream<Integer> stream11 = Arrays.stream(new Integer[]{1, 2, 3});
        Stream<int[]> stream111 = Stream.of(new int[]{1, 2, 3});
        IntStream stream2 = Arrays.stream(new int[]{1, 2, 3});

        Arrays.asList("11212","dfd","2323","dfhgf").stream().collect(Collectors.toList());
        Arrays.asList("11212","dfd","2323","dfhgf").stream().toArray(String[]::new);

    }




     static class MA {
        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        public String key;
        public Integer value;

        public static MA instance(String key, Integer value) {
            MA ma = new MA();
            ma.key = key;
            ma.value = value;
            return ma;

        }
    }
}
