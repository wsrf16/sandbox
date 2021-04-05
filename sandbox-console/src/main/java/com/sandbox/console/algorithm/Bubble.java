package com.sandbox.console.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Bubble {
    public void main() {
        List<Integer> list = new ArrayList();
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);

        Integer[] array = list.toArray(new Integer[5]);
        for (int i = 0; i < array.length; i++) {
//            int swap = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        }
        System.out.println(array);
    }
}
