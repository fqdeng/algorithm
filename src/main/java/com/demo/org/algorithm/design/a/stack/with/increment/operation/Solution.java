package com.demo.org.algorithm.design.a.stack.with.increment.operation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Your CustomStack object will be instantiated and called as such:
     * CustomStack obj = new CustomStack(maxSize);
     * obj.push(x);
     * int param_2 = obj.pop();
     * obj.increment(k,val);
     */
    class CustomStack {

        private int maxSize = 0;

        private List<Integer> list = new ArrayList<>();

        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if (list.size() < maxSize) {
                list.add(x);
            }
        }

        public int pop() {
            if (list.size() > 0) {
                Integer result = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                return result;
            }
            return -1;
        }

        public void increment(int k, int val) {
            k = Math.min(k, list.size());
            for (int i = 0; i < k; i++) {
                list.set(i, list.get(i) + val);
            }
        }
    }

    @Test
    public void test() {
        CustomStack customStack = new CustomStack(3); // 栈是空的 []
        customStack.push(1);                          // 栈变为 [1]
        customStack.push(2);                          // 栈变为 [1, 2]
        customStack.pop();                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        customStack.push(2);                          // 栈变为 [1, 2]
        customStack.push(3);                          // 栈变为 [1, 2, 3]
        customStack.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        customStack.increment(5, 100);                // 栈变为 [101, 102, 103]
        customStack.increment(2, 100);                // 栈变为 [201, 202, 103]
        customStack.pop();                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        customStack.pop();                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
        customStack.pop();                            // 返回 201 --> 返回栈顶值 201，栈变为 []
        customStack.pop();                            // 返回 -1 --> 栈为空，返回 -1
    }

}
