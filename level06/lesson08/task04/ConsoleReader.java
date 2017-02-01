package com.javarush.test.level06.lesson08.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
boolean readBoolean() – читает с клавиатуры строку "true" или "false" и возвращает соответствующую логическую переменную true или false
Внимание: создавайте переменную для чтения данных с консоли (BufferedReader или Scanner) внутри каждого метода
*/

public class ConsoleReader
{
    public static String readString() throws Exception
    {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     //  String nnn=br.readLine();
        return br.readLine();

    }

    public static int readInt() throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());

    }

    public static double readDouble() throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(br.readLine());

    }

    public static boolean readBoolean() throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        if (br.readLine().equals("true"))
        return true;
        else
            return false;

    }
}
