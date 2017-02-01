package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();
        ArrayList<String> file1 = new ArrayList<>();
        ArrayList<String> file2 = new ArrayList<>();
        BufferedReader br1= new BufferedReader(new FileReader(fileName1));
        while (br1.ready())
            file1.add(br1.readLine());
        br1.close();
        BufferedReader br2= new BufferedReader(new FileReader(fileName2));
        while (br2.ready())
            file2.add(br2.readLine());
        br2.close();

        int i=0;
       try
       {while (!(file1.isEmpty() && file2.isEmpty()))

           if (!file1.isEmpty() && file2.isEmpty())
           {lines.add(new LineItem(Type.REMOVED, file1.get(i)));
               file1.remove(i);}
           else if (file1.isEmpty() && !file2.isEmpty())
           {
               lines.add(new LineItem(Type.ADDED, file2.get(i)));
               file2.remove(i);}
          else if (file1.get(i).equals(file2.get(i)))
            {lines.add(new LineItem(Type.SAME, file1.get(i)));
            file1.remove(i);
            file2.remove(i);
            }
            else if (file1.size()>1 && !file1.get(i).equals(file2.get(i)) && (file1.get(i+1).equals(file2.get(i))))
            {lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                file1.remove(i);}

            else if (file2.size()>1 && !file1.get(i).equals(file2.get(i)) && (file1.get(i).equals(file2.get(i+1))))
            {
                lines.add(new LineItem(Type.ADDED, file2.get(i)));
                file2.remove(i);
            }
       else if (file1.size()==1 && file2.size()>1)
           {
               lines.add(new LineItem(Type.ADDED, file2.get(i)));
               file2.remove(i);
           }
           else if (file2.size()==1 && file1.size()>1)
           {
               lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                   file1.remove(i);}}
       catch (IndexOutOfBoundsException e)
       {}
        for (LineItem line1 : lines)
        {
            System.out.println(line1.type+" "+line1.line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
