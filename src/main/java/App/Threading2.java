package App;
class DaemonWorker implements Runnable{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("The daemon thread is running...");
        }
    }
}

class WorkerThread implements Runnable{

    @Override
    public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Worker thread is running...");

    }
}


public class Threading2 {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(new DaemonWorker());
        t1.setDaemon(true);
        t1.start();

        Thread t2 = new Thread(new WorkerThread());
        t2.start();
        System.out.println(t1.isDaemon());
        System.out.println(t2.isDaemon());
    }
}
