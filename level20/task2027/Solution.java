package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "home", "same", "emoh", "emas", "fderlk", "klredf", "fulmp", "poeejj", "jjeeop",
                "pmluf", "kovhj", "jhvok", "lprr", "rrpl", "lprr", "voel", "lock", "r", "re", "eo", "oe", null, "", " ");
        for (Word word : list) {
            System.out.println(word.toString());
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        String[] word = words;
        List<Word> list = new ArrayList<>();
        char[][] dir = new char[][]{//массив для движения по всем 8 направлениям
                {'0', '+'},
                {'+', '+'},
                {'+', '0'},
                {'+', '-'},
                {'0', '-'},
                {'-', '-'},
                {'-', '0'},
                {'-', '+'}
        };
        int hor = crossword[0].length;
        int ver = crossword.length;


        for (int d = 0; d < word.length; d++) {
            if (word[d] != null && word[d] != "" && word[d] != " ") {//проверка слова
                int len = word[d].length() - 1;
                for (int i = 0; i < ver; i++)
                    for (int j = 0; j < hor; j++)
                        if (crossword[i][j] == word[d].charAt(0)) {
                            int beginI = i;
                            int beginJ = j;
                            List<String> list8Words = new ArrayList<>();
                            list8Words.add(wordsStar(word[d], dir[0], crossword, beginI, beginJ));//слово вправо - i=0; j++;
                            list8Words.add(wordsStar(word[d], dir[1], crossword, beginI, beginJ));//слово вправо вниз - i++; j++;
                            list8Words.add(wordsStar(word[d], dir[2], crossword, beginI, beginJ));//слово вниз - i++; j=0;
                            list8Words.add(wordsStar(word[d], dir[3], crossword, beginI, beginJ));//слово влево вниз - i++; j--;
                            list8Words.add(wordsStar(word[d], dir[4], crossword, beginI, beginJ));//слово влево - i=0; j--;
                            list8Words.add(wordsStar(word[d], dir[5], crossword, beginI, beginJ));//слово влево вверх - i--; j--;
                            list8Words.add(wordsStar(word[d], dir[6], crossword, beginI, beginJ));//слово вверх - i--; j=0;
                            list8Words.add(wordsStar(word[d], dir[7], crossword, beginI, beginJ));//слово вправо вверх - i--; j++;
                            int index = 8;
                            if (list8Words.contains(word[d]))
                                index = list8Words.indexOf(word[d]);
                            if (index != 8) {
                                Word word1 = new Word(list8Words.get(index));
                                word1.setStartPoint(beginJ, beginI);
                                int[] coord = directionCoordinates(dir[index], len, beginI, beginJ);
                                word1.setEndPoint(coord[0], coord[1]);
                                list.add(word1);

                            }
                        }
            }
        }
        return list;
    }

    public static int[] directionCoordinates(char[] dir, int len, int beginI, int beginJ) {
        int[] coord = new int[2];
       //System.out.println("directions: i=" + dir[0] + ", j=" + dir[1]);
        switch (dir[1]) {
            case ('0'): {
                coord[0] = beginJ;
                break;
            }
            case ('+'): {
                coord[0] = beginJ + len;
                break;
            }
            case ('-'): {
                coord[0] = beginJ - len;
                break;
            }
        }
        switch (dir[0]) {
            case ('0'): {
                coord[1] = beginI;
                break;
            }
            case ('+'): {
                coord[1] = beginI + len;
                break;
            }
            case ('-'): {
                coord[1] = beginI - len;
                break;
            }

        }
        return coord;
    }

    public static String wordsStar(String myWord, char[] dir, int[][] crossword, int i, int j) {

        String sb = new String();
        try {

            char[] word = new char[myWord.length()];
            for (int w = 0; w < myWord.length(); w++) {
                word[w] = (char) crossword[i][j];
                if (dir[0] == '+')
                    i++;
                else if (dir[0] == '-')
                    i--;
                if (dir[1] == '+')
                    j++;
                else if (dir[1] == '-')
                    j--;

            }
            for (int w = 0; w < myWord.length(); w++)
                sb += String.valueOf(word[w]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
        return sb;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
