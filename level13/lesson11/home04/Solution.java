package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String myFile = reader.readLine();
        OutputStream outputStream = new FileOutputStream(myFile);
        while (true)
        {
            String text = reader.readLine();
            if (text.equals("exit"))
                break;
            outputStream.write(text.getBytes());
            outputStream.write("\r\n".getBytes());



        }
       /* InputStream inputStream = new FileInputStream(myFile);
        while (inputStream.available()>0)
        {int data = inputStream.read();
            System.out.print((char)data);}*/
        outputStream.close();
       // inputStream.close();
   }

    }
