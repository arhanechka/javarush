package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Запрет сериализации
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        public void writeObject(ObjectOutputStream oos) throws NotSerializableException {
            throw new NotSerializableException();
        }
        public void readObject(ObjectInputStream ois) throws NotSerializableException {
            throw new NotSerializableException();
        }

    }

    public static void main(String[] args) throws IOException {
        SubSolution ss = new SubSolution();
        FileOutputStream fos = new FileOutputStream("new.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ss.writeObject(oos);
    }
}