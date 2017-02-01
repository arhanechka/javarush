package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        int begin = url.indexOf("?");
        String part = url.substring(begin + 1);//отделяем часть строки после ?
        part = part.trim(); //удаляем лишний пробел
        String[] lines = part.split("&");//массив параметров
        String[] lines1 = part.split("&");//копия массива параметров для отделения значений

        //   ArrayList <String > objects=new ArrayList();
        for (int i = 0; i < lines.length; i++)
        {
            if (lines1[i].contains("="))
            {
                int ind = lines1[i].indexOf("=");
                lines1[i] = lines1[i].substring(0, ind);//укоротили массив, оставили только параметры
                // objects.add(lines[i].substring(ind+1, lines[i].length()));//отправили значения в лист
            }
        }

        for (String line : lines1)
        {
            System.out.print(line + " ");
        }
        System.out.println();
        String value = null;
        for (int i = 0; i < lines1.length; i++)
            if (lines1[i].equals("obj"))
            {
                try
                {
                    int ind = lines[i].indexOf("=");
                    value = lines[i].substring(ind + 1);
                    alert(Double.parseDouble(value));
                }
                catch (NumberFormatException e)
                {
                    alert(value);
                }
            }
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
