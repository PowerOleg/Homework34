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
    protected Purchase[] purchases;                                 //сделал инициализацию в конструкторе
    //использовалась конкретная цифра


    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public Purchase(int length) {
        purchases = new Purchase[length];                                                       //1 добавил строчку и аргумент
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
}