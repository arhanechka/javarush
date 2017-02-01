package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);

        Map<Character, Integer> treeMap = new TreeMap<>();

        byte[] buf = new byte[(int) file.length()];
        fis.read(buf);
        for (int i = 0; i < buf.length; i++)
        {
            treeMap.put((char)buf[i], 0);
        }

        int c = 0;
        for (Map.Entry<Character, Integer> map : treeMap.entrySet())
            for (int i = 0; i < buf.length; i++)
            {
                if ((char)buf[i] == (map.getKey()))
                {
                    c = map.getValue();
                    c++;
                    map.setValue(c);
                }
            }


        for (Map.Entry<Character, Integer> byteIntegerEntry : treeMap.entrySet())
        {
            System.out.print(byteIntegerEntry.getKey()+" "+byteIntegerEntry.getValue());
            System.out.println();
        }
        fis.close();
    }
}

