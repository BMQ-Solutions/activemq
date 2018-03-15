package com.boonya.activemq;

/**
 * @ClassName: ConsumerTest
 * @Description: TODO(功能描述)
 * @author: pengjunlin
 * @company: 上海势航网络科技有限公司
 * @date 2018-03-15
 */
public class ConsumerTest {

    public static void main(String[] args){
        Comsumer comsumer = new Comsumer();
        comsumer.init();
        ConsumerTest testConsumer = new ConsumerTest();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
    }

    private class ConsumerMq implements Runnable{
        Comsumer comsumer;
        public ConsumerMq(Comsumer comsumer){
            this.comsumer = comsumer;
        }

        @Override
        public void run() {
            while(true){
                try {
                    comsumer.getMessage("Jaycekon-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
