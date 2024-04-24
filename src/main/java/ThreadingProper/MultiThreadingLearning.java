package ThreadingProper;

public class MultiThreadingLearning implements Runnable{
    @Override
    public void run() {
        System.out.println("Code excecuted by thread interface: "+ Thread.currentThread().getName());
    }
}
