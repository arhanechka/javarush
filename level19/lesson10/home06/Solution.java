package com.javarush.test.level19.lesson10.home06;

import java.io.*;
import java.util.*;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution
{
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static
    {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одинадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext())
        {
            list.add(scanner.nextLine());
        }
        scanner.close();

        for (int j = 0; j < list.size(); j++)
        {
            String[] temp = list.get(j).split(" ");

            for (int i = 0; i < temp.length; i++)
            {
                try
                {
                    int number = Integer.parseInt(temp[i]);
                    for (Map.Entry<Integer, String> mapSet : map.entrySet())
                    {
                        if (number == mapSet.getKey())
                        {
                            temp[i] = mapSet.getValue();
                        }
                    }
                }
                catch (NumberFormatException e)
                {
                }

            }
            String result = new String();
            for (String s1 : temp)
            {
                result += s1 + " ";
            }
            list.set(j, result);
            System.out.println(list.get(j));
        }

    }

}
