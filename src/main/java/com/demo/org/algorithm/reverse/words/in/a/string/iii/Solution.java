package com.demo.org.algorithm.reverse.words.in.a.string.iii;

public class Solution {
    public String reverseWords(String s) {
        if (s.equals("")){
            return s;
        }
        String[] splits = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            String word = splits[i];
            result.append(reverse(word));
            if (i != splits.length - 1) {
              result.append(" ");
           }
        }
        return result.toString();
    }

    private String reverse(String str){
        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            result.append(chars[i]);
        }
        return result.toString();
    }
}
