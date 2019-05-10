package com.kang.qiandao.utils;

import java.util.Random;

public class RandomNumber {
    public static  String getRandom() {
        Random random = new Random();
        //2147483647
        int l = random.nextInt(483647);
        String s=Integer.toString(l);
        return s;
    }
    public static void main(String[] args){
        System.out.println(RandomNumber.getRandom());
    }
}
