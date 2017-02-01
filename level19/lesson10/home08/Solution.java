package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        BufferedReader br1 = new BufferedReader(new FileReader(fileName));
        while (br1.ready())
            list.add(br1.readLine());
        br1.close();
        for (int i=0; i<list.size(); i++)
        {
            StringBuffer sb = new StringBuffer(list.get(i));
            sb.reverse();
            list.set(i, String.valueOf(sb));

        }
        for (String s : list)
        {
            System.out.println(s);
        }

    }
}
