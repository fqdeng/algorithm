package com.demo.org.algorithm.remove.duplicate;


import org.junit.Assert;
import org.junit.Test;

/**
 * 删除数组中的重复元素
 * @link https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {

    //这个方式比较蠢 实际上是每次删除操作 要把所有元素 左移
    //在时间复杂度上很吃亏
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int same = 0;
        int first;
        int second;
        for (int i = 0; i < nums.length - 1; i++) {
            first = nums[i - same];
            second = nums[i + 1 - same];
            if (first == second) {
                remove(nums, i - same);
                same++;
            } else {
                // if double reference is same then count++
                count++;
            }
        }
        // example : 0 1 2  -> 0,1  1,2
        // double reference check then count will be 2
        // so the result must be count +1
        return count + 1;
    }

    // 左移所有元素
    private void remove(int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            if (i + 1 <= nums.length - 1) {
                nums[i] = nums[i + 1];
            }
        }
    }

    private void printInts(int[] nums) {
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
    }

    @Test
    public void testRemoveDuplicate() {
        int[] nums = {0, 0, 1, 1, 2, 2, 3, 4};
        Assert.assertEquals(5, removeDuplicates(nums));
        printInts(nums);
    }
}
