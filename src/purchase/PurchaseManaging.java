package purchase;

import java.util.Map;

public interface PurchaseManaging {
    void addPurchase(String title, int count);
    void sum(Map<String, Integer> map);
}
