package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNum {

    private int number = 1;
    private final int MAX_NUMBER = 100;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void printNumber(int targetNumber) {
        lock.lock();
        try {
            while (number <= MAX_NUMBER) {
                if (number % 3 != targetNumber) {
                    condition.await();
                } else {
                    System.out.println("Thread " + targetNumber + ": " + number);
                    number++;
                    condition.signalAll();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintNum printNumbers = new PrintNum();

        Thread threadTest1 = new Thread(() -> {
            printNumbers.printNumber(0);
        });

        Thread threadTest2 = new Thread(() -> {
            printNumbers.printNumber(1);
        });

        Thread threadTest3 = new Thread(() -> {
            printNumbers.printNumber(2);
        });

        threadTest1.start();
        threadTest2.start();
        threadTest3.start();
    }

}
