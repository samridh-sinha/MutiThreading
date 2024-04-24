package locks;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResourceReadWriteLock {

    boolean isAvailable = false;

    public void producer(ReadWriteLock lock) {
        try {
            lock.readLock().lock();
            System.out.println("Read Lock is acquired By: " + Thread.currentThread().getName());
            Thread.sleep(10000);

        } catch (Exception e) {

        } finally {
            lock.readLock().unlock();
            System.out.println("Read Lock is released By: " + Thread.currentThread().getName());
        }
    }

    public void consume(ReadWriteLock lock) {
        try {
            lock.writeLock().lock();
            System.out.println("Write lock is acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
        } catch (Exception e) {

        } finally {
            lock.writeLock().unlock();
            System.out.println("Write lock is released by: " + Thread.currentThread().getName());
        }
    }

}
