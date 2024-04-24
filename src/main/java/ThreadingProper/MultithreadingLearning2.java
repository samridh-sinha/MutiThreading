package ThreadingProper;

public class MultithreadingLearning2 extends Thread{

    @Override
    public void run() {
        System.out.println("Code excecuted by thread class: "+ Thread.currentThread().getName());
    }
}
