package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        int b=Integer.parseInt(br.readLine());
        int c=Integer.parseInt(br.readLine());
        int d=Integer.parseInt(br.readLine());
        if (max(a,b)>max(c,d))
            System.out.println(max(a,b));
        else
            System.out.println(max(c,d));

    }
    public static int max (int a, int b){
       if (a>b)
           return a;
        else
            return b;
    }

}
