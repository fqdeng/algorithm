package com.demo.org.algorithm.zuo.xuan.zhuan.zi.fu.chuan.lcof;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * @param s
     * @param n
     * @return
     * @link https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
     */
    public String reverseLeftWords(String s, int n) {
        List<Character> characterList = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            characterList.add(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            Character chr = characterList.get(0);
            characterList.remove(0);
            characterList.add(chr);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : characterList) {
             stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }


    @Test
    public void test() {
        Assert.assertEquals( "cdab",reverseLeftWords("abcd", 2));
    }

}
