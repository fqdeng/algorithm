package com.demo.org.algorithm.maximum.binary.tree;

import com.demo.org.algorithm.common.model.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    private int[] nums = null;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return dfs(0, nums.length - 1);
    }

    private TreeNode dfs(int startPos, int endPos) {
        if (startPos > endPos) {
            return null;
        }
        int maxPos = 0;
        int max = 0;
        for (int i = startPos; i <= endPos; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                maxPos = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.right = dfs(maxPos + 1, endPos);
        node.left = dfs(startPos, maxPos - 1);
        return node;
    }

    @Test
    public void test() {
        constructMaximumBinaryTree(
                new int[]{3, 2, 1, 6, 0, 5});
    }
}
