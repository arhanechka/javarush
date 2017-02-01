package com.javarush.test.level09.lesson02.task01;

/* Каждый метод должен возвращать свой StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать свой StackTrace.
*/

import sun.management.StackTraceElementCompositeData;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static StackTraceElement[] method1()
    {
        method2();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[0].getMethodName());
return stackTraceElements;
    }

    public static StackTraceElement[] method2()
    {
        method3();
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
return elements;
    }

    public static StackTraceElement[] method3()
    {
        method4();
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        return elements;

    }

    public static StackTraceElement[] method4()
    {
        method5();
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        return elements;

    }

    public static StackTraceElement[] method5()
    {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
//        for (StackTraceElement element : elements)
//        {
//            System.out.println(element.getMethodName());}
        return elements;

    }
}
