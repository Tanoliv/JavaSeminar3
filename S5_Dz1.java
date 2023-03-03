package Seminar2;
//Реализуйте структуру телефонной книги с помощью HashMap,
//        учитывая, что один человек может иметь несколько телефонов.


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class S5_Dz1 {
   
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        HashMap<ArrayList<String>, HashMap<String, String>> phoneBook = new HashMap<>();
        ArrayList<String> numberPhone = new ArrayList<>();
        HashMap<String, String> keyValues = new HashMap<>();

        phoneBook.put(numPhone(numberPhone), descript(keyValues));
        System.out.println(phoneBook);        
       
    } 
    
    private static ArrayList<String> numPhone(ArrayList<String> number) throws IOException {
        //numberPhone - список  который потом будет заноситься в ключ словаря phoneBook
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер телефона:");
        String inPhone = scan.nextLine();
        number.add(inPhone);
        try (FileWriter fw= new FileWriter("phoneBook.txt", true)) {
            try {
                fw.write(inPhone);
                fw.append(" ");
                fw.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());               
            }
        }    
        return number;
    }

    private static HashMap<String, String> descript(HashMap<String, String> keyValue) throws IOException {
        // В общем это словарь значений, который потом заносится в словарь phoneBook
        Scanner scan = new Scanner(System.in, "Cp866");
        System.out.println("Введите имя:");
        String firstName = scan.nextLine();
        System.out.println("Введите фамилию:");
        String lastName = scan.nextLine();
        System.out.println("Введите описание:");
        String descript = scan.nextLine();

        try (FileWriter fw= new FileWriter("phoneBook.txt", true)) {
            try {
                fw.write(firstName);
                fw.append(" ");
                fw.append(lastName);
                fw.append(" ");
                fw.append(descript);
                fw.append("\n");
                fw.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());               
            }
        }
      
        keyValue.put("Имя", firstName);
        keyValue.put("Фамилия", lastName);
        keyValue.put("Описание номера", descript);

       

        return keyValue;
    }
}
