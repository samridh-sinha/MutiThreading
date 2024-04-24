package Producer_Consumer;

public class Main {

    public static void main(String[] args) {
        SharedQueueResource sharedQueueResource = new SharedQueueResource(5);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                sharedQueueResource.insertElement(i);
            }
        });

        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                sharedQueueResource.insertElement(i);
            }
        });

        Thread t6 = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                sharedQueueResource.insertElement(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                sharedQueueResource.removeElement();
            }

            sharedQueueResource.removeElement();
            sharedQueueResource.removeElement();
            sharedQueueResource.removeElement();


        });


//        t1.start();
//        t2.start();


        SharedResource sharedResource = new SharedResource();

        Thread produce1 = new Thread(() -> {
            System.out.println("Thread 1 calli g producce methpd");
            sharedResource.produce();
        });

        Thread produce2 = new Thread(() -> {
            System.out.println("Thread 2 calli g producce methpd");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println("Thread 2 calling the produce method");
            sharedResource.produce();
        });

        produce1.start();
        produce2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        System.out.println("Thread1 is suspended");

        produce1.suspend();
        produce1.resume();

        System.out.println("Main thread is finishing its work");
    }
}
