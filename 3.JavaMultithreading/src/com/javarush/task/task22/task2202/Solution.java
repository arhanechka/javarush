package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));

    }

    public static String getPartOfString(String string) {
        if (string == null)
            throw new TooShortStringException();
        int count = 0;
        for (int i=0; i<string.length(); i++)
        if(Character.toString(string.charAt(i)).equals(" ")){
            count++;}
        StringBuffer str = new StringBuffer();
        if (count<4)
            throw new TooShortStringException();

        try {
            String[] array = string.split(" ");

            for (int i = 1; i < 5; i++)
                str.append(array[i] + " ");


            string = String.valueOf(str).trim();

        } catch (TooShortStringException e) {
        }
        return string;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
