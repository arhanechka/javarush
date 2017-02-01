package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные одного человека.
*/

public class Solution
{
    public static class PersonScannerAdapter implements PersonScanner
    {
        private Scanner scanner = new Scanner("file.txt");

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String[] list = new String[6];
            String str = scanner.nextLine();
            list = str.split(" ");
            String lastName = list[0];
            String firstName = list[1];
            String middleName = list[2];
            Calendar calendar = new GregorianCalendar(Integer.parseInt(list[5]), Integer.parseInt(list[4])-1, Integer.parseInt(list[3]));
            Date birthdate = calendar.getTime();
            return new Person(firstName, middleName, lastName, birthdate);
        }

        @Override
        public void close() throws IOException
        {

        }
    }
}
