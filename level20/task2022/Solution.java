package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
private String fileName;
    public Solution(String fileName) throws FileNotFoundException {
        this.fileName=fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.stream= new FileOutputStream(fileName,true);
        in.defaultReadObject();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution sol = new Solution("new.txt");
        sol.writeObject("mama myla ramu");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("new.txt"));
        sol.writeObject(oos);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("new.txt"));
        Solution sol1 = new Solution("new.txt");
        sol1.readObject(ois);
        sol1.writeObject("hahaha");

    }
}
