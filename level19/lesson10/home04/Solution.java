package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String fileName = br.readLine();
       BufferedReader br1 = new BufferedReader(new FileReader(fileName));
        int sum;
        while (br1.ready())
        {
            String s = br1.readLine();
            if (s.contains(" ") && s.length() >= 2)
            {
                sum = 0;
                String[] buf = s.split(" ");
                List<String> myWords = new ArrayList<String>(Arrays.asList(buf));

                for (String word : words)
                {
                    if (myWords.contains(word))
                    {
                        sum++;
                    }
                }
                if (sum == 2)
                    System.out.println(s);
            }
        }
        br.close();
        br1.close();


    }
}
