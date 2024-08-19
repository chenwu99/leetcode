package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class OptimisticLockExample {
 
    // 使用AtomicInteger实现乐观锁
    private AtomicInteger value = new AtomicInteger(0);
 
    // 使用AtomicStampedReference实现带有时间戳的乐观锁
    private AtomicStampedReference<Integer> valueWithStamp = new AtomicStampedReference<>(0, 0);
 
    // 获取值的方法
    public int getValue() {
        return value.get();
    }
 
    // 设置值的方法
    public void setValue(int newValue) {
        while (true) {
            int currentValue = value.get();
            if (value.compareAndSet(currentValue, newValue)) {
                // CAS成功，退出循环
                break;
            }
            // CAS失败，继续尝试
        }
    }
 
    // 带有时间戳的乐观锁设置值的方法
    public void setValueWithStamp(int newValue) {
        int[] stamp = new int[1];
        int[] value = new int[1];


        while (true) {
            // 获取当前值和时间戳
            value[0] = this.valueWithStamp.get(stamp);
            int currentStamp = stamp[0];
 
            // 尝试更新值
            if (this.valueWithStamp.compareAndSet(value[0], newValue, currentStamp, currentStamp + 1)) {
                // CAS成功，退出循环
                break;
            }
            // CAS失败，继续尝试
        }
    }
 
    public static void main(String[] args) {
        OptimisticLockExample example = new OptimisticLockExample();
        example.setValue(10);
        System.out.println("Value: " + example.getValue());
 
        example.setValueWithStamp(20);
        System.out.println("Value with timestamp: " + example.getValue());
    }
}