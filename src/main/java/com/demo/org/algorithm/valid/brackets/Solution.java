package com.demo.org.algorithm.valid.brackets;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @link https://leetcode-cn.com/problems/valid-parentheses/
 * 有效的括号
 */
public class Solution {

    public boolean isValid(String s) {
        if (s.isEmpty()){
            return true;
        }
        //奇数长度直接返回
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));

        //思路还是用栈来实现
        //压进去一个 "("  必然在后面要对应一个 ")"  否则栈最后不会变成空的
        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty()){
                //如果栈已经空了 则把当前元素压进去 进行下一步
                stack.push(s.charAt(i));
                continue;
            }

            Character peek = stack.peek();
            //偷偷的看下栈顶是什么元素
            if (equals(peek, s.charAt(i))) {
                //如果栈顶元素跟现在的元素对应 那么直接弹出栈顶
                stack.pop();
            } else {
                //如果栈顶元素跟现在的元素不对应 那么直接把当前元素压入栈
                stack.push(s.charAt(i));
            }
        }
        //最后栈是空的 代表所有左边的半括号元素 类似"(" "{"  入栈且都出栈了
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
