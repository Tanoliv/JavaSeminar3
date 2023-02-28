package Seminar2;


// Реализуйте очередь с помощью LinkedList со следующими методами:
//enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.


import java.util.LinkedList;
import java.util.Random;

public class S4_Dz2 {
    public static void main(String[] args) {
        LinkedList<Integer> firstlList = new LinkedList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            firstlList.add(i, rand.nextInt(100));
        }
        System.out.printf("Исходный список: %s \n", firstlList);
        System.out.printf("Список с добавлением элемента в конец %s \n", enqueue(firstlList, 10));

        System.out.printf("Первый элемент списка %s \n", dequeue(firstlList));
        System.out.printf("Исходный список после удаления первого элемента : %s \n", firstlList);

        System.out.printf("Первый элемент списка %s \n", first(firstlList));
        System.out.printf("Исходный список без удаления первого элемента: %s \n", firstlList);
    }

    //        enqueue() - помещает элемент в конец очереди,
    private static LinkedList<Integer> enqueue(LinkedList<Integer> list, int num) {
        list.addLast(num);
        return list;
    }

    //        dequeue() - возвращает первый элемент из очереди и удаляет его,
    private static int dequeue(LinkedList<Integer> list) {
        int num = list.getFirst();
        // System.out.printf("Первый элемент в списке: %s \n", list.getFirst());
        list.removeFirst();
        return num;
    }

    //        first() - возвращает первый элемент из очереди, не удаляя
    private static int first(LinkedList<Integer> list) {
        return list.getFirst();
    }

}
