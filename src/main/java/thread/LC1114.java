package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LC1114 {

    public LC1114() {

    }

    private volatile int state = 0;
    private final Object l = new Object();
    private Lock lock = new ReentrantLock();

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        // mark the first job as done, by increasing its count.
        while (state != 0) {
            l.wait();
        }
        printFirst.run();
        state = 1;
        l.notifyAll();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (state != 1) {
            l.wait();
        }
        printSecond.run();
        state = 2;
        l.notifyAll();
    }

    public void third(Runnable printThird) throws InterruptedException {

        while (state != 2) {
            l.wait();
        }
        printThird.run();
        state = 2;
        l.notifyAll();

    }


}
