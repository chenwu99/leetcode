package thread;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock implements Runnable{

    public static ReentrantLock rlock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {

        try {
            rlock.lock();
            for (int j = 0; j < 1000000; j++) {
                i++;
            }
        } finally {
            rlock.unlock();
        }

    }

    public static void main(String args[]) throws InterruptedException {
        TestReentrantLock tl = new TestReentrantLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
//        //表示当前线程等待t1执行完
        t1.join();
        t2.join();
        System.out.println(i);
    }



}
