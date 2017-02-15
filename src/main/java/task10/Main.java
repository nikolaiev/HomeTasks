package task10;

import task10.com.Payment;
import task10.com.PaymentImpl;

/**
 * Created by vlad on 14.02.17.
 */
public class Main {
    public static void main(String[] args) {
        Payment payment=new PaymentImpl();
        payment.addGood("LACALUT",10,20);
        payment.addGood("ICE cream",5,52.30);
        System.out.println(payment.getGoodsList());
        System.out.println(payment.getSummaryPrice());
    }
}
