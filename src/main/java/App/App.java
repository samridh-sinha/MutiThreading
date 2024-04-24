package App;


class Runner1 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<10;++i){
            try {
                Thread.sleep(10l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner 1 ->"+ i);
        }
    }
}

class Runner2 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<10;++i){
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner 2 ->"+ i);
        }

    }
}
public class App {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;++i)
                    System.out.println("Runner 1 ->"+ i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i=0;i<10;++i)
                System.out.println("Runner 2 ->"+ i);
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; ++i)
                System.out.println("Runner 3 ->" + i);
        });

        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 10; ++i)
                System.out.println("Runner 4 ->" + i);
        });

        //The start() method causes the thread to begin execution the jvm calls he run() method of the thread
        //It uses the time slicing algorithm
//        thread1.start();

//        thread2.start();
//        thread3.start();
//        thread4.start();

        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();

       runner1.start();
       runner2.start();

        try {
            runner1.join();
            runner2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //The join method is used for when we want a thread to finish
        System.out.println("Finished ith threads.....");


        System.out.println("**"+Thread.currentThread().getName());
    }
}
