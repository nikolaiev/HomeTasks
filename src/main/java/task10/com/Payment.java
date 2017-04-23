package task10.com;

/**
 * Created by vlad on 15.02.17.
 */
public interface Payment {
    void addGood(String title,double amount,double price);
    boolean removeGood(String title);
    boolean updateGood(String title, double amount, double price);

    double getGoodAmountByTitle(String title);
    double getGoodPriceByTitle(String title);

    int getUniqueGoodsAmount();
    int getAllGoodsAmount();

    double getSummaryPrice();
    String getGoodsList();
}
