import java.util.Map;
import java.util.Scanner;

import purchase.Manager;

import static utils.UtilClass.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> products = getMap();
        printProducts(products);

        System.out.println("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager(products.size());
        String line;
        String product;
        int count;
        while (true) {
            line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            product = parts[0];
            count = Integer.parseInt(parts[1]);
            manager.addPurchase(product, count);
        }
        manager.sum(products);
    }
}
