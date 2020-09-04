package com.demo.org.algorithm.dui.lie.de.zui.da.zhi.lcof;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    class MaxQueue {
        private Queue<Integer> queue = new LinkedList<>();

        public MaxQueue() {

        }

        public int max_value() {
            int max = -1;
            for (Integer var : queue) {
                if (var > max) {
                    max = var;
                }
            }
            return max;
        }

        public void push_back(int value) {
            queue.offer(value);
        }

        public int pop_front() {
            Integer result = queue.poll();
            if (result == null) {
                return -1;
            }
            return result;
        }

    }

}
