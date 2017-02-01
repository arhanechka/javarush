package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/
public class Cat
{
    private String name;
    private int age;
    private int weight;
    private String colour;
    String address;
    public void initialize(String name){
        this.name=name;
    }
    public void initialize(String name, int age){
        this.name=name;
        this.age=age;
        this.weight=20;
        this.address=null;
        this.colour="mixed";
    }
    public void initialize(String name, int age, int weight){
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.address=null;
        this.colour="mixed";
    }
    public void initialize( int weight, String colour){
        this.name=null;
        this.age=0;
        this.weight=weight;
        this.colour=colour;
        this.address=null;
    }
    public void initialize( int weight, String colour, String address){
        this.name=null;
        this.age=0;
        this.weight=weight;
        this.colour=colour;
        this.address=address;
    }

}
