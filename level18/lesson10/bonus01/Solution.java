package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {File file = new File(args[1]);
        File file1 = new File(args[2]);


        switch (args[0])
        {
            case ("-e"):
            {
                shifr(file, file1);
                break;
            }
            case ("-d"):
            {
                shifr(file, file1);
                break;
            }
        }

    }

    public static void shifr(File file, File file1) throws IOException
    {FileInputStream fis = new FileInputStream(file);
        byte [] buf = new byte[(int)file.length()];
        fis.read(buf);
        byte[] shifredButh = buf;
        for (int i=0; i<(int) Math.floor(shifredButh.length / 2); i++)
        {shifredButh[i] ^= shifredButh[shifredButh.length - i - 1];
            shifredButh[shifredButh.length - i - 1] ^= shifredButh[i];
            shifredButh[i] ^= shifredButh[shifredButh.length - i - 1];	}
        for (int i=0; i<buf.length; i++)
            System.out.print(buf[i]+ " ");
        System.out.println();
        for (int i=0; i<buf.length; i++)
            System.out.print(shifredButh[i]+ " ");
        FileOutputStream fos = new FileOutputStream(file1);
        fos.write(shifredButh);
    }

}
