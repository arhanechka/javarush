package com.javarush.test.level14.lesson06.home01;

/**
 Методы должны возвращать строку вида:
 <getDescription() родительского класса>  + <" Моя страна - Sssss. Я несу N яиц в месяц.">* Created by Anya on 23.12.2016.
 */
public class BelarusianHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 10;
    }
    public String getDescription(){
        return super.getDescription()+" Моя страна - "+ Country.BELARUS+". Я несу "+this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
