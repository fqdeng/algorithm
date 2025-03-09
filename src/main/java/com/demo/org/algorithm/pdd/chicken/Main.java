package com.demo.org.algorithm.pdd.chicken;

import java.util.Scanner;

public class Main{

    public static void main(String [] args){
        boolean breakCondition = true;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            if (breakCondition){
                breakCondition = false;
                in.nextInt();
                continue;
            }
            int num = in.nextInt();
            int count = 0;
            while(num >= 2){
                num = num / 2;
                count++;
            }
            System.out.println(count+1);
        }
    }

}