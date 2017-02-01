package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        File file = new File(fileName);
        String openTag = "<"+args[0];

        String closeTag = "</" + args[0]+">";

        FileInputStream fis = new FileInputStream(file);
        byte [] buff = new byte[(int) file.length()];
        fis.read(buff);
        String result = new String(buff);
    result=result.replaceAll("\\r\\n", "");
        result=result.substring(result.indexOf(openTag),result.lastIndexOf(closeTag))+closeTag;
       // System.out.println(result);
        int begin = result.indexOf(openTag);
        int end = result.indexOf(closeTag);
        String temp = result.substring(begin,end)+closeTag;
        System.out.println(temp);
Pattern pattern=Pattern.compile("[openTag]{2}");
        Matcher matcher=pattern.matcher(temp.substring(openTag.length()));
        if (matcher.find())
{
    String inner = temp.substring(temp.lastIndexOf(openTag));
    System.out.println(temp);
}

     //   System.out.println(result);
//
//        String[] list1 = result.split(openTag);
//         List<String> list = Arrays.asList(list1);
//        for (String s : list)
//        {if (!Pattern.matches (openTag, openTag))
//        { if (s.startsWith(">")|| (s.startsWith(" ")))
//           {if (!s.endsWith(closeTag))
//           {int temp=s.indexOf(closeTag);
//               System.out.println(openTag+s.substring(0,temp)+closeTag);}
//            else
//                System.out.println(openTag+s+closeTag);
//            }}
//            else
//
//        }
//        for (String s : list)
//        {
//            System.out.println(s);
//        }
//        System.out.println();
//        int i=0;
//        while (i<list.size())
//        {
//            if (list.get(i).startsWith(openTag))
//            for (int j=i; !list.get(j).endsWith(closeTag); j++)
//            { System.out.println(list.get(j-1) +" ");
//            i++;}
//            else
//                i++;
//
//        }
    }

}
