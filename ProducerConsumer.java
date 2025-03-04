import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    // ... 已有变量定义不变 ...

    /**
     * 主程序入口
     * 创建生产者和消费者线程，并控制程序运行时间
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        
        // 创建2个生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 20; j++) {
                        pc.produce(j);
                        System.out.println("Produced: " + j);
                        Thread.sleep((int)(Math.random()*100));
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    
        // 创建3个消费者线程
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        int val = pc.consume();
                        System.out.println("Consumed: " + val);
                        Thread.sleep((int)(Math.random()*150));
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    
        // 运行10秒后终止
        try {
            Thread.sleep(10_000);
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}