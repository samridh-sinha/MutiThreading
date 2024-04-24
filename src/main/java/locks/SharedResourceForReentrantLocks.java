package locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResourceForReentrantLocks {
    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public void producer() {
        try {
            lock.lock(); // Acquires the lock
            isAvailable = true;
            System.out.println("Local acquired by: " + Thread.currentThread().getName());
//            condition.signal();
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock(); // Lock is released
            System.out.println("Lock released by: " + Thread.currentThread().getName());
        }
    }

}
