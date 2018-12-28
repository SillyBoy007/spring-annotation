package com.wang.servlet;

public class Tes {
    public static void main(String[] args) {
        String a ="1,2,3,4,5,6,7,8";
        String [] arr = a.split(",");
        for (String str: arr){
            System.out.println(str);
        }
    }
}
