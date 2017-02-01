package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        String fileName1 = br.readLine();
        br.close();
        File file = new File(fileName);
        File file1 = new File(fileName1);
        byte[] buf = new byte[(int)file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(buf);
        fis.close();
        String str = new String(buf);
        int sum = 0;
        str=str.replaceAll("\\p{Punct}","");
        str=str.replaceAll("\\n","");
        FileOutputStream fos = new FileOutputStream(file1);
        fos.write(str.getBytes());
        fos.close();
    }
}
