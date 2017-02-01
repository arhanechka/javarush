package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name;
    private int age;
    private int weight;
    private String colour;
    String address;
    public Cat (String name){
        this.name=name;
    }
    public Cat(String name, int age){
        this.name=name;
        this.age=age;
        this.weight=20;
        this.address=null;
        this.colour="mixed";
    }
    public Cat(String name, int age, int weight){
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.address=null;
        this.colour="mixed";
    }
    public Cat( int weight, String colour){
        this.name=null;
        this.age=0;
        this.weight=weight;
        this.colour=colour;
        this.address=null;
    }
    public Cat( int weight, String colour, String address){
        this.name=null;
        this.age=0;
        this.weight=weight;
        this.colour=colour;
        this.address=address;
    }

}
