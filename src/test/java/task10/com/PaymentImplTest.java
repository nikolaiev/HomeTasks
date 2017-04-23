package task10.com;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 15.02.17.
 */
public class PaymentImplTest {
    @Test
    public void getUniqueGoodsAmount() throws Exception {
        payment.addGood("jam",12,3);
        payment.addGood("lacalut",15,3);
        assertEquals(2,payment.getUniqueGoodsAmount());
    }

    @Test
    public void getAllGoodsAmount() throws Exception {
        payment.addGood("jam",12,3);
        payment.addGood("lacalut",15,3);
        assertEquals(27,payment.getAllGoodsAmount());
    }

    Payment payment=new PaymentImpl();

    @Test
    public void addGood() throws Exception {
        payment.addGood("jam",12,3);
        assertEquals(12,payment.getGoodAmountByTitle("jam"),0.001);
    }

    @Test
    public void removeGood() throws Exception {
        payment.addGood("jam",12,3);
        payment.addGood("lacalut",15,3);
        payment.removeGood("lacalut");
        assertEquals(1,payment.getUniqueGoodsAmount());
    }

    @Test
    public void updateGood() throws Exception {
        payment.addGood("jam",12,3);
        payment.addGood("lacalut",15,3);
        payment.updateGood("lacalut",17,3);
        assertEquals(29,payment.getAllGoodsAmount());
    }

    @Test
    public void getSummaryPrice() throws Exception {
        payment.addGood("jam",5,3);
        payment.addGood("lacalut",6,3);
        assertEquals(33.,payment.getSummaryPrice(),0.001);
    }

    @Test
    public void getGoodsList() throws Exception {
        payment.addGood("jam",5,3);
        assertEquals("jam/5.0/3.0\n",payment.getGoodsList());
    }

    @Test
    public void getGoodAmountByTitle() throws Exception {
        payment.addGood("jam",5,3);
        payment.addGood("lacalut",6,3);
        assertEquals(5.,payment.getGoodAmountByTitle("jam"),0.001);
    }

    @Test
    public void getGoodPriceByTitle() throws Exception {
        payment.addGood("jam",5,3);
        payment.addGood("lacalut",6,3);
        assertEquals(6.,payment.getGoodAmountByTitle("lacalut"),0.001);

    }



}