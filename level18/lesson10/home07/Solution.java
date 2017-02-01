package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        File file = new File(fileName);
        ArrayList<String> list = new ArrayList<>();
       // ArrayList<String> list1 = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext())
            list.add(scanner.nextLine());
//        for (int i=0; i<list.size(); i++)
//        {
//           list1.add(i,list.get(i).substring(0, list.get(i).indexOf(' ')));
//        }
//        for (String s : list1)
//        {
//            System.out.print(s+" ");
//        }
        String id = args[0]+" ";
        for (String s : list)
        {
            if (s.contains(id))
                System.out.println(s);
        }
        br.close();
        scanner.close();

    }

}
