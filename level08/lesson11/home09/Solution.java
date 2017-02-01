package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
//        String date = "October 6 2014";
//        System.out.println(date+" = "+isDateOdd(date));
    }

    public static boolean isDateOdd(String date)
    {boolean check=true;
        Date finishDate= new Date(date);
        Date startDate = new Date (date);
        startDate.setMonth(1);
        startDate.setDate(0);
        long result = finishDate.getTime()-startDate.getTime();
        long msInDay = 24 * 60 * 60 * 1000;
        long numberOfDays=result/msInDay;
        System.out.println(numberOfDays);
        if (numberOfDays%2==0)
            return true;
        else return false;
    }
}
