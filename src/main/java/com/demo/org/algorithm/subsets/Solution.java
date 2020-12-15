package com.demo.org.algorithm.subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<List<Integer>> results = new ArrayList<>();

    private List<Integer> temps = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return results;
        }
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i);
        }
        results.add(new ArrayList<>());
        return results;
    }


    private void dfs(int[] nums, int start) {
        if (start >= nums.length) {
            return;
        }
        temps.add(nums[start]);
        results.add(new ArrayList<>(temps));
        for (int i = start + 1; i < nums.length; i++) {
            dfs(nums, i);
        }
        temps.remove(temps.size() - 1);
    }

    @Test
    public void test(){
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
