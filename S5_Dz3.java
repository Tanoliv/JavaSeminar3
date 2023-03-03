package Seminar2;

//Реализовать алгоритм пирамидальной сортировки (HeapSort).

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class S5_Dz3 {
    
    public static void main(String[] args) {
        int[] array= new int[14];
        Random rnd= new Random();
        
        for (int i= 0; i< array.length; i++) {
            array[i]= rnd.nextInt(-100, 100);
            
        }
        System.out.printf("Исходный массив: %s\n", Arrays.toString(array));
     
        resultArray(array); 
       
        System.out.printf("Отсортированный массив: %s", Arrays.toString(array));
    }
    private static int LEFT(int i) {
        return (2 * i + 1);
    }

    // вернуть правого потомка `A[i]`
    private static int RIGHT(int i) {
        return (2 * i + 2);
    }

    // Вспомогательная функция для замены двух индексов в массиве
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Рекурсивный алгоритм heapify-down. Узел с индексом `i` и
    // два его прямых потомка нарушают свойство кучи
    private static void heapify(int[] A, int i, int size) {
        // получить левый и правый потомки узла с индексом `i`
        int left = LEFT(i);
        int right = RIGHT(i);
        int largest = i;

        // сравниваем `A[i]` с его левым и правым дочерними элементами
        // и находим наибольшее значение
        if (left < size && A[left] > A[i]) {
            largest = left;
        }
        if (right < size && A[right] > A[largest]) {
            largest = right;
        }
        // поменяться местами с потомком, имеющим большее значение и
        // вызовите heapify-down для дочернего элемента
        if (largest != i) {
            swap(A, i, largest);
            heapify(A, largest, size);
        }
    }

    // Функция для удаления элемента с наивысшим приоритетом (присутствует в корне)
    private static int pop(int[] A, int size) {
        // если в куче нет элементов
        if (size <= 0) {
            return -1;
        }

        int top = A[0];

        // заменяем корень кучи последним элементом массива
        A[0] = A[size - 1];

        // вызовите heapify-down на корневом узле
        heapify(A, 0, size - 1);

        return top;
    }

    // Функция для выполнения пирамидальной сортировки массива `A` размера `n`
    private static void resultArray(int[] A) {
        // строим приоритетную очередь и инициализируем ее заданным массивом
        int n = A.length;

        // Build-heap: вызывать heapify, начиная с последнего внутреннего
        // узел до корневого узла
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(A, i--, n);
        }
        // несколько раз извлекаем из кучи, пока она не станет пустой
        while (n > 0) {
            A[n - 1] = pop(A, n);
            n--;
        }
    }

   
}