package com.atguigu.java1;

import org.junit.Test;

import javax.annotation.processing.SupportedSourceVersion;
import java.sql.SQLOutput;

/**
 * debug看memory
 * @author shkstart  shkstart@126.com
 * @create 2020  0:49
 */
public class StringTest4 {
    public static void main(String[] args) {
        System.out.println();//   2300
        System.out.println("1");// 2301
        System.out.println("2");// 2302
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");//2310
        //如下的字符串"1" 到 "10"不会再次加载
        System.out.println("1");//2311
        System.out.println("2");//2311
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");//2311
    }
}

