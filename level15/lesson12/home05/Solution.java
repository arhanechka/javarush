package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution2 создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution2.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution2.
*/

public class Solution
{

    Solution(Float d)
    {
    }

    Solution(Byte b)
    {
    }

    Solution(Short s)
    {
    }

    public Solution()
    {
    }

    public Solution(String str)
    {
    }

    public Solution(int num)
    {
    }

    protected Solution(double d)
    {
    }

    protected Solution(String str, int num)
    {
    }

    protected Solution(int num, int d)
    {
    }


    private Solution(Double p)
    {
    }

    private Solution(Character p)
    {
    }

    private Solution(char c)
    {
    }

}

