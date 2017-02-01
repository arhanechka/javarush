package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException
    {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        File file = new File(fileName);
        byte[] buf = new byte[(int)file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(buf);
        fis.close();
        String str = new String(buf).toLowerCase();
        int sum = 0;
        str=str.replaceAll("\\p{Punct}"," ");
        str=str.replaceAll("\\n"," ");
        String [] list = str.split(" ");
        for (int i=0; i<list.length; i++){

         if (list[i].equals("world"))
             sum++;
        }

        System.out.println(sum);

    }
}
