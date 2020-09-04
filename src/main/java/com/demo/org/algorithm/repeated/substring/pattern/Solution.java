package com.demo.org.algorithm.repeated.substring.pattern;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * @param s
     * @return
     * @link https://leetcode-cn.com/problems/repeated-substring-pattern/
     */
    public boolean repeatedSubstringPattern(String s) {
        //查找当前字符串是否能完全由其它子串组成
        //1.如果一个字符串可以由一个子串完全组成 那么这个子串 必然会占据在这个字符串的前N位
        //2.这个子串的长度不可能大于当前字符串的一半
        //3.采用迭代的思想不断把可能的真子串长度拉长，这样如果能找满足组成字符串的重复子串则返回true

        int maxSubStrLength = s.length() / 2;
        for (int i = 0; i <= maxSubStrLength; i++) {
            String substring = s.substring(0, i);
            //这里之前想使用 replaceAll方法来做，后来发现这个正则算法会超时
            //所以此处直接采用逐步切片对比的方式来处理
            if (isFullSubString(substring, s)) {
                return true;
            }
        }
        return false;
    }

    private boolean isFullSubString(String pattern, String target) {
        if (pattern.isEmpty()){
            //模式串为空 直接返回false
            return false;
        }
        if (target.length() % pattern.length() != 0) {
            //排除无法整除的情况 直接返回false
            return false;
        }
        int repeatCount = target.length() / pattern.length();
        for (int i = 1; i <= repeatCount; i++) {
            String subString = target.substring(pattern.length() * (i - 1), pattern.length() * i);
            if (!subString.equals(pattern)) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }


    @Test
    public void test() {
        Assert.assertEquals(false, repeatedSubstringPattern("aba"));
        Assert.assertEquals(true, repeatedSubstringPattern("abab"));
        Assert.assertEquals(true, repeatedSubstringPattern("abcabcabc"));
    }
}
