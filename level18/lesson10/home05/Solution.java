package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        File file_one = new File(fileName1);
        File file_two = new File(fileName2);
        FileInputStream fis = new FileInputStream(file_one);
        FileOutputStream fos = new FileOutputStream(file_two);

        byte[] buf = new byte[(int)file_one.length()];
        fis.read(buf);

        ArrayList<Integer> list = new ArrayList<>();
        String myStr=new String(buf);
        for (String retval : myStr.split(" ", 0)) {
            list.add((int) Math.round(Double.parseDouble(retval)));
        }

        StringBuffer myNewStr = new StringBuffer();
        for (Integer integer : list)
        {
            myNewStr.append(String.valueOf(integer + " "));
        }
        String result = String.valueOf(myNewStr);
        fos.write(result.getBytes());
        fis.close();
        fos.close();
    }



    }


