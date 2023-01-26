import java.util.Map;

public interface PurchaseManaging {
    void addPurchase(String title, int count);
    long sum(Map<String, Integer> prices);
}
