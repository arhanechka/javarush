package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileInput = br.readLine();
        String fileOutput = br.readLine();
        br.close();
        File file = new File(fileInput);
        byte[] buf = new byte[(int)file.length()];
        byte[] buf1 = new byte[(int)file.length()/2];
        FileInputStream fis = new FileInputStream(file);
        fis.read(buf);
        fis.close();
        for (int i=1, j=0; i<buf.length; i+=2, j++)
        {buf1[j]=buf[i];}
        for (int i=0; i<buf.length; i++)
            System.out.print(buf[i]+" ");
        System.out.println();
        for (int i=0; i<buf1.length; i++)
            System.out.print(buf1[i]+" ");
        FileOutputStream fos = new FileOutputStream(fileOutput);
        fos.write(buf1);
        fos.close();
    }
}
