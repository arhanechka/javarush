package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        int []ar={a,b,c};
        int temp=0;
        for (int i=0; i<2; i++)
            for (int j=1; j<3; j++)
            {if (ar[j] >ar[i])
            {temp=ar[i];
            ar[i]=ar[j];
                ar[j]=temp;}
            }

        for (int i=0; i<3; i++)
            System.out.println(ar[i]);



    }

}
