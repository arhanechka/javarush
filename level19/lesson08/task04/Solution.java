package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(baos);
        System.setOut(output);
        testString.printSomething();
        System.setOut(console);
        String result = baos.toString();
        String[] array = result.split(" ");
        ArrayList <Integer> list = new ArrayList<>();
        for (String s : array)
        {try
        {
            list.add(Integer.parseInt(s));
        }
        catch (NumberFormatException e){}

        }
        if (result.contains("+"))
            System.out.println(list.get(0) +" + "+list.get(1)+" = "+(list.get(0)+list.get(1)));
        else if (result.contains("-"))
            System.out.println(list.get(0) +" - "+list.get(1)+" = "+(list.get(0)-list.get(1)));
        else
            System.out.println(list.get(0) +" * "+list.get(1)+" = "+(list.get(0)*list.get(1)));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

