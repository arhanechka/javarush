package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream f = new FileInputStream(args[0]);
        int sum = 0;

        while (f.available() > 0)
        {
            int data = f.read();
            if ((data >= 65 && data <= 90) || (data >= 97 && data <= 122))
            {
                sum++;
            }
        }
        System.out.println(sum);
        f.close();
    }
}
