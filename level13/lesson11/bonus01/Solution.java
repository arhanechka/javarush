package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String myFile = reader.readLine();
        InputStream fileInputStream = new FileInputStream(myFile);
        char c;
        String str = "";
        while (fileInputStream.available() > 0)
        {
            c = (char) fileInputStream.read();
            if (isNumber(c))
            {
                str += String.valueOf(c);
            } else
            {
                list.add(str);
                str = "";
               // continue;
            }
        }
        if (!str.isEmpty()) {
            list.add(str);
        }
        for (String s : list)
        {
            try
            {
                if (Integer.parseInt(s) % 2 == 0)
                    numbers.add(Integer.parseInt(s));
            }
            catch (NumberFormatException e)
            {
            }

        }
//        for (String s : list)
//        {
//            System.out.print(s+",");
//        }
//        System.out.println();
//        for (Integer number : numbers)
//        {
//            System.out.print(number+",");
//        }
       sort(numbers);
        for (Integer number : numbers)
        {
            System.out.println(number);
        }
    }

    public static void sort(ArrayList<Integer> numbers)
    {
        for (int i = 0; i < numbers.size() - 1; i++)
            for (int j = i + 1; j < numbers.size(); j++)
            {
                if (numbers.get(j) < numbers.get(i))
                {
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, temp);
                }
            }
    }

    public static boolean isNumber(char c)
    {
        if (c >= 48 & c <= 57)
        {
            return true;
        }
            return false;
    }
}
