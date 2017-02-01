package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static File file;
    public static ArrayList<String> list;

    public static void main(String[] args) throws IOException
    {
        list = new ArrayList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        file = new File(fileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNext())
        {
            list.add(sc.nextLine());
        }

        switch (args[0])
        {
            case ("-u"):
            {
                update(args);
                break;
            }
            case ("-d"):
            {
                delete(args);
                break;
            }
        }

    }

    public static int getId(String[] args)
    {
        int id = Integer.parseInt(args[1]);

        int index = 0, oldId = 0;

        for (int i = 0; i < list.size(); i++)
        {
            String idInList = list.get(i).substring(0, 8);
            try
            {
                oldId = Integer.parseInt(idInList.substring(0, idInList.indexOf(' ')));
            }
            catch (StringIndexOutOfBoundsException e)
            {
                oldId = Integer.parseInt(idInList);
            }
            if (oldId == id)
            {
                index = i;
                break;
            }
        }
        if (index==id)
            return index;
        else
        {
            System.out.println("There is not such element in the database");
            return list.size()+1;
        } }

    public static String setSpaces(String str, int number)
    {
        while (str.length() < number)
        {
            str += " ";
        }
        return str;
    }

    public static void record() throws IOException
    {
        FileOutputStream fos = new FileOutputStream(file);

        fos.write(list.get(0).getBytes());
        fos = new FileOutputStream(file, true);
        for (int i = 1; i < list.size(); i++)
        {
            fos.write(("\r\n" + list.get(i)).getBytes());
        }

    }

    public static void update(String[] args) throws IOException
    {
        int index = getId(args);

        String idForRecord = setSpaces(String.valueOf(args[1]), 8);
        String productName = setSpaces(args[2], 30);
        String price = setSpaces(args[3], 8);
        String quantity = setSpaces(args[4], 4);
        String row = idForRecord + productName + price + quantity;
        list.set(index, row);
        record();
    }

    public static void delete(String[] args) throws IOException
    {
        int index = getId(args);
        list.remove(index);
        record();
    }

}
