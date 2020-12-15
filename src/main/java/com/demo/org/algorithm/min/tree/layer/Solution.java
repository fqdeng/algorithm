package com.demo.org.algorithm.min.tree.layer;

import com.demo.org.algorithm.common.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 这个题的代码参考如下实现
 * @see com.demo.org.algorithm.binary.tree.layer.Solution
 */
public class Solution {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;

        //广度搜索优先的架子 通常是一个队列 将叶子节点塞进去
        while (!queue.isEmpty()) {
            List<TreeNode> polls = new ArrayList<>();
            while (!queue.isEmpty()) {
                polls.add(queue.poll());
            }
            for (TreeNode poll : polls) {
                if (poll.right == null && poll.left == null) {
                    count++;
                    return count;
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
            }
            count++;
        }
        return count;
    }


}
