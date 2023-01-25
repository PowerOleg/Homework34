import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();        //может генерацию мапы с продуктами сделать в методе?
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);

        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");                                         //метод print()
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }

        System.out.println("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);
        Purchase purchase = new Purchase();
        String line;                                        //вынес из цикла чтобы не создавать каждый цикл переменную
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
        long sum = purchase.sum(products);
        System.out.println("ИТОГО: " + sum);
    }
}
