package com.demo.org.algorithm.valid.brackets;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        if (s.isEmpty()){
            return true;
        }
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            Character peek = stack.peek();
            if (equals(peek, s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    boolean equals(Character ch, Character correspondCh) {
        if ((ch.equals('[') && correspondCh.equals(']'))) {
            return true;
        }
        if ((ch.equals('{') && correspondCh.equals('}'))) {
            return true;
        }
        if ((ch.equals('(') && correspondCh.equals(')'))) {
            return true;
        }
        return false;
    }

    @Test
    public void testIsValid(){
        Assert.assertTrue(isValid("{[()]}"));
        Assert.assertTrue(isValid("()[]{}"));
        Assert.assertFalse(isValid("{[)(]}"));
    }
}
