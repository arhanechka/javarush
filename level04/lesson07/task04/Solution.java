package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
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
        int sumPlus=0;
        int sumMinus=0;
        int[]ar={a,b,c};
        for (int i=0; i<3; i++)
            if (ar[i]>0)
                sumPlus++;
        else if (ar[i]<0)
            sumMinus++;
        System.out.println("количество отрицательных чисел: "+sumMinus);
        System.out.println("количество положительных чисел: "+sumPlus);
    }
}
