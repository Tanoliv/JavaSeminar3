package Seminar2;


import java.util.Arrays;
import java.util.Random;

public class S3_Dz1 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] firstArray = new int[30];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = rand.nextInt(20);
        }
        System.out.printf("Не сортированный массив %s\n", Arrays.toString(firstArray));

        int[] result = merge_sort(firstArray);
        System.out.printf("Отсортированный массив %s\n", Arrays.toString(result));
       
    }
/** */  
    public static int[] Array(int[] Array1, int[] array2) {
        int n1 = Array1.length, n2 = array2.length;
        int n = n1 + n2, i1 = 0, i2 = 0;
        int[] resArray = new int[n];
       
        for (int i = 0; i < n; i++) {
            if (i1 == n1) {
                resArray[i] = array2[i2++];
            } else if (i2 == n2) {
                resArray[i] = Array1[i1++];
            } else {
                if (Array1[i1] < array2[i2]) {
                    resArray[i] = Array1[i1++];
                } else {
                    resArray[i] = array2[i2++];
                }
                
            }
            
        }
        return resArray;
        
    }
        
    public static int[] merge_sort(int[] array) {
        if (array.length < 2) return array;

        int[] firstArray = new int[array.length / 2];
        System.arraycopy(array, 0, firstArray, 0, array.length / 2);

        int[] secArray = new int[array.length - firstArray.length];
        System.arraycopy(array, array.length / 2, secArray, 0, array.length - firstArray.length);

        firstArray = merge_sort(firstArray);
        secArray = merge_sort(secArray);

        return Array(firstArray, secArray);
    }
}
