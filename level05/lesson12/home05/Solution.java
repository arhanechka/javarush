package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String sum=null;
        int d=0;
        while (true)
        { sum=br.readLine();
        if (sum.equalsIgnoreCase("сумма")==false)

            d+=Integer.parseInt(sum);
        else break;}
        System.out.println(d);
    }
}
