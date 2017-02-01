package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<>();
        String fileName = args[0];
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String str;
        while ((str = br.readLine())!=null)
        {list.add(str);}
        br.close();
        TreeMap<String,Double> map = new TreeMap<>();
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        for (String s : list)
        {
            lastNames.add(s.substring(0,s.indexOf(" ")));
            values.add(Double.parseDouble(s.substring(s.indexOf(" "),s.length())));
        }
        for (String s : list)
        {
            map.put(s.substring(0,s.indexOf(" ")),0.0);
        }
        for (Map.Entry<String, Double> s : map.entrySet())
        {
            for (int i=0; i<lastNames.size(); i++)
            {if (s.getKey().equals(lastNames.get(i)))
            {
                s.setValue(s.getValue()+values.get(i));
            }}
        }
        int max=0;
       TreeMap<Double,String> newMap = new TreeMap<>();
        for (Map.Entry<String, Double> sd : map.entrySet())
        {
            newMap.put(sd.getValue(),sd.getKey());
        }

        System.out.println(newMap.lastEntry().getValue());
    }}

