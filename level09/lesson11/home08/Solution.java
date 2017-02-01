package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Random;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной
5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> list = new ArrayList<>();
        Random random = new Random();
        int[] one = new int[5];
        int[] two = new int[2];
        int[] three = new int[4];
        int[] four = new int[7];
        int[] five = new int[0];
        for (int i = 0; i < one.length; i++)
        {
            one[i] = random.nextInt(100);
        }
        list.add(one);
        for (int i = 0; i < two.length; i++)
        {
            two[i] = random.nextInt();
        }
        list.add(two);
        for (int i = 0; i < three.length; i++)
        {
            three[i] = random.nextInt();
        }
        list.add(three);
        for (int i = 0; i < four.length; i++)
        {
            four[i] = random.nextInt();
        }
        list.add(four);
        for (int i = 0; i < five.length; i++)
        {
            five[i] = random.nextInt();
        }
        list.add(five);


        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array : list)
        {
            for (int x : array)
            {
                System.out.println(x);
            }
        }
    }
}
