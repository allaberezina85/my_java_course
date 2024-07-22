/*
ДЗ
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить
параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
условиям.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AppLaptopMain {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("Honor", "MagicBook X16 2024 DOS", 8, 512,
                "Intel Core i5", "DOS", "серый", true, 48999);
        Laptop laptop2 = new Laptop("Lenovo", "Yoga 9 15IMH5", 16, 512,
                "Intel Core i7", "Windows", "серый", true, 186800);
        Laptop laptop3 = new Laptop("Huawei", "MateBook B5-430", 16, 512,
                "Intel Core i7", "Windows", "серый", true, 106879);
        Laptop laptop4 = new Laptop("Acer", "Swift 3 SF314-512-55N3", 8, 512,
                "Intel Core i5", "Eshell", "серый", true, 72439);
        Laptop laptop5 = new Laptop("ASUS", "Vivobook Pro 15 K3500PH-L1289", 16, 512,
                "Intel Core i5", "Без ОС", "синий", true, 105774);
        Laptop laptop6 = new Laptop("Xiaomi", "RedmiBook Pro 14", 16, 512,
                "AMD Ryzen 5", "Windows", "серый", true, 82900);
        Laptop laptop7 = new Laptop("ARK", "Jumper EZbook S5", 6, 128,
                "Intel Celeron", "Windows", "серый", false, 48900);
        Laptop laptop8 = new Laptop("Apple", "MacBook Pro 16,2 2021 M1", 16, 1024,
                "M1 Pro", "Mac OS", "серебристый", true, 500000);
        Laptop laptop9 = new Laptop("Asus", "ROG Strix Scar 18 G834JYR-R6080W", 32, 2048,
                "Intel Core i9", "Windows", "черный", true, 498999);

        Set<Laptop> laptops = new HashSet<>(Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5,
                laptop6, laptop7, laptop8, laptop9));

        // for (Laptop laptop : laptops) {
        // System.out.println(laptop);
        // System.out.println();
        // }

        Scanner scann = new Scanner(System.in);
        // List<String> list = new LinkedList<>();

        while (true) {

            System.out.println("=================================================");
            System.out.println("Программа поиска ноутбуков по заданным критериям.");
            System.out.println("=================================================");
            System.out.println("Введите цифру, соответствующую необходимому критерию поиска:\r\n" + //
                    "0 - Показать всё\r\n" + //
                    "1 - Объем оперативной памяти (Гб)\r\n" + //
                    "2 - Объем SSD (Гб)\r\n" + //
                    "3 - Операционная система\r\n" + //
                    "4 - Бренд\r\n" + //
                    "5 - Цвет");

            System.out.println("Введите \"q\" для завершения работы ");

            String input = scann.nextLine();

            if (input.equals("q")) {
                System.out.println("До встречи!");
                break;
            }
            if (input.equals("0")) {
                if (laptops.isEmpty()) {
                    System.err.println("В базе данных нет сохраненных ноутбуков");
                } else {
                    for (Laptop laptop : laptops) {
                        System.out.println(laptop);
                        System.out.println();
                    }
                }
            } else if (input.equals("1")) {

                System.out.println("Введите значение объема оперативной памяти в Гб:\r\n" + //
                        "6 \r\n" + //
                        "8 \r\n" + //
                        "16 \r\n" + //
                        "32 ");

                System.out.println("Для завершение работы введите \"q\".");

                input = scann.nextLine();

                if (input.equals("q")) {
                    System.out.println("До встречи!");
                    break;
                }
                else if (isInt(input) && isArrayRAM(input)) {
                    System.out.println("input=="+input);
                  int paramFind = Integer.parseInt(input);
                    if (laptops.isEmpty()) {
                        System.err.println("В базе данных нет сохраненных ноутбуков");
                    } else {
                        for (Laptop laptop : laptops) {
                            if ( laptop.getAmountOfRAM()>=paramFind)
                            System.out.println(laptop);
                            System.out.println();
                        }
                    }
                } else {
                System.err.println("Введена неверная команда");
            }



            } else if (input.equals("2")) {

                System.out.println("Введите значение объема в Гб:\r\n" + //
                "128 \r\n" + //
                "256 \r\n" + //
                "512 \r\n" + //
                "1024 ");

        System.out.println("Для завершение работы введите \"q\".");

        input = scann.nextLine();

        if (input.equals("q")) {
            System.out.println("До встречи!");
            break;
        }
        else if (isInt(input) && isArraySSD(input)) {
            System.out.println("input=="+input);
          int paramFind = Integer.parseInt(input);
            if (laptops.isEmpty()) {
                System.err.println("В базе данных нет сохраненных ноутбуков");
            } else {
                for (Laptop laptop : laptops) {
                    if ( laptop.getCapacitySSD()>=paramFind)
                    System.out.println(laptop);
                    System.out.println();
                }
            }
        } else {
        System.err.println("Введена неверная команда");
    }


            } else if (input.equals("3")) {

                ArrayList<String> listOS = new ArrayList<>();

                for (Laptop laptop : laptops) {
                    if (!listOS.contains(laptop.getOperatingSystem()) )
                    {
                        listOS.add(laptop.getOperatingSystem()) ;
                    }
                    
                }
                String mess= "";
                for (int i = 0; i < listOS.size(); i++) {
                    mess+= i+1+ " - "+listOS.get(i)+ "\r\n";
                }

                System.out.println("Введите цифру, соответствующую искомой ОС:\r\n" + mess);
                System.out.println("Для завершение работы введите \"q\".");

                input = scann.nextLine();
                int numFimd=Integer.parseInt(input);
                if (input.equals("q")) {
                    System.out.println("До встречи!");
                    break;
                }
                else if ( numFimd<=listOS.size()) {
                                   
                    if (laptops.isEmpty()) {
                        System.err.println("В базе данных нет сохраненных ноутбуков");
                    } else {
                        for (Laptop laptop : laptops) {
                            if ( laptop.getOperatingSystem().equals(listOS.get(numFimd-1)))
                                                        System.out.println(laptop);
                            System.out.println();
                        }
                    }
                } 
                else {
                System.err.println("Введена неверная команда");
            }
  

            } else if (input.equals("4")) {

                ArrayList<String> listBrend = new ArrayList<>();

                for (Laptop laptop : laptops) {
                    if (!listBrend.contains(laptop.getBrand()) )
                    {
                        listBrend.add(laptop.getBrand()) ;
                    }
                    
                }
                String mess= "";
                for (int i = 0; i < listBrend.size(); i++) {
                    mess+= i+1+ " - "+listBrend.get(i)+ "\r\n";
                }

                System.out.println("Введите цифру, соответствующую искомому бренду:\r\n" + mess);
                System.out.println("Для завершение работы введите \"q\".");

                input = scann.nextLine();
                int numFind=Integer.parseInt(input);
                if (input.equals("q")) {
                    System.out.println("До встречи!");
                    break;
                }
                else if ( numFind<=listBrend.size()) {
                                   
                    if (laptops.isEmpty()) {
                        System.err.println("В базе данных нет сохраненных ноутбуков");
                    } else {
                        for (Laptop laptop : laptops) {
                            if ( laptop.getBrand().equals(listBrend.get(numFind-1)))
                                                        System.out.println(laptop);
                            System.out.println();
                        }
                    }
                } 
                else {
                System.err.println("Введена неверная команда");
            }

       

            } else if (input.equals("5")) {

                ArrayList<String> listColour = new ArrayList<>();

                for (Laptop laptop : laptops) {
                    if (!listColour.contains(laptop.getColour()) )
                    {
                        listColour.add(laptop.getColour()) ;
                    }
                    
                }
                String mess= "";
                for (int i = 0; i < listColour.size(); i++) {
                    mess+= i+1+ " - "+listColour.get(i)+ "\r\n";
                }

                System.out.println("Введите цифру, соответствующую искомому цвету ноутбука:\r\n" + mess);
                System.out.println("Для завершение работы введите \"q\".");

                input = scann.nextLine();
                int numFind=Integer.parseInt(input);
                if (input.equals("q")) {
                    System.out.println("До встречи!");
                    break;
                }
                else if ( numFind<=listColour.size()) {
                                   
                    if (laptops.isEmpty()) {
                        System.err.println("В базе данных нет сохраненных ноутбуков");
                    } else {
                        for (Laptop laptop : laptops) {
                            if ( laptop.getColour().equals(listColour.get(numFind-1)))
                                                        System.out.println(laptop);
                            System.out.println();
                        }
                    }
                } 
                else {
                System.err.println("Введена неверная команда");
            }

            } else {
                System.err.println("Введена неверная команда");
            }

        }
        scann.close();

    }

    private static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean isArraySSD(String str) {
        ArrayList<Integer> ramList = new ArrayList<>();
        ramList.add(128);
        ramList.add(256);
        ramList.add(512);
        ramList.add(1024);
        int num = Integer.parseInt(str);
        if (ramList.contains(num))
            return true;
        else
            return false;
    }

    private static boolean isArrayRAM(String str) {
        ArrayList<Integer> ramList = new ArrayList<>();
        ramList.add(6);
        ramList.add(8);
        ramList.add(16);
        ramList.add(32);
        int num = Integer.parseInt(str);
        if (ramList.contains(num))
            return true;
        else
            return false;
    }

}
