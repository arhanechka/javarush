package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> mySet = new HashSet<>();
        mySet.add("Ляля");
        mySet.add("Лама");
        mySet.add("Лопух");
        mySet.add("Лопасть");
        mySet.add("Лига");
        mySet.add("Липа");
        mySet.add("Лак");
        mySet.add("Лапа");
        mySet.add("Луна");
        mySet.add("Лев");
        mySet.add("Лопата");
        mySet.add("Лис");
        mySet.add("Лес");
        mySet.add("Лесть");
        mySet.add("Лупа");
        mySet.add("Лоза");
        mySet.add("Лира");
        mySet.add("Лист");
        mySet.add("Лук");
        mySet.add("Лагман");
        return mySet;

    }
}
