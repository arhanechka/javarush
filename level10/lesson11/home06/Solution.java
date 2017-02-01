package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        int age;
        String lastname;
        float weight;
        double height;
        String[] address;

    public Human(String name){
        this.name=name;
    }
    public Human (String name, int age){
        this.name=name;
        this.age=age;
    }
        public Human (String name, int age, String[]address){
            this.name=name;
            this.age=age;
            this.address=address;
        }
        public Human (String name, int age, float weight){
            this.name=name;
            this.age=age;
            this.weight=weight;
        }
        public Human (String name, int age, double height){
            this.name=name;
            this.age=age;
            this.height=height;
        }
        public Human (String name, int age, float weight, double height){
            this.name=name;
            this.age=age;
            this.weight=weight;
            this.height=height;
        }
        public Human (String name, int age, float weight, String[] address){
            this.name=name;
            this.age=age;
            this.weight=weight;
            this.address=address;
        }
        public Human (String name, float weight, String[] address){
            this.name=name;

            this.weight=weight;
            this.address=address;
        }
        public Human (String name, int age, double height, String[] address){
            this.name=name;
            this.age=age;
            this.height=height;
            this.address=address;
        }
        public Human (String name, String lastname, String[] address)
        {
            this.name = name;
            this.lastname=lastname;
            this.address = address;
        }
        public Human (String name, String lastname, int age, double height, String[] address){
            this.name=name;
            this.age=age;
            this.height=height;
            this.address=address;
        }
}}
