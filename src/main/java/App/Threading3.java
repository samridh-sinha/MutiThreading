package App;

public class Threading3 {

    public static int counter = 0;
    //make sure this method is called only by a single thread a  given time
    private static synchronized void increment() {
        counter++;
    }
    public static void process(){
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++)

                increment();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++)
                increment();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The counter value is :"+counter);
    }

    public static void main(String[] args) {
        process();
    }

}
