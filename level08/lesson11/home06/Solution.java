package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> parents = new ArrayList<>();
        ArrayList<Human> children = new ArrayList<>();

        Human son1 = new Human("Mytya", true, 15, new ArrayList<Human>());
        children.add(son1);
        Human son2 = new Human("Jenya", true, 12, new ArrayList<Human>());
        children.add(son2);
        Human doughter = new Human("Fanya", false, 8, new ArrayList<Human>());
        children.add(doughter);
        Human father = new Human("Serega", true, 42, children);
        parents.add(father);
        Human mother = new Human("Tanyuha", false, 38, children);
        parents.add(mother);
        Human grandFather1 = new Human("Vasya", true, 75, parents);
        Human grandFather2 = new Human("Kolya", true, 70, parents);
        Human grandMother1 = new Human("Tosya", false, 71, parents);
        Human grandMother2 = new Human("Sonya", false, 69, parents);

        System.out.println(grandFather1.toString());
        System.out.println( grandFather2.toString());
        System.out.println(grandMother1.toString());
        System.out.println(grandMother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
        System.out.println(doughter.toString());
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
