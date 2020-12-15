package com.demo.org.algorithm.quick.sort.v1;

import com.demo.org.algorithm.common.constants.Color;
import org.junit.Test;

import java.util.Arrays;

public class Solution {

    private static int count = 0;

    public void sort(int[] nums, int low, int high) {
        int start = low;
        int end = high;

        int key = nums[low];
        count += 1;
        int current = count;
        while (end > start) { //从后往前比较
            while (end > start && nums[end] >= key) //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if (nums[start] <= key) {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            }

            //从前往后比较
            while (end > start && nums[start] <= key) //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if (nums[end] >= key) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

            }

            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的 值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
            //左边序列。第一个索引位置到关键值索引-1
            printNums(nums, start, end);
            if (start > low) {
                sort(nums, low, start - 1);
            }
            //右边序列。从关键值索引+1 到最后一个
            if (end < high) {
                sort(nums, end + 1, high);
            }
        } //递归

    }

    public void printNums(int[] nums, int start, int end) {
        for (int i = 0; i < nums.length; i++) {
            if (i == start || i == end) {
                System.out.print(Color.RESET);
                System.out.print(Color.RED);
                System.out.print(nums[i] + " ");
                continue;
            }
            System.out.print(Color.RESET);
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void test() {
        int[] nums = {7, 4, 2, 8, 1, 2, 3, 7, 21};
        sort(nums, 0, nums.length - 1);
    }
}
