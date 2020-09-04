package com.demo.org.algorithm.minimum.height.tree.lcci;

import com.demo.org.algorithm.common.model.TreeNode;
import org.junit.Test;

public class Solution {


    /**
     * @param nums
     * @return
     * @link https://leetcode-cn.com/problems/minimum-height-tree-lcci/
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        //二分搜索即可 因为平衡二叉树的 任意节点 其左子树的所有节点都小于其右子树
        return dfs(nums, 0, nums.length - 1);
    }

    TreeNode dfs(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        /*
         这里使用二分法 最重要的是计算middle的位置，
         通常很多人会误写成 middle = (high - low )/2
         实际上这是错误的 因为二分的middle 位置一定是在
         当前low的基础上 + high与low的差值 才能得到middle在数组中的绝对位置
         */
        int middle = low + (high - low) / 2;
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left =
                dfs(nums, low, middle - 1);
        treeNode.right =
                dfs(nums, middle + 1, high);
        return treeNode;
    }

    @Test
    public void test() {
        sortedArrayToBST(new int[]{1, 2, 3, 4, 5});
    }

}
