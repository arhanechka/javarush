package com.javarush.task.task20.task2014;



import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution1
*/
public class Solution implements Serializable{
    public static void main(String[] args) {

        File file = new File("new.txt");
        try { Solution savedObject = new Solution(15);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(savedObject);
            Solution loadedObject = new Solution(23);
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream oi=new ObjectInputStream(is) ;
            loadedObject =(Solution) oi.readObject();
            System.out.println(loadedObject.toString());
            System.out.println(savedObject.string.equals(loadedObject.string));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(new Solution(4));
    }

 transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient  private Date currentDate;
    transient  private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
