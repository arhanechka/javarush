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
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        File file = new File(fileName);
        String openTag = "<" + args[0];

        String closeTag = "</" + args[0] + ">";

        FileInputStream fis = new FileInputStream(file);
        byte[] buff = new byte[(int) file.length()];
        fis.read(buff);
        fis.close();
        String result = new String(buff);
        result = result.replaceAll("\\r\\n", "");
        try
        {
            result = result.substring(result.indexOf(openTag), result.lastIndexOf(closeTag)) + closeTag;
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("There is no such tag in the document");
        }

        Stack<String> stack = new Stack<>();
      int i = result.indexOf(args[0]);
        int temp = result.indexOf(args[0], i + 1);
        while (i < result.length())
        {
            temp = result.indexOf(args[0], i + 1);

            if ((temp == -1) || (i == -1))
            {
                break;
            } else if (result.charAt(i - 1) == '<' && result.charAt(temp - 1) == '/')
            {
                String substr = result.substring(i - 1, temp + args[0].length() + 1);
                System.out.println(substr);
                i = result.indexOf(args[0], temp + args[0].length() + 1);
            } else if (result.charAt(i - 1) == '<' && result.charAt(temp - 1) == '<')
            {
                int endTag = result.indexOf(closeTag,i);
                int first = result.indexOf(closeTag,i);
                int beg = result.indexOf(closeTag,i);
                int last = result.indexOf(closeTag,i);

                while (beg > i)
                {
                    last = result.indexOf(closeTag, endTag) + args[0].length() + 3;
                    String check = result.substring(0, first);
                    beg = check.lastIndexOf(args[0]);
                    String str = result.substring(beg - 1, last);
                    stack.push(str);
                    first = beg - 1;
                    endTag = last;

                }
                while (!stack.empty())
                {
                    System.out.println(stack.pop());
                }
                i = last + 1;
            }
            else if (result.charAt(i-1)=='<')
            {
            temp=result.indexOf(closeTag,i);
                System.out.println(result.substring(i - 1, temp)+closeTag);
           i = result.indexOf(args[0], temp + args[0].length() +3);}
            else
            {i = result.indexOf(args[0], temp + args[0].length() +3);}
        }
    }
}












