package com.boonya.activemq;

/**
 * @ClassName: ProducterTest
 * @Description: TODO(功能描述)
 * @author: pengjunlin
 * @company: 上海势航网络科技有限公司
 * @date 2018-03-15
 */
public class ProducterTest {

    public static void main(String[] args){
        Producter producter = new Producter();
        producter.init();
        ProducterTest testMq = new ProducterTest();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Thread 1
        new Thread(testMq.new ProductorMq(producter)).start();
        //Thread 2
        new Thread(testMq.new ProductorMq(producter)).start();
        //Thread 3
        new Thread(testMq.new ProductorMq(producter)).start();
        //Thread 4
        new Thread(testMq.new ProductorMq(producter)).start();
        //Thread 5
        new Thread(testMq.new ProductorMq(producter)).start();
    }

    private class ProductorMq implements Runnable{
        Producter producter;
        public ProductorMq(Producter producter){
            this.producter = producter;
        }

        @Override
        public void run() {
            while(true){
                try {
                    producter.sendMessage("Jaycekon-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
