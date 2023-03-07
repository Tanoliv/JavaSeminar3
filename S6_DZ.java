//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.

//Создать множество ноутбуков.

//Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
// отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
//“Введите цифру, соответствующую необходимому критерию:
//1 - ОЗУ
//2 - Объем ЖД
//3 - Операционная система
//4 - Цвет …
//Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
//Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
package Seminar2;

import java.util.*;

import S6_DZ.NoteBook;

public class S6_DZ {
    public static void main(String[] args) {
        HashSet<NoteBook> shop = new HashSet<>();
        addNoteBook(shop);
        HashMap<String, String> filters = new HashMap<>();
        startMenu(filters);
        System.out.println(runFilter(shop, filters));
    }

    public static HashSet<NoteBook> addNoteBook(HashSet<NoteBook> product) {
        NoteBook LenovoNS = new NoteBook(null, null, null, null, null, null, null);
        NoteBook Mac = new NoteBook("Apple", "MacBook Pro", "14", "16Gb", "1TB", "Unix", "grey");
        NoteBook Huawei = new NoteBook("Huawei", "MateBook", "15", "16Gb", "2TB", "Windows10", "grey");
        NoteBook Asus = new NoteBook("ASUS", "ZenBook Flip", "13", "8Gb", "512GB", "Windows10", "blue");

        product.add(LenovoNS);
        product.add(Mac);
        product.add(Huawei);
        product.add(Asus);

        return product;
    }

    public static HashMap<String, String> startMenu(HashMap<String, String> filters) {
        Scanner isScanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Меню ");
            System.out.println("1. Выберите производителя");
            System.out.println("2. Выберите объем жесткого диска");
            System.out.println("3. Выберите объем оперативной памяти");
            System.out.println("4. Выберите операционную систему");
            System.out.println("5. Выберите цвет ноутбука");
            System.out.println("Для выхода нажмите 0");
            System.out.println("Введите цифру, соответствующую необходимому критерию");
            choice = isScanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введите название производителя, либо нажмите Enter для перехода к следующему пункту");
                    String brand = new Scanner(System.in).nextLine();
                    filters.put("brand", brand);
                    break;
                case 2:
                    System.out.println("Введите объем жесткого диска, либо нажмите Enter для перехода к следующему пункту");
                    String hardDisk = new Scanner(System.in).nextLine();
                    filters.put("hardDisk", hardDisk);
                    break;
                case 3:
                    System.out.println("Введитеобъем оперативной памяти, либо нажмите Enter для перехода к следующему пункту");
                    String operativeMemory = new Scanner(System.in).nextLine();
                    filters.put("operativeMemory", operativeMemory);
                    break;
                case 4:
                    System.out.println("Введите операционную систему, либо нажмите Enter для перехода к следующему пункту");
                    String system = new Scanner(System.in).nextLine();
                    filters.put("system", system);
                    break;
                case 5:
                    System.out.println("Введитецвет ноутбука, либо нажмите Enter");
                    String color = new Scanner(System.in).nextLine();
                    filters.put("color", color);
                    break;
                default:
                    break;
            }
        } while (choice > 0);
        return filters;
    }

    public static List<NoteBook> runFilter(HashSet<NoteBook> product, HashMap<String, String> filters) {
        List<NoteBook> productSelection = new ArrayList<>();

        for (NoteBook notebook : product) {
            String filterBrand = filters.get("brand");
            if (filterBrand != null
                    && !filterBrand.equals(notebook.getBrand())) {
                continue;
            }

            String filterModel = filters.get("model");
            if (filterModel != null
                    && !filterModel.equals(notebook.getModel())) {
                continue;
            }

            String filterSize = filters.get("size");
            if (filterSize != null
                    && !filterSize.equals(notebook.getSize())) {
                continue;
            }

            String filterOperativeMemory = filters.get("operativeMemory");
            if (filterOperativeMemory != null
                    && !filterOperativeMemory.equals(notebook.getOperativeMemory())) {
                continue;
            }

            String filterHardDisk = filters.get("hardDisk");
            if (filterHardDisk != null
                    && !filterHardDisk.equals(notebook.getHardDisk())) {
                continue;
            }

            String filterSystem = filters.get("system");
            if (filterSystem != null
                    && !filterSystem.equals(notebook.getMySystem())) {
                continue;
            }

            String filterColor = filters.get("color");
            if (filterColor != null
                    && !filterColor.equals(notebook.getColor())) {
                continue;
            }
            productSelection.add(notebook);
        }

        return productSelection;
    }
}
