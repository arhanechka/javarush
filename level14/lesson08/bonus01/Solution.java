package com.javarush.test.level14.lesson08.bonus01;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        int[] a = new int[5];
        try
        {
            a[6] = 5;

        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            exceptions.add(e);
        }
        try
        {
            Double d = null;
            Double c = d + 0.12;
        }
        catch (NullPointerException e)
        {
            exceptions.add(e);
        }
        String string = "1jhfds2334";
        Integer number = null;
        try
        {
            number = Integer.parseInt(string);
        }
        catch (NumberFormatException e)
        {
            exceptions.add(e);
        }
        try
        {
            System.out.println(string.charAt(string.length() + 1));
        }
        catch (IndexOutOfBoundsException e)
        {
            exceptions.add(e);
        }
        try
        {
            int[] ar = new int[-2];
        }
        catch (NegativeArraySizeException e)
        {
            exceptions.add(e);
        }
        try
        {
            Object x[] = new String[3];
            x[0] = new Integer(0);
        }
        catch (ArrayStoreException e)
        {
            exceptions.add(e);
        }
        try
        {
            Object t = new Double(0.13);
            System.out.println((String) t);
        }
        catch (ClassCastException e)
        {
            exceptions.add(e);
        }



        try
        {
            ArrayList list = new ArrayList<>();
            list.get(-1);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try {


            throw new IllegalStateException("MyException");

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        }
    }




