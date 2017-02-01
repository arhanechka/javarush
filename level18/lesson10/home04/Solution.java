package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось
объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        byte[] buf = new byte[10000];
        byte[] buf1 = new byte[10000];
        int data=0,data1 = 0;
        FileInputStream f = new FileInputStream(file1);

        while (f.available() > 0)
        {
            data = f.read(buf);

        }
        f=new FileInputStream(file2);
        FileOutputStream f1 = new FileOutputStream(file1);
        while (f.available() > 0)
        {
            data1 = f.read(buf1);
            f1.write(buf1,0,data1);
        }
        f1 = new FileOutputStream(file1,true);
        f1.write(buf,0,data);
        f.close();
        f1.close();
    }
}
