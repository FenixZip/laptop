public class Laptops {
    private String Brand;
    private String Color;
    private String Side;
    private int Ram;
    private int Hdd;

    // Конструктор
    public Laptops(String brand, String color, String side, int ram, int hdd) {
        Brand = brand;
        Color = color;
        Side = side;
        Ram = ram;
        Hdd = hdd;
    }

    // Переопределение метода

    @Override
    public String toString() {
        return Brand + "Бренд " + Color + "Цвет " + Side + "Страна "
                + Ram + "Оперативная память " + Hdd + "Жесткий диск ";
    }
}
