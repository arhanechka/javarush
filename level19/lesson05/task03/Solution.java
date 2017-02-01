package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        String fileName1 = br.readLine();
        br.close();
        File file = new File(fileName);
        String str;
        ArrayList<String> list = new ArrayList();
        BufferedReader fr = new BufferedReader(new FileReader(file));
        while ((str = fr.readLine()) != null)
            list.add(str);
        fr.close();
        String[] listWords;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String s : list)
        {
            listWords = s.split(" ");
            for (String listWord : listWords)
            {
                try
                {
                    int temp = Integer.parseInt(listWord);
                    numbers.add(temp);
                }

                catch (NumberFormatException e)
                {
                    continue;
                }
            }
        }

        FileOutputStream fos = new FileOutputStream(fileName1);

        for (Integer number : numbers)
        {
            fos.write((String.valueOf(number) + " ").getBytes());
        }
fos.close();
    }


}


