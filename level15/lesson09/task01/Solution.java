package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(0.1, "One");
        labels.put(0.2, "Two");
        labels.put(0.3, "Three");
        labels.put(0.4, "Four");
        labels.put(0.5, "Five");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
