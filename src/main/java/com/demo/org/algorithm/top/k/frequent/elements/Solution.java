package com.demo.org.algorithm.top.k.frequent.elements;

import lombok.var;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCorrespondingCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numCorrespondingCount.merge(num, 1, Integer::sum);
        }
        List<NumberCount> numberCountList = new ArrayList<>();
        numCorrespondingCount.forEach((key, value) -> numberCountList.add(new NumberCount(key, value)));
        PriorityQueue<NumberCount> priorityQueue = new PriorityQueue<>();
        for (NumberCount numberCount : numberCountList) {
            priorityQueue.add(numberCount);
        }

        while (priorityQueue.size() > k) {
            priorityQueue.poll();
        }

        List<Integer> results = new ArrayList<>();

        while (priorityQueue.peek() != null) {
            results.add(priorityQueue.poll().num);
        }
        int[] resultInts = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            resultInts[i] = results.get(i);
        }
        return resultInts;
    }

    class NumberCount implements Comparable<NumberCount> {
        public NumberCount(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public Integer num;

        public Integer count;

        @Override
        public int compareTo(NumberCount o) {
            return this.count.compareTo(o.count);
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(new int[]{1, 2} , topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        Assert.assertEquals(new int[]{2, 1} , topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
