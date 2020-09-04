package com.demo.org.algorithm.robot.to.origin;

public class Solution {


    public boolean judgeCircle(String moves) {
        int u = 0;
        int d = 0;
        int r = 0;
        int l = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                u++;
            }
            if (c == 'D') {
                d++;
            }
            if (c == 'R') {
                r++;
            }
            if (c == 'L') {
                l++;
            }
        }
        return u == d && r ==l;
    }
}
