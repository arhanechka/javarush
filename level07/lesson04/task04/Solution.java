package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] array = new int[10];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<10; i++)
            array[i]=Integer.parseInt(br.readLine());
        int[] b=new int[10];
        for (int i=array.length-1; i>=0; i--)

           b[(array.length-1)-i]=array[i];
        for (int i=0; i<10; i++)
            System.out.println(b[i]);
    }
//    public int[] swap(int[] array, int i, int j){
//        int temp;
//
//        temp=array[i];
//        array[i]=array[j];
//        array[j]=temp;
//    }
}
