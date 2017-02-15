package task10.com;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by vlad on 15.02.17.
 */
public class PaymentImpl implements Payment {

    Map<String,Good> goods;

    public PaymentImpl(){
        goods=new TreeMap<String, Good>();
    }

    public void addGood(String title, double amount, double price) {
        goods.put(title,new Good(amount,price));
    }

    public boolean removeGood(String title) {
        return goods.remove(title)!=null;
    }

    public boolean updateGood(String title, double amount, double price) {
        Good good=goods.get(title);
        if(good!=null) {
            good.setAmount(amount);
            good.setPrice(price);
            return true;
        }
        return false;
    }

    public double getGoodAmountByTitle(String title) {
        Good good=goods.get(title);
        if(good!=null) {
            return good.getAmount();
        }
        return 0.;
    }

    public double getGoodPriceByTitle(String title) {
        Good good=goods.get(title);
        if(good!=null) {
            return good.getPrice();
        }
        return 0.;
    }

    public int getUniqueGoodsAmount() {
        return goods.size();
    }

    public int getAllGoodsAmount() {
        int result=0;
        for(Map.Entry<String,Good> entry:goods.entrySet()){
            result +=entry.getValue().getAmount();
        }
        return result;
    }

    public double getSummaryPrice() {
        double result=0.;
        for(Map.Entry<String,Good> entry:goods.entrySet()){
            result+=entry.getValue().getPrice()*entry.getValue().getAmount();
        }
        return result;
    }

    public String getGoodsList() {
        StringBuilder result=new StringBuilder();
        for(Map.Entry<String,Good> entry:goods.entrySet()){
            Good good=entry.getValue();
            result.append(entry.getKey()).append('/')
                    .append(good.amount).append('/')
                    .append(good.price)
                    .append('\n');
        }
        return result.toString();
    }

    /**
     * Inner helper class
     */
    class Good{
        double amount;
        double price;

        public Good(double amount, double price) {
            this.amount = amount;
            this.price = price;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
