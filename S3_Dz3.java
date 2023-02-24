package Seminar2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка.

public class S3_Dz3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rnd = new Random();

        int quanElem = 10;
        for (int i = 0; i < quanElem; i++) {
            int rndNum = rnd.nextInt(100);
            list.add(rndNum);
        }
        System.out.println(list);

        int min_num = Collections.min(list);
        System.out.printf("Минимальное число: %d \n", min_num);

        int max_num = Collections.max(list);
        System.out.printf("Максимальное число: %d \n", max_num);

        int sum_list = list.stream().mapToInt(Integer::intValue).sum();
        int average = sum_list / quanElem;
        System.out.printf("Среднее арифметическое: %d \n", average);
    }
}
