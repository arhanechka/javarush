package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        String fileName1 = br.readLine();
        br.close();
        File file = new File(fileName);
        File file1 = new File(fileName1);
        byte[] buf = new byte[(int)file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(buf);
        fis.close();
        for (int i=0; i<buf.length; i++)
        {
           if (buf[i]==46)
               buf[i]=33;
        }
        FileOutputStream fos = new FileOutputStream(file1);
        fos.write(buf);
        fos.close();
    }
}
