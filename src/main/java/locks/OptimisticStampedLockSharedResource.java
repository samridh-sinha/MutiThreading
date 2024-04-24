package locks;

import java.util.concurrent.locks.StampedLock;

public class OptimisticStampedLockSharedResource {

    int a = 10;
    StampedLock lock = new StampedLock();
    public void producer(){
        long stamp = lock.tryOptimisticRead();
        try{
            System.out.println("Taken optimistic Read");
            a = 11;
            Thread.sleep(6000);

            if(lock.validate(stamp)){
                System.out.println("Updated a value successfully!!");
            }else{
                System.out.println("Rollback the work ");
                a = 10;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void consumer(){
        long stamp = lock.writeLock();
        System.out.println("write lock is acquired by : "+Thread.currentThread().getName());

        try{
            System.out.println("Performing work ");
            a = 9;
        }finally {
            lock.unlockWrite(stamp);
        }
    }
}
