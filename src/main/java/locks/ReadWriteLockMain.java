package locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockMain {

    public static void main(String[] args) {
        ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        SharedResourceReadWriteLock resource1 = new SharedResourceReadWriteLock();

        Thread th1 = new Thread(() -> {
            resource1.producer(reentrantReadWriteLock); // th1 is putting shared lock
        });

        Thread th2 = new Thread(() -> {
            resource1.producer(reentrantReadWriteLock); // th2 is putting a shared lock
        });
        SharedResourceReadWriteLock resource2 = new SharedResourceReadWriteLock();

        Thread th3 = new Thread(() -> {
            resource2.consume(reentrantReadWriteLock); // th3 is trying to pust an exclusive lock

        });

        th1.setPriority(10);
        th2.setPriority(9);
        th3.setPriority(5);

        th1.start();
        th2.start();
        th3.start();
    }
}
