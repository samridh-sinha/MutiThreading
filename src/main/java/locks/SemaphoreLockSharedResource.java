package locks;

import java.util.concurrent.Semaphore;

public class SemaphoreLockSharedResource {

    boolean isAvailable = false;
    Semaphore lock = new Semaphore(2);

    public void producer() {
        // we get a stamp because stamped lock also supports optimistic locking
        try {
            lock.acquire();
            System.out.println("Read Lock is acquired By: " + Thread.currentThread().getName());
            Thread.sleep(3000);

        } catch (Exception e) {

        } finally {
            lock.release();
            System.out.println("Read Lock is released By: " + Thread.currentThread().getName());
        }
    }

    public void consume() {
        try {

            System.out.println("Write lock is acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
        } catch (Exception e) {

        } finally {

            System.out.println("Write lock is released by: " + Thread.currentThread().getName());
        }
    }


}
