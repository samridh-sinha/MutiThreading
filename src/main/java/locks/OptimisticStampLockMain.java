package locks;

public class OptimisticStampLockMain {

    public static void main(String[] args) {
        OptimisticStampedLockSharedResource resource = new OptimisticStampedLockSharedResource();

        Thread th1 = new Thread(() -> {
            resource.producer();
        });

        Thread th2 = new Thread(() -> {
            resource.consumer();
        });

        th1.start();
        th2.start();
    }
}
