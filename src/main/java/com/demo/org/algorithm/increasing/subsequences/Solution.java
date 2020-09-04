package com.demo.org.algorithm.increasing.subsequences;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    private List<Integer> records = new ArrayList<>();

    private List<List<Integer>> results = new ArrayList<>();

    private Set<String> queueStringSet = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
           dfs(i,nums);
        }
        return results;
    }

    private void dfs(int pos, int[] nums) {
        if (pos == nums.length) {
            if (records.size() > 0){
                records.remove(records.size()-1);
            }
            return;
        }
        if (records.size() >= 1 && records.get(records.size() - 1) > nums[pos]) {
            return;
        } else {
            records.add(nums[pos]);
            if (records.size() >= 2) {
                if (!queueStringSet.contains(records.toString())) {
                    List<Integer> snapshot = new ArrayList<>(records);
                    results.add(snapshot);
                    queueStringSet.add(snapshot.toString());
                }
            }
        }
        for (int i = pos ; i < nums.length; i++) {
            dfs(i + 1, nums);
        }
    }

    @Test
    public void test() {
        System.out.println(findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
