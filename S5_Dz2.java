package Seminar2;

import java.util.HashMap;
import java.util.Map;

//Пусть дан список сотрудников: Иван, Пётр, Антон и так далее.
//Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
//Отсортировать по убыванию популярности.
public class S5_Dz2 {
    public static void main(String[] args) {
        String[] name = new String[] {"Олег", "Сергей", "Олег", "Сергей", "Владимир",
                "Антон", "Иван", "Владимир", "Иван", "Петр", "Антон", "Сергей", "Генадий", "Антон"};
        for(String i : name) {
           
            System.out.printf("%s, ", i, "\n");
        }
        System.out.println("\n");
             
        HashMap<String, Integer> names = new HashMap<>();
        for (String i : name) { 
            int result = names.getOrDefault(i, 0) + 1;
            names.put(i, result);
        }
        

        names.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}