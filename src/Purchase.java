import java.util.Map;
//0Magic
//1Don't repeat
//2Single responsibility
//3open to extends -closed fields
//4extend if it can play the same role
//5many interfaces with a method
//6depend on interfaces



public class Purchase implements PurchaseManaging {
    protected String title;
    protected int count;
    protected Purchase[] purchases;               



    public Purchase(String title, int count) {         //что-то тут с count, вроде не где не назначается так зачем передавать?
        this.title = title;                            //что-то с этим конструктором совсем непонятно
        this.count = count;
        purchases = new Purchase[4];                    //используется конкретная цифра
    }

    public Purchase() {
    }
    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }


                                //как сопоставляется длинны массивов?
    public long sum(Map<String, Integer> prices) {                                   //а не лишний ли ты здесь дружок?
                                                                                    //может отнаследоваться и добавить метод?
        long sum = 0;
        System.out.println("КОРЗИНА:");
        Purchase purchase;                                                          //вынес
        for (int i = 0; i < purchases.length; i++) {
            purchase = purchases[i];                    //хм почему напрямую нельзя использовать purchases[i]?
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " +
                    (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += purchase.count * prices.get(purchase.title);
        }
        return sum;
    }
}