package ThreadPools;

import java.util.concurrent.*;

public class main {

    public static void main(String[] args) {
        /*Why is the core thread pool size is taken as 2? Why not 10 or 15 Whats the logic?*/
        int noOfProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("No. Of processors " + noOfProcessors);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new CustomThreadFactory(),
                new CustomRejectHandler());

        /*
            Generally, The threadPool min and max depend on
            1) CPU cores  - Context switching happens between the cpu cores
            2) JVM memory
            3) tasks Nature (Cpu intensive or I/O intensive)
            4) Concurrency Requirement (Want high, medium or low concurrency)
            5) Throughput etc

            Max no. of threads  = No. Of cpu cores * (1+Request waiting time/processing time) not full proof ]
         */

        executor.allowCoreThreadTimeOut(true);
        for (int i = 1; i <= 7; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {

                }
                System.out.println("Tsk is processed by" + Thread.currentThread().getName());
//                System.out.println("The remaining capacity is :"+executor.getQueue().remainingCapacity());
            });
        }
        executor.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.setDaemon(false);
        return thread;
    }
}

class CustomRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: " + r.toString());
    }
}
