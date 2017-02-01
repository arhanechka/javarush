package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        ArrayList<String> files = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String str = br.readLine();
            if (str.equals("exit"))
                break;
            files.add(str);}
        for (String file : files)
        {
            ReadThread rt = new ReadThread(file);
            rt.start();
            rt.join();
        }


        br.close();
    }

    public static class ReadThread extends Thread
    {
        File file;
        private FileInputStream fis;
        byte[] buf;
        String fileName;

        public ReadThread(String fileName) throws IOException
        {
            this.fileName = fileName;
            file = new File(fileName);
            fis = new FileInputStream(file);
            buf = new byte[(int) file.length()];
        }

        public void run()
        {
            try
            {
                fis.read(buf);
                search();
                fis.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        public void search()
        {


            int[] array = new int[256];
            for (int i = 0; i < buf.length; i++)
            {
                array[buf[i] &255]++;
            }

            int max = 0;
            int index = 0;
            for (int i = 0; i < array.length; i++)
                if (array[i] > max)
                {
                    max = array[i];
                    index = i;
                }

            System.out.println(index);
            resultMap.put(fileName, index);
        }
    }
}

