package com.demo.org.algorithm.binary.search.tree.iterator;

import com.demo.org.algorithm.common.model.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class BSTIterator {

        private Queue<Integer> queue = new LinkedList<>();

        /**
         * @link https://leetcode-cn.com/problems/binary-search-tree-iterator/
         * @param root
         */
        public BSTIterator(TreeNode root) {
            dfs(root);
        }

        void dfs(TreeNode root) {
            //二叉搜索树 所有节点都满足 左子树的所有节点都比当前节点小 当前节点比所有右子树小的特性
            //一个当前节点的如果有右子树，那么其右子树下的最左叶子的节点只会刚好比当前节点大且小于当前节点其它右子树节点
            if (root.left != null) {
                //先往左边不断递归 一直到找到一个叶子节点的左节点为null
                dfs(root.left);
            }
            //此时这个节点是最小的 将其加入队列
            queue.add(root.val);

            if (root.right != null) {
                dfs(root.right);
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return queue.poll();
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !queue.isEmpty();
        }

    }

    @Test
    public void test(){
        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(3);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(20);
        BSTIterator bstIterator = new BSTIterator(node);
    }
}