package com.demo.org.algorithm.remove.element;

import org.junit.Assert;
import org.junit.Test;

/**
 * 删除指定的元素
 * @link https://leetcode-cn.com/problems/remove-element/
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        }

        int head = 0;
        int tail = nums.length - 1;
        int count = 0;

        //双指针思路
        while (head <= tail) {
            if (nums[head] == val) {
                //如果从头部找到了val目标值
                while(tail > head && nums[tail] == val){
                    //从尾巴找到第一个不等于val值的元素
                    tail--;
                    count++;
                }
                //然后替换 头尾的两个元素
                swap(tail, head, nums);
                tail--;
                count++;
            }
            head++;
        }
        return nums.length - count;
    }

    private void swap(int target, int source, int[] nums) {
        int temp = nums[target];
        nums[target] = nums[source];
        nums[source] = temp;
    }

    @Test
    public void testRemoveElementCase1() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        Assert.assertEquals(5, removeElement(nums, 2));
        nums = new int[]{1};
        Assert.assertEquals(1, removeElement(nums, 2));

    }

    @Test
    public void testRemoveElementCase2() {
        int[] nums = new int[]{3, 3};
        Assert.assertEquals(0, removeElement(nums, 3));
    }

    @Test
    public void testRemoveElementCase3() {
        int[] nums = new int[]{4, 5};
        Assert.assertEquals(1, removeElement(nums, 4));
    }

    @Test
    public void testRemoveElementCase4() {
        int[] nums = new int[]{4, 5};
        Assert.assertEquals(1, removeElement(nums, 5));
    }

    @Test
    public void testRemoveElementCase6() {
        int[] nums = new int[]{2, 2, 2};
        Assert.assertEquals(0, removeElement(nums, 2));
    }
}
