package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Anya on 23.12.2016.
 */
public class MoldovanHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 7;
    }
    public String getDescription(){
        return super.getDescription()+" Моя страна - "+ Country.MOLDOVA+". Я несу "+this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
