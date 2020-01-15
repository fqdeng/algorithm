package com.demo.org.algorithm.integer.reverse;

import org.junit.Test;

import java.util.Stack;

//reverse the integer
public class Solution {

    //stack
    public int reverse(int x) {
        String s = String.valueOf(x);
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return Integer.valueOf(builder.toString()) ;
    }


    @Test
    public void testReverse() {
        System.out.println(reverse(15342388));
    }
}
