package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(createMap());
        removeTheFirstNameDuplicates(createMap());
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {

        HashMap<String, String> copy1 = new HashMap<>(map);
        ArrayList <String> list = new ArrayList<>(copy1.values());
        String str = "";
        for (int i=0; i<copy1.values().size()-1; i++)

         for (int j=i+1; j<copy1.values().size(); j++)
        {
            str = list.get(i);
            if (str.equals(list.get(j)))

            removeItemFromMapByValue(map, str);

        }

        System.out.println(map);
    }


    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
