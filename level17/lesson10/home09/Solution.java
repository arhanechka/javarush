package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        Scanner scanner = new Scanner(new File(file1));
        while (scanner.hasNext())
            allLines.add(scanner.nextLine());
        scanner=new Scanner(new File(file2));
        while (scanner.hasNext())
            forRemoveLines.add(scanner.nextLine());
        Solution solution = new Solution();
       try{ solution.joinData();}
       catch (CorruptedDataException e){}

    }

    public void joinData () throws CorruptedDataException
    {
       if (allLines.containsAll(forRemoveLines))
       {
           allLines.removeAll(forRemoveLines);
           System.out.println(allLines);}
else
        for (String forRemoveLine : forRemoveLines)
         if (!allLines.contains(forRemoveLine))
         { allLines.clear();
             System.out.println(allLines);
             throw new CorruptedDataException();}


    }

    }

