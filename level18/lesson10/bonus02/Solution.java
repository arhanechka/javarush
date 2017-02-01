package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id,
найденный в файле

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
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();

        File file = new File(fileName);

        String temp = new String();


        Scanner sc = new Scanner(file);
        while (sc.hasNext())
        {
            temp = sc.nextLine();
        }

        br.close();
        String id = getId(temp.substring(0, 8));
        String productName = setSpaces(args[1], 30);
        String price = setSpaces(args[2], 8);
        String quantity = setSpaces(args[3], 4);
        String row = "\r\n" + id + productName + price + quantity;

        FileOutputStream fos = new FileOutputStream(file, true);
        fos.write(row.getBytes());
    }

    public static String getId(String temp)
    {

        int id = 0;
        String idWithSpaces = null;

        try
        {

            id = Integer.parseInt(temp.substring(0, temp.indexOf(' ')));
            id++;
            idWithSpaces = setSpaces(String.valueOf(id), 8);
        }
        catch (StringIndexOutOfBoundsException e)
        {
            id = Integer.parseInt(temp.substring(0, 8));
            id++;
            idWithSpaces = String.valueOf(id);
        }
        return idWithSpaces;
    }

    public static String setSpaces(String str, int number)
    {
        while (str.length() < number)
        {
            str += " ";
        }
        return str;
    }
}
