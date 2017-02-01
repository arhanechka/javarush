package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> resultList = new ArrayList<>();
        String fileName = args[0];
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext())
            list.add(scanner.next());
        scanner.close();
        String result=new String();
        for (int i = 0; i < list.size(); i++)
        {

            result = new String();
            for (int j = 0; j < list.size(); j++)
                if (list.get(j).length() > 6)
                {
                 result += list.get(j)+",";
                }

        }


        FileOutputStream fos = new FileOutputStream(args[1]);
        fos.write(result.substring(0,result.length()-1).getBytes());
        fos.close();

    }
}
