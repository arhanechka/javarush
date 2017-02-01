package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

import java.util.TreeSet;

public class Beach implements Comparable<Beach>
{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality)
    {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public static void main(String[] args)
    {
        TreeSet<Beach> beachSet = new TreeSet<Beach>();
        beachSet.add(new Beach("beach_one", 102, 5));
        beachSet.add(new Beach("beach_two", 98, 2));
        beachSet.add(new Beach("beach_three", 75, 1));
        beachSet.add(new Beach("beach_four", 156, 9));
        beachSet.add(new Beach("beach_five", 111, 7));


        for (Beach x : beachSet)
        {
            System.out.println(x.getName() + " " + x.getDistance() + " " + x.getQuality());
        }
    }

    public String getName()
    {
        return name;
    }

    public synchronized void setName(String name)
    {
        this.name = name;
    }

    public float getDistance()
    {
        return distance;
    }

    public synchronized void setDistance(float distance)
    {
        this.distance = distance;
    }

    public int getQuality()
    {
        return quality;
    }

    public synchronized void setQuality(int quality)
    {
        this.quality = quality;
    }


    @Override
    public synchronized int compareTo(Beach o)
    {
        int bestDistance = (int) (distance - o.getDistance());
        int bestQuality = (int) (quality - o.getQuality());
        int bestName = name.compareTo(o.getName());
        return 1000 * bestName + 100 * bestDistance + bestQuality;

    }
}