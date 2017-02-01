package com.javarush.test.level13.lesson11.bonus02;
//В классе Person реализовать метод pull(Person person), который выводит фразу типа '<name> за <person>'. Пример:

public class Person implements RepkaItem
{
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh)
    {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    @Override
    public String getNamePadezh()
    {
        return null;
    }
public void pull(Person person){
    System.out.println(name +" за " +person.namePadezh);
}

}
