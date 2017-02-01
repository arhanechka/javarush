package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat {
    public Cat() {
    }
    public static ArrayList<Cat> cats=new ArrayList<>();

    public static void main(String[] args) {
     Cat cat1=new Cat();
        cats.add(cat1);
        Cat cat2=new Cat();
        cats.add(cat2);
        Cat cat3=new Cat();
        cats.add(cat3);
        Cat cat4=new Cat();
        cats.add(cat4);
        Cat cat5=new Cat();
        cats.add(cat5);
        Cat cat6=new Cat();
        cats.add(cat6);
        Cat cat7=new Cat();
        cats.add(cat7);
        Cat cat8=new Cat();
        cats.add(cat8);
        Cat cat9=new Cat();
        cats.add(cat9);
        Cat cat10=new Cat();
        cats.add(cat10);
        printCats();
    }

    public static void printCats() {
        for (Cat cat : cats)
        {
            System.out.println(cat.toString());
        }

    }
}
