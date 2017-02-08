package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
br.close();
        load(new FileInputStream(fileName));

        for (Map.Entry<String, String> s : properties.entrySet()) {
            System.out.println(s.getKey()+" "+s.getValue());
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter pw = new PrintWriter(outputStream);
        Properties p =  new Properties();
        for (Map.Entry<String, String> s : properties.entrySet()) {
           p.put(s.getKey(),s.getValue());
            p.store(outputStream,"");
            
        }
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
       Properties p =  new Properties();
        p.load(inputStream);
        Enumeration e = p.propertyNames();

        for (; e.hasMoreElements();) {

            String key = (String) e.nextElement();
            properties.put(key,p.getProperty(key));
        }
    }

    public static void main(String[] args) throws Exception {
Solution sol = new Solution();

        sol.fillInPropertiesMap();
    }
}
