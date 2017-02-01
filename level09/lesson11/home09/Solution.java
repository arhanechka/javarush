package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        HashMap <String,Cat> catMap = new HashMap<>();
       catMap.put("Пушок", new Cat("Пушок"));
       catMap.put("Снежок", new Cat("Снежок"));
       catMap.put("Мурчик", new Cat("Мурчик"));
       catMap.put("Васька", new Cat("Васька"));
       catMap.put("Патрик", new Cat("Патрик"));
       catMap.put("Жан", new Cat("Жан"));
       catMap.put("Муська", new Cat("Муська"));
       catMap.put("Дуська", new Cat("Дуська"));
       catMap.put("Мурло", new Cat("Мурло"));
       catMap.put("Машка", new Cat("Машка"));

        return catMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {Set <Cat> cats = new HashSet<>();
        for (Cat s : map.values())
        {
            cats.add(s);
        }
    return cats;}

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
