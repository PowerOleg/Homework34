import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> products = getMap();
        printProducts(products);

        System.out.println("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);
        Purchase purchase = new Purchase();
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
        printSum(products, purchase);
    }

    private static HashMap<String, Integer> getMap() {
        HashMap<String, Integer> products = new HashMap<>();
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);
        return products;
    }

    private static void printProducts(HashMap<String, Integer> products) {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
    }
    private static void printSum(HashMap<String, Integer> products, Purchase purchase) {
        long sum = purchase.sum(products);
        System.out.println("ИТОГО: " + sum);
    }
}
