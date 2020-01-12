package com.demo.org.algorithm.binary.tree.layer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    class TreeNode {
        public int val;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode left;

        public TreeNode right;
    }

    //           0               <- 第一次从队列里面取到0  然后把子节点1放回去
    //         /   \
    //        1     null         <- 第二次从队列里面取到1 然后把子节点 3 4 放回去
    //      /  \
    //     3   4                 <- 第三次从队列里面取到3，4 因为其没有子节点 所以队列为空 返回 得到count = 3
    //   null -> layer
    // 这里其实思路很简单，因为bfs是层序遍历，每次针对队列的循环，都是取得同层级别的节点，除开二叉树 多叉树亦是如此


    //求二叉树的最大层数 算是bfs模板题
    public int calculateBinaryTreeLayer(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //不管怎么样通常bfs是要进队的
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int count = 0;

        while (!queue.isEmpty()) {
            List<TreeNode> polls = new ArrayList<>();
            //这个是取出当前这一层所有的左右节点 实际上针对多叉树 其思想也是一样
            while (!queue.isEmpty()) {
                polls.add(queue.poll());
            }

            //把所有节点的子节点再塞回去
            polls.forEach(poll -> {
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
            });

            //计数+1
            count++;
        }
        return count;
    }

    /**
     * not full binary tree
     */
    @Test
    public void testCalculateBinaryTreeTestCase2() {

        TreeNode top = new TreeNode(0);
        top.left = new TreeNode(1);
        top.right = new TreeNode(2);
        top.left.left = new TreeNode(3);
        top.left.right = new TreeNode(4);
        Assert.assertEquals(3, calculateBinaryTreeLayer(top));
    }

    /**
     * full binary tree
     */
    @Test
    public void testCalculateBinaryTreeTestCase1() {
        //           0
        //         /   \
        //        1     2
        //      /  \   /  \
        //     3   4   5   6
        //   null -> layer

        TreeNode top = new TreeNode(0);
        top.left = new TreeNode(1);
        top.right = new TreeNode(2);
        top.left.left = new TreeNode(3);
        top.left.right = new TreeNode(4);
        top.right.left = new TreeNode(5);
        top.right.right = new TreeNode(6);
        Assert.assertEquals(3, calculateBinaryTreeLayer(top));
    }
}
