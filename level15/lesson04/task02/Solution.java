package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
        printMatrix(0.2, 3, "8");
        printMatrix("8");
        printMatrix(0.2);
        printMatrix((Object)"8");
        printMatrix("8",4);
        printMatrix("8",4);
        printMatrix('g');
        String[]a=new String[2];
        printMatrix(a);



    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(double m, int n, String value) {
        System.out.println("Заполняем объектами String");

    }
    public static void printMatrix(String value) {
        System.out.println("Заполняем объектами String");

    }
    public static void printMatrix(double f) {
        System.out.println("Заполняем объектами String");

    }
    public static void printMatrix(Object value) {
        System.out.println("Заполняем объектами String");

    }
    public static void printMatrix(String value, int x) {
        System.out.println("Заполняем объектами String");

    }
    public static void printMatrix(String value, char t) {
        System.out.println("Заполняем объектами String");

    }
    public static void printMatrix(Character value) {
        System.out.println("Заполняем объектами String");

    }
    public static void printMatrix(String[] value) {
        System.out.println("Заполняем объектами String");

    }


}
