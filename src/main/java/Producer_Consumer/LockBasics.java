package Producer_Consumer;

public class LockBasics {

    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();
        SharedResource resource2 = new SharedResource();

        Thread t1 = new Thread(() -> {
            resource1.produce();
        });

        Thread t2 = new Thread(() -> {
            resource2.produce();
        });

        t1.start();
        t2.start();

    }
}
