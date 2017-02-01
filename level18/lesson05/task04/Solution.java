package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        FileInputStream in = new FileInputStream(file1);
        FileOutputStream out = new FileOutputStream(file2);
        int data = 0;
        byte[] buf = new byte[100];

        while (in.available() > 0)
        {
            data = in.read(buf);
        }
        byte[] result = new byte[data];
        for (int i = 0; i < data; i++)
        { result[i] = buf[data - 1 - i];}
        out.write(result);
        br.close();
        in.close();
        out.close();


    }
}
