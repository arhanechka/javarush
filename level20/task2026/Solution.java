package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {0, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int sum =0;
        int hor = a[0].length;
        int ver = a.length;
        if (a[0][0]==1)
            sum++;
        for (int i=1; i<4; i++)
        {if (a[0][i]==1 && a[0][i-1]==0)
        sum++;}
        for (int i=1; i<ver; i++)
        {  if (a[i][0]==1&& a[i-1][0]==0)
                sum++;
            for (int j=1; j<hor; j++)
        if (a[i][j]==1&&a[i-1][j]==0 && a[i][j-1]==0)
            sum++;
        }
        return sum; }


    }

