package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human grandFather1=new Human();
        grandFather1.name="Юра";
        grandFather1.sex=true;
        grandFather1.age=82;

        Human grandFather2=new Human();
        grandFather2.name="Вася";
        grandFather2.sex=true;
        grandFather2.age=79;

        Human grandMother1=new Human();
        grandMother1.name="Таня";
        grandMother1.sex=false;
        grandMother1.age=80;

        Human grandMother2=new Human();
        grandMother2.name="Сусанна";
        grandMother2.sex=false;
        grandMother2.age=65;

        Human mother=new Human();
        mother.name="София";
        mother.sex=false;
        mother.age=35;
        mother.mother=grandMother1;
        mother.father=grandFather1;

        Human father=new Human();
        father.name="Сергей";
        father.sex=true;
        father.age=41;
        father.mother=grandMother2;
        father.father=grandFather2;

        Human son1=new Human();
        son1.name="Павел";
        son1.sex=true;
        son1.age=16;
        son1.mother=mother;
        son1.father=father;

        Human son2=new Human();
        son2.name="Натан";
        son2.sex=true;
        son2.age=12;
        son2.mother=mother;
        son2.father=father;

        Human doughter=new Human();
        doughter.name="Ева";
        doughter.sex=false;
        doughter.age=9;
        doughter.mother=mother;
        doughter.father=father;

        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(doughter);
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
