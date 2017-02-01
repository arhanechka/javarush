package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> list = new TreeSet<>(new Sort());
        while (true)
        {
            String partFileName = br.readLine();
            if (partFileName.equals("end"))
            {
                break;
            }
            list.add(partFileName);
        }
        br.close();

        FileOutputStream fos = new FileOutputStream(list.first().substring(0,list.first().lastIndexOf('.')), true);
        for (String s : list)
        {
            File newFile = new File(s);
            FileInputStream fis = new FileInputStream(newFile);
            byte[] buf = new byte[(int) newFile.length()];
            fis.read(buf);
            fos.write(buf);
            fis.close();
        }
        fos.close();
    }
    static class Sort implements Comparator<String>
    {
        public int compare(String a, String b) {
            int one =a.indexOf("part")+4;
            int two = a.indexOf("part")+4;
            return Integer.parseInt(a.substring(one)) - Integer.parseInt(b.substring(two));}}}