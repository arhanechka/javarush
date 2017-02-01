package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public Solution() throws IOException
    {
    }

    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        int min = 1000;
        FileInputStream fileInputStream = new FileInputStream(file);
        while (fileInputStream.available() > 0)
            if (fileInputStream.read() < min)
            {        min = fileInputStream.read();}
        System.out.println(min);
    }

}
