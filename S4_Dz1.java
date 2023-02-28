package Seminar2;

import java.util.LinkedList;
import java.util.Random;
//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет
//        “перевернутый” список.

public class S4_Dz1 {
    public static void main(String[] args) {
        LinkedList<Integer> firstlList = new LinkedList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            firstlList.add(i, rand.nextInt(100));
        }
        System.out.printf("Исходный список: %s\n", firstlList);

        System.out.printf("Перевернутый список: %s\n", resultList(firstlList));

    }

    private static LinkedList<Integer> resultList(LinkedList<Integer> list) {
        LinkedList<Integer> secondList = new LinkedList<Integer>();
        for (int i = list.size() - 1; i >= 0; i--) {
            secondList.add(list.get(i));
        }
        return secondList;
    }
}
