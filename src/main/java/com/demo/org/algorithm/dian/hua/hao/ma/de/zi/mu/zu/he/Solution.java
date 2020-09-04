package com.demo.org.algorithm.dian.hua.hao.ma.de.zi.mu.zu.he;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    StringBuilder snapshot = new StringBuilder();

    List<String> results = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return results;
        }
        dfs(0,digits);
        return results;
    }

    void dfs(int idx, String digits) {
        if (idx == digits.length()) {
            results.add(snapshot.toString());
            return;
        }
        char c = digits.charAt(idx);
        String str = phoneMap.get(c);
        for (int i = 0; i < str.length(); i++) {
            snapshot.append(str.charAt(i));
            dfs(idx + 1, digits);
            snapshot.deleteCharAt(snapshot.length() - 1);
        }
    }


    @Test
    public void test() {
        System.out.println(letterCombinations("293"));
    }

}
