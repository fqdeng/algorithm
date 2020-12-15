package com.demo.org.algorithm.permutations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private List<List<Integer>> results = new ArrayList<>();

    private Deque<Integer> temp = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(nums,used,0);
        return results;
    }


    void dfs(int[] nums, boolean[] used, int path) {
        if (nums.length == path) {
            results.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.addLast(nums[i]);
                path++;
                dfs(nums, used, path);
                path--;
                temp.removeLast();
                used[i] = false;
            }
        }
    }

    @Test
    public void test(){
        //System.out.println(permute(new int[]{1,2,3,4,5,6,7,8,9,10,11,12}));
        List<List<Integer>> permute = permute(new int[]{1, 2, 3, 4, 5, 6, 7,8,9});
        System.out.println(permute);
        //System.out.println(permute(new int[]{1,2,3}));

    }


}
