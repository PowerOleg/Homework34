import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> products = getMap();    //в идеале тут иметь список purchases, но по заданию нельзя трогать
        printProducts(products);

        System.out.println("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);
        Purchase purchase = new Purchase(products.size());
        String line;                                //вынес из цикла объявление чтобы не создавать переменную каждый цикл
        String product;
        int count;
        while (true) {
            line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            product = parts[0];                                                     
            count = Integer.parseInt(parts[1]);
            purchase.addPurchase(product, count);       
        }
        printSum(products, purchase.purchases);
    }

    private static HashMap<String, Integer> getMap() {                                          //1
        HashMap<String, Integer> products = new HashMap<>();
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);
        return products;
    }

    private static void printProducts(HashMap<String, Integer> products) {                  //2
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
    }
//    private static void printSum(HashMap<String, Integer> products, Purchase purchase) {            //3
//        long sum = /*purchase.*/sum(products, purchase.purchases);                                    //4
//        System.out.println("ИТОГО: " + sum);
//    }

    //метод принимает мапу, и почему бы ему не принять и массив purchases и он вообще не тут должен находиться, вынести как статичный
    public static void printSum(Map<String, Integer> prices, Purchase[] purchases) {            //вынес метод из объекта purchase потому что он не зависит от class Purchase, также становится не нужным метод printSum потому что там добавляется одна строчка
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) continue;                                      //вынес,удалил Purchase purchase = purchase[i]
            System.out.println("\t" + purchases[i].title + " " + purchases[i].count + " шт. в сумме " +
                    (purchases[i].count * prices.get(purchases[i].title)) + " руб.");
            sum += purchases[i].count * prices.get(purchases[i].title);//сделал напрямую purchases[i]
        }
//        return sum;

        System.out.println("ИТОГО: " + sum);
    }
}
