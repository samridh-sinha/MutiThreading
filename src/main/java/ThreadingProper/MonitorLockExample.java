package ThreadingProper;

public class MonitorLockExample {

    public synchronized void task1() {
        try{
            System.out.println("Inside task1");
            Thread.sleep(10000);
        }catch (Exception e){

        }
    }
    public void task2(){
        System.out.println("Task2, but nefore synchonized ");
        synchronized (this){
            System.out.println("Task  , inside synchronozes");
        }

    }

    public void task3(){
        System.out.println("Inside task 3");
    }
}
