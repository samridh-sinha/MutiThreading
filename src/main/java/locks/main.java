package locks;

import java.util.concurrent.locks.ReentrantLock;

public class main {

    public static void main(String[] args) {
        //This lock does not depend on the object but depends on the lock
        ReentrantLock reentrantLock = new ReentrantLock();

        SharedResourceForReentrantLocks resource1 = new SharedResourceForReentrantLocks();

        Thread th1 = new Thread(() -> {
            resource1.producer();
        });


        SharedResourceForReentrantLocks resource2 = new SharedResourceForReentrantLocks();


        Thread th2 = new Thread(() -> {
            resource2.producer();
        });
        th1.start();
        th2.start();
    }
}
