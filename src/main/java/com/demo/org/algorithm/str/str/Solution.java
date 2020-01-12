package com.demo.org.algorithm.str.str;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

//TODO explain RK是如何实现的
public class Solution {
    public int strStr(String haystack, String needle) {
        //RK implement
        if (needle == null || haystack == null || needle.length() > haystack.length()) {
            return -1;
        }

        int needleHashCode = 0;
        for (int i = 0; i < needle.length(); i++) {
            needleHashCode += needle.charAt(i);
        }


        List<Integer> hashList = new LinkedList<>();
        int len = haystack.length() - needle.length();
        int sum = 0;
        for (int i = 0; i <= len; i++) {
            if (i == 0) {
                for (int j = i; j < needle.length(); j++) {
                    hashList.add((int) haystack.charAt(j));
                }
                sum = hashList.stream().mapToInt(num -> num).sum();
            } else {
                sum -= hashList.get(0);
                hashList.remove(0);
                int nextHashCode = haystack.charAt(i + needle.length() - 1);
                hashList.add(nextHashCode);
                sum += nextHashCode;
            }
            if (sum == needleHashCode) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }


    @Test
    public void testStrStrCase1() {
        Assert.assertEquals(0, strStr("abab", "ab"));
        Assert.assertEquals(4, strStr("ababcd", "cd"));
    }


}
