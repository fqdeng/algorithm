package com.demo.org.algorithm.shuffle.the.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    /**
     * @link https://leetcode-cn.com/problems/shuffle-the-array/
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0){
                continue;
            }
            int j = i;
            while(nums[i]>0){
                if (j < n){
                    j = j * 2;
                }else{
                    j = (j - n) * 2 + 1;
                }
                swap(nums,i,j);
                nums[j] = -nums[j];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }
        return nums;
    }


    private void swap(int[] nums, int sourcePos, int targetPos) {
        int temp = nums[sourcePos];
        nums[sourcePos] = nums[targetPos];
        nums[targetPos] = temp;
    }


    @Test
    public void test(){
        int[] shuffle = shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3);
        for (int i = 0; i < shuffle.length; i++) {
            System.out.print(shuffle[i] + " ");
        }
    }
}
