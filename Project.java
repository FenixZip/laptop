import java.util.*;


public class Project {
    public static void main(String[] args) {

        int countLaptop = 20; //количество ноутбуков
        Set<Laptops> laptops = new HashSet<>();
        createSetLaptop(laptops, countLaptop);


        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        System.out.println("Здравствуйте! ");
        while (flag) {
            System.out.println("Пожалуйста, введите число команды для выполнения действия:");
            System.out.println("1 - Показать список ноутбуков");
            System.out.println("2 - Фильтрация списка ноутбуков");
            System.out.println("3 - Закончить работу");
            String action = scan.next();
            if (isNumber(action)) {
                switch (Integer.parseInt(action)) {
                    case 1:
                        for (Laptops laptop : laptops) {
                            System.out.println(laptop);
                        }
                        System.out.println();
                        break;
                    case 2:
                        filterLaptop(laptops);
                        break;
                    case 3:
                        flag = !flag;
                        System.out.println("Спасибо за использование системы! Всего хорошего!");
                        break;
                    default:
                        System.out.println("Некорректный ввод!");
                        break;
                }
            } else {
                System.out.println("Ошибка ввода");
            }

        }


    }


    // Создаю список ноутбуков случайным образом по заведомо известным параметрам
    public static void createSetLaptop(Set laptops, int countLaptop) {

        String[] rndModel = {"MSI", "Acer", "Huawei", "Asus", "Macbook", "Lenovo"};
        int[] rndRamSize = {1, 2, 4, 8, 16, 32};
        int[] rndHddSize = {120, 240, 500, 1000, 2000};
        int[] rndPrice = {14000, 20000, 25000, 30000, 50000, 70000, 80000, 100000};
        String[] rndColor = {"Red", "White", "Blue", "Black", "Green"};

        Random rnd = new Random();

        for (int i = 0; i < countLaptop; i++) {
            String model = rndModel[rnd.nextInt(rndModel.length)];
            int ramSize = rndRamSize[rnd.nextInt(rndRamSize.length)];
            int hddSize = rndHddSize[rnd.nextInt(rndHddSize.length)];
            int price = rndPrice[rnd.nextInt(rndPrice.length)];
            String color = rndColor[rnd.nextInt(rndColor.length)];
            laptops.add(new Laptops(model, ramSize, hddSize, color, price));
        }
    }

    // Создание фильтра
    private static void filterLaptop(Set<Laptops> laptops) {
        Map<String, Integer> dataFilter = new HashMap<>();
        dataFilter.put("ram", 0);
        dataFilter.put("hdd", 0);
        dataFilter.put("price", 0);
        boolean flag = true;
        while (flag) {
            System.out.printf("Параметры фильтра. Минимальный объем ОЗУ = %s Гб, " +
                    "минмальный объем HDD = %s Гб, минимальная стоимость = %s руб.\n", dataFilter.get("ram"), dataFilter.get("hdd"), dataFilter.get("price"));
            System.out.println("Пожалуйста, введите критерий, необходимый для фильтрации:");
            System.out.println("1 - Объем ОЗУ");
            System.out.println("2 - Емкость жесткого диска");
            System.out.println("3 - Стоимость");
            System.out.println("4 - Показать результат фильтрации");
            Scanner scan = new Scanner(System.in);
            String action = scan.next();
            if (isNumber(action)) {
                switch (Integer.parseInt(action)) {
                    case 1:
                        System.out.println("Введите минимальный объем ОЗУ ноутбука в Гб");
                        String minRAM = scan.next();
                        if (isNumber(minRAM) && Integer.parseInt(minRAM) > 0) {
                            dataFilter.put("ram", Integer.parseInt(minRAM));
                        } else {
                            System.out.println("Ошибка ввода\n");
                        }
                        break;
                    case 2:
                        System.out.println("Введите минимальный объем жесткого диска (HDD) в Гб");
                        String minHDD = scan.next();
                        if (isNumber(minHDD) && Integer.parseInt(minHDD) > 0) {
                            dataFilter.put("hdd", Integer.parseInt(minHDD));
                        } else {
                            System.out.println("Ошибка ввода\n");
                        }
                        break;
                    case 3:
                        System.out.println("Введите минимальную стоимость ноутбука в рублях");
                        String minPrice = scan.next();
                        if (isNumber(minPrice) && Integer.parseInt(minPrice) > 0) {
                            dataFilter.put("price", Integer.parseInt(minPrice));
                        } else {
                            System.out.println("Ошибка ввода\n");
                        }
                        break;
                    case 4:
                        flag = !flag;
                        showFilterResult(laptops, dataFilter);
                        System.out.println();
                        break;
                    default:
                        System.out.println("Некорректный ввод!");
                        break;
                }
            } else {
                System.out.println("Ошибка ввода");
            }
        }
    }

    // Вывод на экран результат фильтра
    private static void showFilterResult(Set<Laptops> laptops, Map<String, Integer> dataFilter) {
        int count = 0;
        for (Laptops laptop : laptops) {
            if (laptop.hdd >= dataFilter.get("hdd") && laptop.ram >= dataFilter.get("ram") && laptop.price >= dataFilter.get("price")) {
                System.out.println(laptop);
                count++;
            }

        }
        if (count == 0)
        {
            System.out.println("В перечне нет ноутбуков, удовлетворяющих параметрам");
        }
    }


    // Проверка, является ли ввод с клавиатуры числом
    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}