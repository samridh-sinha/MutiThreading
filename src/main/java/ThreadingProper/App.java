package ThreadingProper;

public class App {

    public static void main(String[] args) {
        MultiThreadingLearning multiThreadingLearning = new MultiThreadingLearning();
        Thread thread = new Thread(multiThreadingLearning);
        //When we invoke the start method it internally calls the run method
        thread.start();

        MultithreadingLearning2 multithreadingLearning2 = new MultithreadingLearning2();
        Thread thread1 = new Thread(multithreadingLearning2);
        thread1.start();


        MonitorLockExample monitorLockExample = new MonitorLockExample();
        MonitorLockExample monitorLockExample2 = new MonitorLockExample();
        MonitorLockExample monitorLockExample3 = new MonitorLockExample();

        Thread t1 = new Thread(monitorLockExample::task1);

        Thread t2 = new Thread(monitorLockExample::task2); // Thread 2 will wait till the monitor lock is realeased from thread t2 for
        //for the object monitorLockExample Once t2 realeases the monitoe lock for the object then t2 can create a monitor lock
        // for the synchronied block .

        Thread t3 = new Thread(() -> monitorLockExample.task3());

        t1.start();
        t2.start();
        t3.start();
    }
}
