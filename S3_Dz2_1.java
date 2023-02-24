package Seminar2;



import java.util.ArrayList;
import java.util.Random;

//Пусть дан произвольный список целых чисел. Удалить из него чётные числа.

public class S3_Dz2_1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            int Num = rnd.nextInt(10);
            list.add(Num);
        }

        System.out.printf("Исходный массив: %s\n", list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(list.get(i));
                i--;
            }
        }

        System.out.printf("Массив с удаленными четными числами: %s\n", list);
    }
}