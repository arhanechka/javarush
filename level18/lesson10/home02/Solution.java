package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream f = new FileInputStream(args[0]);
        int sum1 = 0;
        byte[] buff = new byte[1000];
        int data=0;
        while (f.available() > 0)
        {
            data = f.read(buff);
        }
        byte [] buf1 = new byte[data];
        for (int i=0; i<data; i++)
        {buf1[i]=buff[i];
            if (buf1[i]==' ')
            {sum1++;}
            }
            String rel = String.format("%.2f",(double)sum1/data*100);
        System.out.println( rel);
    f.close();}

    }
