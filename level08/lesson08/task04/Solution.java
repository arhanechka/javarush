package com.javarush.test.level08.lesson08.task04;

import javax.swing.text.html.HTMLDocument;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
//    public static void main(String[] args)
//    {
//        removeAllSummerPeople(createMap());
//    }
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Kruz", new Date("APRIL 1 1956"));
        map.put("Wefwefwf", new Date("AUGUST 10 1934"));
        map.put("Stall", new Date("OCTOBER 12 1990"));
        map.put("Pots", new Date("SEPTEMBER 21 1954"));
        map.put("Google", new Date("JANUARY 21 1943"));
        map.put("Swdydwy", new Date("MARCH 31 2002"));
        map.put("Swdwdq", new Date("JULY 12 1990"));
        map.put("Swqdwll", new Date("JUNE 01 1991"));
        map.put("Stawe", new Date("OCTOBER 12 1990"));
//        for (Map.Entry<String, Date> stringDateEntry : map.entrySet())
//        {
//            System.out.println(stringDateEntry);
//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        }
    return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator <Map.Entry<String,Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
        int i=iterator.next().getValue().getMonth();

            if (i==5 || i==6 || i==7)
               iterator.remove();
            
        }
//        for (Map.Entry<String, Date> stringDateEntry : map.entrySet())
//        {
//            System.out.println(stringDateEntry);
//        }
    }
}
