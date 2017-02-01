package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public volatile static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static Date birthDate = null;
    public static String name = null;
    public static Sex sex = null;

    static
    {

        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1

    }

    public static void main(String[] args) throws ParseException
    {

switch (args[0]){
    case ("-c"):
    {add(args);
        break;}
    case ("-u"):
    {update(args);
        break;}
    case ("-d"):
    {delete(args);
        break;}
    case ("-i"):
    { info(args);
        break;}
}

    }

    public synchronized static void add(String args[]) throws ParseException
    {
        int i = 1;
        while (i < args.length)
        {
            name = args[i];
            sex = sexm(args[i + 1]);
            birthDate = simpleDateFormat.parse(args[i + 2]);
            i += 3;
            if (sex.equals(Sex.MALE))
            {
                allPeople.add(Person.createMale(name, birthDate));
            } else
            {
                allPeople.add(Person.createFemale(name, birthDate));
            }
            System.out.println(allPeople.size() - 1);
        }
    }

    public synchronized static void update(String args[]) throws ParseException
    {

        int i = 1;
        while (i < args.length)
        { int index = Integer.parseInt(args[i]);
            name = args[i + 1];
            Sex sex = sexm(args[i + 2]);
            birthDate = simpleDateFormat.parse(args[i + 3]);
            allPeople.get(index).setName(name);
            allPeople.get(index).setSex(sex);
            allPeople.get(index).setBirthDay(birthDate);
            i += 4;

        }
    }

    public static synchronized void delete(String args[])
    {
        int i=1;
        while (i <args.length)
        {int index = Integer.parseInt(args[i]);
            allPeople.get(index).setName(null);
            allPeople.get(index).setSex(null);
            allPeople.get(index).setBirthDay(null);
            i++;
        }
    }

    public static synchronized void info(String args[])
    {
        int i=1;
        while (i <args.length)
        {int index = Integer.parseInt(args[i]);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String sexFormat;
            if (allPeople.get(index).getSex().equals(Sex.MALE))
                sexFormat = "м";
            else sexFormat = "ж";
            System.out.println(allPeople.get(index).getName() + " " + sexFormat + " " + sdf.format(allPeople.get(index).getBirthDay()));
            i++;
        }
    }

    public static Sex sexm(String str)
    {
        if (str.equals("м"))
            return Sex.MALE;
               return Sex.FEMALE;
    }
}
