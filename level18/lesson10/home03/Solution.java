package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл
содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1_Name = reader.readLine();
        String file2_Name = reader.readLine();
        String file3_Name = reader.readLine();
        reader.close();

        File file2 = new File(file2_Name);
        File file3 = new File(file3_Name);
        FileInputStream fis2 = new FileInputStream(file2);
        FileInputStream fis3 = new FileInputStream(file3);
        FileOutputStream fos1 = new FileOutputStream(file1_Name);
        byte[] buf1 = new byte[(int) file2.length()];
        byte[] buf2 = new byte[(int) file3.length()];
        fis2.read(buf1);
        fis3.read(buf2);
        byte[] buf3 = new byte[(int) file2.length() + (int) file3.length()];
        System.arraycopy(buf1, 0, buf3, 0, (int) file2.length());
        System.arraycopy(buf2, 0, buf3, (int) file2.length(), (int) file3.length());
        fos1.write(buf3);

//        while (f.available() > 0)
//        {
//            data = f.read(buf);
//            f1.write(buf, 0, data);
//        }
//
//        f = new FileInputStream(file3);
//        f1 = new FileOutputStream(file1, true);
//
//        while (f.available() > 0)
//        {
//            data = f.read(buf);
//        }
//
//        f1.write(buf, 0, data);
        fis2.close();
        fis3.close();
        fos1.close();


    }
}
