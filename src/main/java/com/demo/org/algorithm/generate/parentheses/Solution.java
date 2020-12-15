package com.demo.org.algorithm.generate.parentheses;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {



    public List<String> generateParenthesis(int n) {
        int right = n,left=n;
        List<String> result = new ArrayList<>();
        sub(result,"(",right-1,left);
        sub(result,")",right,left-1);
        return result;
    }

    public void sub(List<String> result,String s,int left,int right) {
        if (left<0||right<0||left-right>0){
            return;
        }

        if (left+right==0){
            result.add(s);
            return;
        }
        sub(result,s+"(",left-1,right);
        sub(result,s+")",left,right-1);
    }

    private boolean checkIfLegal(LinkedList<Character> temp) {
        Stack<Character> stack = new Stack<>();
        Iterator<Character> iterator = temp.descendingIterator();
        while (iterator.hasNext()) {
            Character character = iterator.next();
            if (character == '(') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() != ')') {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testResults() {
        List<String> strings = generateParenthesis(8);
        for (int i = 0; i < strings.size(); i++) {
            char[] chars = strings.get(i).toCharArray();
            LinkedList<Character> linkedList = new LinkedList<>();
            for (char aChar : chars) {
                linkedList.addLast(aChar);
            }
            Assert.assertTrue(checkIfLegal(linkedList));
        }
        System.out.println(strings);
    }


    @Test
    public void testCheckIfLegal() {
        List<Character> characters = Arrays.asList(')', '(');
        Assert.assertTrue(!checkIfLegal(new LinkedList<>(characters)));

        characters = Arrays.asList('(', ')');
        Assert.assertTrue(checkIfLegal(new LinkedList<>(characters)));

        characters = Arrays.asList('(', '(', ')', ')');
        Assert.assertTrue(checkIfLegal(new LinkedList<>(characters)));

        characters = Arrays.asList('(', '(', ')', '(', ')', ')');
        Assert.assertTrue(checkIfLegal(new LinkedList<>(characters)));

        characters = Arrays.asList('(', ')', ')', '(', ')', ')');
        Assert.assertTrue(!checkIfLegal(new LinkedList<>(characters)));
    }


}
