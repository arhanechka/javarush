package com.javarush.test.level12.lesson02.task04;

/* Или «Кошка», или «Собака», или «Птица», или «Лампа»
Написать метод, который определяет, объект какого класса ему передали, и выводит на экран одну из надписей: Кошка, Собака, Птица, Лампа.
*/

public class Solution
{
    public static void main(String[] args)
    {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());

    }

    public static void printObjectType(Object o)
    {
       System.out.println (o instanceof Cat? "Кошка": o instanceof Bird? "Птица": o instanceof Lamp? "Лампа": "Собака");

       }



    public static class Cat
    {
    }

    public static class Dog
    {
    }

    public static class Bird
    {
    }

    public static class Lamp
    {
    }
}
