package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
static{
    countries.put("UA", "Ukraine");
    countries.put("RU", "Russia");
    countries.put("CA", "Canada");
}

    public static void main(String[] args)
    {
        IncomeDataAdapter ia = new IncomeDataAdapter(new IncomeData()
        {
            @Override
            public String getCountryCode()
            {
                return null;
            }

            @Override
            public String getCompany()
            {
                return null;
            }

            @Override
            public String getContactFirstName()
            {
                return null;
            }

            @Override
            public String getContactLastName()
            {
                return null;
            }

            @Override
            public int getCountryPhoneCode()
            {
                return 38;
            }

            @Override
            public int getPhoneNumber()
            {
                return 5012345;
            }
        });
        System.out.println(ia.getPhoneNumber());
    }
    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData incomeData;
        public IncomeDataAdapter (IncomeData incomeData){
            this.incomeData=incomeData;
        }
        @Override
        public String getCompanyName()
        {
            return incomeData.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get(incomeData.getCountryCode());
        }

        @Override
        public String getName()
        {
            return incomeData.getContactLastName()+", "+incomeData.getContactFirstName() ;
        }

        @Override
        public String getPhoneNumber()
        {       String wholeNumber = String.valueOf(incomeData.getPhoneNumber());

            if (String.valueOf(incomeData.getPhoneNumber()).length()<10)
            {       String phone="0";
           for (int i=String.valueOf(incomeData.getPhoneNumber()).length()+1; i<10; i++)
           { phone+="0";}

                wholeNumber =phone+wholeNumber;
        }
            System.out.println(wholeNumber);
            String oper = wholeNumber.substring(0,3);
            String first = wholeNumber.substring(3,6);
            String second = wholeNumber.substring(6,8);
            String third = wholeNumber.substring(8);
            return "+"+String.valueOf(incomeData.getCountryPhoneCode())+"("+oper+")"+first+"-"+second+"-"+third;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}