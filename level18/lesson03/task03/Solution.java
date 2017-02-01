package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        byte[] buffer = new byte[1000];
        FileInputStream fileInputStream = new FileInputStream(file);

        ArrayList<Integer> buffer1 = new ArrayList<>();
        int counter;
        while (fileInputStream.available() > 0)
        {
            counter = fileInputStream.read();
            buffer1.add (counter);
                 }


        Collections.sort(buffer1);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer integer : buffer1)
        {
            map.put(integer,0);
        }
        for (Integer integer : buffer1)
        {
            if (map.containsKey(integer)){
               int temp=map.get(integer)+1;
                map.put(integer,temp);
            }
        }
        int max=0;
        for (Integer integer : map.values())
        {
            if (integer>max)
                max=integer;
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet())
        {
            if (integerIntegerEntry.getValue()==max)
                System.out.print(integerIntegerEntry.getKey()+" ");
        }

reader.close();
        fileInputStream.close();
    }}