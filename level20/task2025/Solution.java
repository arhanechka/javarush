package com.javarush.task.task20.task2025;

import java.text.SimpleDateFormat; import java.util.Arrays; import java.util.Date; import java.util.TreeSet;

/* Алгоритмы-числа */
public class Solution { private static TreeSet<Integer> list = new TreeSet<>();

    public static long[] getNumbers(long N) {
        long[] result = null;
        for (int i = 1; i <= N; i++)
        {
            if (isNumberOrder(i)) {
                int sumOfPowers = sum(i);
                if (isArmstrong(sumOfPowers)) {
                    list.add(sumOfPowers);
                }
            }
        }
        result = new long[list.size()];
        int i=0;
        for (Integer integer : list) {
            result[i]=(long)integer;
            i++;
        }
        return result;}
    private static boolean isArmstrong(int number) {
        if (sum(number) == number) {
            return true;
        }
        return false;
    }
    private static boolean isNumberOrder(int i) {
        int lastNumber = 0;
        int currentNumber;
        while (i > 0) {
            currentNumber = i % 10;
            if (lastNumber > currentNumber) {
                return false;
            }
            lastNumber = currentNumber;
            i /= 10;
        }
        return true;
    }
    public static int sum(int s) {
        int result = 0;
        int m = ("" + s).length();
        int temp=s;
        while (temp> 0) {
            int a=temp%10;
            result += Math.pow(a, m);
            temp /= 10;
        }
        return result;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long[] array = getNumbers(99999999);
        long finish = System.currentTimeMillis() - start;
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SimpleDateFormat sdf = new SimpleDateFormat("ss.SSS");
        System.out.println("Time = " + sdf.format(new Date(finish)));
        System.out.println("Memory = " + memory / 1048576);
        System.out.println(Arrays.toString(array));
    }
}