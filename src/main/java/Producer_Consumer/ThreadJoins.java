package Producer_Consumer;

public class ThreadJoins {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        System.out.println("Main thread is starting its work ");

        Thread produce1 = new Thread(() -> {
            System.out.println("Thread 1 calli g producce methpd");
            sharedResource.produce();
        });

//        produce1.setDaemon(true); // Now if the main thread stops working then the produce1 thread willa also stop its execution

//        produce1.setPriority(10);
        produce1.start();


        try {
            produce1.join(); // makes  the current thread to wait till a particular thread gas finished
            //i.e it makes the main thead wait till produce1 has terminataed

        } catch (InterruptedException e) {

        }

        System.out.println("Main thread is finishing its work ");
    }
}
