package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ProductThread {

    // 变量
    private String content;
    private volatile int state = 0;


    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    private Lock lock1 = new ReentrantLock();
    private ReentrantReadWriteLock lock2 = new ReentrantReadWriteLock();

    class Run implements Runnable{

        @Override
        public void run() {
            System.out.println("1");
        }
    }

    public void productThread1() {

        ProductThread myDemo01 = new ProductThread();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                state++;
                System.out.println(state);
            }, String.valueOf(i)).start();
        }
    }

    public void productThread() {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.execute(() -> productThread1());

        ProductThread myDemo01 = new ProductThread();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try{
                    lock1.lock();
                    myDemo01.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println("-----------------------------------------");
                    System.out.println(Thread.currentThread().getName() + "\t  " + myDemo01.getContent());
                } finally {
                    lock1.unlock();
                }
            }, String.valueOf(i)).start();
        }
    }

    public static void main(String[] args) {
        new ProductThread().productThread1();
    }
}
