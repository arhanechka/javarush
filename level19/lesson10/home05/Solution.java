package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        File file = new File(args[0]);
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[(int) file.length()];
        fis.read(buf);
        String str = new String(buf);

        str = str.replaceAll("\\r\\n", " ");
        String[] strings = str.split(" ");

        System.out.println();
        List<String> list = Arrays.asList(strings);

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            numbers.add(i);
        }
        String sb = new String();
        for (String s : list)
            for (Integer number : numbers)
            {
                if (s.contains(String.valueOf(number)))
                {
                    sb += s + " ";
                    break;
                }
            }
        FileOutputStream fos = new FileOutputStream(args[1]);
        fos.write(sb.trim().getBytes());

        fis.close();
        fos.close();
    }
}
