package com.javarush.test.level17.lesson10.bonus01;


import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception
    {
        Person newPerson = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = null;
        String name = null;
        Sex sex = null;

        switch (args[0])
        {
            case ("-c"):
            {
                name = args[1];
                birthDate = simpleDateFormat.parse(args[3]);

                sex = sexm(args[2]);

                if (sex.equals(Sex.MALE))
                {
                    newPerson = Person.createMale(name, birthDate);
                } else
                {
                    newPerson = Person.createFemale(name, birthDate);
                }
                allPeople.add(newPerson);
                System.out.println(allPeople.size() - 1);

                break;
            }
            case ("-u"):
            {
                int index = Integer.parseInt(args[1]);
                name = args[2];
                birthDate = simpleDateFormat.parse(args[4]);
                newPerson = allPeople.get(index);
                newPerson.setName(name);
                newPerson.setSex(sexm(args[3]));
                newPerson.setBirthDay(birthDate);

                break;
            }
            case ("-d"):
            {
               int index = Integer.parseInt(args[1]);

                newPerson = allPeople.get(index);
                newPerson.setName(null);
                newPerson.setSex(null);
                newPerson.setBirthDay(null);
                // newPerson = allPeople.remove(index);
                break;

            }
            case ("-i"):
            {
                int index = Integer.parseInt(args[1]);
                newPerson = allPeople.get(index);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String sexFormat;
                if (newPerson.getSex().equals(Sex.MALE))
                    sexFormat="м";
                else sexFormat="ж";
                        System.out.println(newPerson.getName() + " " + sexFormat + " " + sdf.format(newPerson.getBirthDay()));
                break;
            }
        }
//        for (Person person : allPeople)
//        {
//            System.out.println(person.toString());
//        }
    }

    public static Sex sexm(String str)
    {
        if (str.equals("м"))
            return Sex.MALE;
        return Sex.FEMALE;
    }

}
