package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/
public class Solution implements Serializable{
    public A getOriginalObject(ObjectInputStream objectStream) {

        try {
            Object obj = objectStream.readObject();
            if (obj instanceof B)
                return (B) obj;
            else if (obj instanceof A)
                return (A) obj;
            else
                return null;
     //   }
//        catch (NotSerializableException e) {
//            {
//                System.out.println("ClassNotFoundException was catched");
//                return null;
//            }
        } catch (Exception e) {
            System.out.println("IOException was catched");
            return null;
        }


    }

    public class A implements Serializable {

    }

    public class B extends A {

        public B() {
            System.out.println("inside B");
        }
    }


    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        Solution.A a= sol.new A();
        Solution.B b= sol.new B();


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("new.txt"));
        objectOutputStream.writeObject(new Object());
        objectOutputStream.close();
        ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream("new.txt"));
        System.out.println(sol.getOriginalObject(objectStream));
        objectOutputStream.close();
    }
}
