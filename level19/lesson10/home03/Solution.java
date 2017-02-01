package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<>();
        String fileName = args[0];
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String str;
        while ((str = br.readLine()) != null)
        {
            list.add(str);
        }
        br.close();
        ArrayList<String[]> substings = new ArrayList<>();
        for (String s : list)
        {
            substings.add(s.split("\\s"));
        }

        for (String[] substing : substings)
        {
            String name = new String();
            int year = Integer.parseInt(substing[substing.length - 1]);

            int month = Integer.parseInt(substing[substing.length - 2]);

            int day = Integer.parseInt(substing[substing.length - 3]);

            for (int i = 0; i < substing.length - 3; i++)
            {
                name += substing[i] + " ";
            }

            Date date = new GregorianCalendar(year, month-1, day).getTime();
            PEOPLE.add(new Person(name.trim(), date));
        }
        for (Person person : PEOPLE)
        {
            System.out.println(person.toString());
        }


    }
}
