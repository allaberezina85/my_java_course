
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

import java.util.Objects;

public class Laptop {

    //private String category; //игровой, трансформер, ультрабук
    private String brand;
    private String model;
    private int amountOfRAM;
    private int capacitySSD; 
    private String processor;
    private String operatingSystem;
    private boolean isWebcam;
    private String colour;
    private int price; 

    public Laptop (String brand, String model, int amountOfRAM, int capacitySSD, 
    String processor, String operatingSystem, String colour, boolean isWebcam, int price) {
       
        this.brand = brand;
        this.model = model;
        this.amountOfRAM = amountOfRAM;
        this.capacitySSD = capacitySSD;
        this.processor = processor;
        this.operatingSystem = operatingSystem;
        this.colour = colour;
        this.isWebcam = isWebcam;
        this.price = price;
    }

    //getters
    public String getModel(){
        return model;
    }

    public String getBrand(){
        return brand;
    }

    public String getProcessor(){
        return processor;
    }

    public String getOperatingSystem(){
        return operatingSystem;
    }

    public int getCapacitySSD(){
        return capacitySSD;
    }

    public int getAmountOfRAM(){
        return amountOfRAM;
    }
   
    public int getPrice(){
        return price;
    }

    public String getColour(){
        return colour;
    }
    
    public boolean getIsWebcam(){
        return isWebcam;
    }

    //setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAmountOfRAM(int amountOfRAM) {
        this.amountOfRAM = amountOfRAM;
    }

    public void setCapacitySSD(int capacitySSD) {
        this.capacitySSD = capacitySSD;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setIsWebcam(boolean isWebcam) {
        this.isWebcam = isWebcam;
    }

    
    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String isWebcamStr="";
        if (isWebcam) isWebcamStr="Да";
        else isWebcamStr="Нет";


        String result = "Бренд>: " + brand + System.lineSeparator()
         + "Модель: " + model + System.lineSeparator()
         + "Процессор: " + processor + System.lineSeparator()
         + "Операционная система: " + operatingSystem + System.lineSeparator()
         + "Цвет: " + colour + System.lineSeparator()
         + "Объем оперативной памяти (Гб): " + amountOfRAM + System.lineSeparator()
         + "Объем SSD (Гб): " + capacitySSD + System.lineSeparator()
         + "Наличие веб-камеры: " + isWebcamStr + System.lineSeparator()
         + "Цена (руб): " + price;
 
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        if(obj == null || getClass() != obj.getClass()) return false;

        Laptop laptop = (Laptop) obj;

        return brand.equals(laptop.brand) && model.equals(laptop.model) 
        && processor.equals(laptop.processor) && operatingSystem.equals(laptop.operatingSystem) 
        && price == laptop.price && amountOfRAM == laptop.amountOfRAM && capacitySSD == laptop.capacitySSD 
        && colour.equals(laptop.colour) && isWebcam == laptop.isWebcam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, processor, 
        operatingSystem, amountOfRAM, capacitySSD, colour, isWebcam, price);
    }

   

   
      
}
