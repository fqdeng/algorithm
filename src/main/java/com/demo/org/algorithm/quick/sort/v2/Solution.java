package com.demo.org.algorithm.quick.sort.v2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution {

    private int count = 0;

    /**
     * quickSort
     */
    void quickSort(int[] nums) {
        count = 0;
        quick(nums, 0, nums.length - 1);
    }

    void quick(int[] nums, int start, int end) {
        //recursive base return
        if (start > end) {
            return;
        }
        int low = 0;
        int high = end;

        int partition = partition(nums, low, high);

        quick(nums, low, partition - 1);
        quick(nums, partition + 1, start);
    }

    /**
     * partition method
     * @param nums
     * @param start
     * @param end
     * @return
     */
    int partition(int[] nums, int start, int end) {
        int key = nums[start];

        //separate nums with key
        //find num is greater than the key
        //and put those number in the right side of nums
        //find num is less than the key
        //and put those number in the right side of nums

        int low = start;

        int high = end;

        for (int i = start + 1; i <= end; i++) {
            if (nums[i] == key) {
                continue;
            }
            if (nums[i] < key) {
                swap(nums, i, low);
                low++;
            } else {
                swap(nums, i, high);
                high--;
            }
        }
        return low;
    }


    void swap(int[] nums, int srcPosition, int targetPosition) {
        count++;
        int temp = nums[srcPosition];
        nums[srcPosition] = nums[targetPosition];
        nums[targetPosition] = temp;
    }

    @Test
    public void testPartition() {
        int[] nums = {3, 2, 1, 5, 6};
        Assert.assertEquals(partition(nums, 0, 4), 2);
        Assert.assertArrayEquals(new int[]{2, 1, 3, 6, 5}, nums);
    }

    @Test
    public void testQuickSort() {
        int[] nums = {3, 2, 1, 5, 6};
        quickSort(nums);
        System.out.println(String.format("swap times:%s", count));
        Assert.assertArrayEquals(nums, new int[]{1, 2, 3, 5, 6});

        nums = new int[]{9, 8, 7, 6, 5};
        quickSort(nums);
        System.out.println(String.format("swap times:%s", count));
        Assert.assertArrayEquals(nums, new int[]{5, 6, 7, 8, 9});

        nums = new int[]{1, 2, 3, 5, 6};
        quickSort(nums);
        System.out.println(String.format("swap times:%s", count));
        Assert.assertArrayEquals(nums, new int[]{1, 2, 3, 5, 6});
    }
}
