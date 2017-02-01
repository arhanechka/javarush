package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Anya on 25.12.2016.
 */
public class Singleton

{private static Singleton singleton;
    private Singleton(Singleton singleton){
   Singleton.singleton=singleton;
        getInstance();
}
    public static Singleton getInstance(){
    return Singleton.singleton;
}
}
