package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution1
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<String> numbers = new ArrayList<String>();
        ArrayList<String> strings = new ArrayList<String>();
        for (String s : array) {
            if(isNumber(s)) numbers.add(s);
            else strings.add(s);
        }
        boolean needNext = true;
        while (needNext) {
            needNext = false;
            for (int i = 0; i <numbers.size()-1 ; i++) {
                int a = Integer.parseInt(numbers.get(i));
                int b = Integer.parseInt(numbers.get(i+1));
                if (a<b) {
                    numbers.set(i,b+"");
                    numbers.set(i+1,a+"");
                    needNext = true;
                }
            }
        }
        System.out.println(numbers.toString());
        needNext = true;
        while (needNext) {
            needNext = false;
            for (int i = 0; i <strings.size()-1 ; i++) {
                String a = strings.get(i);
                String b = strings.get(i+1);
                if (isGreaterThen(a, b)) {
                    strings.set(i,b);
                    strings.set(i+1,a);
                    needNext = true;
                }
            }
        }
        System.out.println(strings.toString());
        String result [] = array.clone();
        for (int i = 0; i <array.length ; i++) {
            if(isNumber(result[i])) {
                array [i]= numbers.remove(0);
            }
            else array [i] = strings.remove(0);
        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
