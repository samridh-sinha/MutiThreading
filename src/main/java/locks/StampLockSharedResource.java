package locks;


import java.util.concurrent.locks.StampedLock;

public class StampLockSharedResource {
    boolean isAvailable = false;

    StampedLock lock = new StampedLock();

    public void producer() {
        long stamp = lock.readLock(); // we get a stamp because stamped lock also supports optimistic locking
        try {

            System.out.println("Read Lock is acquired By: " + Thread.currentThread().getName());
            Thread.sleep(10000);

        } catch (Exception e) {

        } finally {
            lock.unlockRead(stamp);
            System.out.println("Read Lock is released By: " + Thread.currentThread().getName());
        }
    }

    public void consume() {
        long stamp1 = lock.writeLock();
        try {
            
            System.out.println("Write lock is acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
        } catch (Exception e) {

        } finally {
            lock.unlockWrite(stamp1);
            System.out.println("Write lock is released by: " + Thread.currentThread().getName());
        }
    }
}
