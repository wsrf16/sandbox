package com.sandbox.console.algorithm;

import java.util.Arrays;
import java.util.List;

public class SlidingWindow {
    int max = SlidingWindow.mostSum(Arrays.asList(new Integer[]{400, 200, 300, 100}), 2);

    public static int mostSum(List<Integer> num, int k) {
        int sum = 0;
        for (int i = 0; i < num.size(); i++) {
            int _sum = num.stream().mapToInt(c -> c).skip(i).limit(k).sum();
            sum = Math.max(sum, _sum);
        }
        return sum;
    }
}
