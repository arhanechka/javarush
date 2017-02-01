package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args)
    {

        System.out.println(getCountTheSameFirstName(createMap(),"Oleg"));
        System.out.println(getCountTheSameLastName(createMap(),"Ivanov"));

    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("Ivanov", "Ivan");
        hashMap.put("Petrov", "Petr");
        hashMap.put("Sergeev", "Ivan");
        hashMap.put("Timoschuk", "Oksana");
        hashMap.put("Semenyuk", "Oleg");
        hashMap.put("Gritskevich", "Oksana");
        hashMap.put("Opanasenko", "Oleg");
        hashMap.put("Zozulenko", "Oleg");
        hashMap.put("Zaychenko", "Yuri");
        hashMap.put("Semenov", "Semen");
        return hashMap;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int i = 0;
        for (String s : map.values())
        {
            if (name.equals(s))
                i++;
        }
        return i;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int i = 0;
        for (String s : map.keySet())
        {
            if (lastName.equals(s))
                i++;
        }
        return i;
    }
}
