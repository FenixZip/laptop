public class Laptops {
    String laptopModel;
    int ram;
    int hdd;
    String color;
    int price;

    public Laptops(String laptopModel, int ram, int hdd,  String color, int price) {
        this.laptopModel = laptopModel;
        this.ram = ram;
        this.hdd = hdd;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Модель ноутбука='" + laptopModel + '\'' +
                ", ОЗУ=" + ram +
                ", HDD=" + hdd +
                ", Цвет='" + color + '\'' +
                ", Цена=" + price;
    }


}