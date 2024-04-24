package ThreadingProper;

public class SharedResource {

    boolean isItemPresent = false;

    public synchronized void addItem(){
        isItemPresent = true;
        System.out.println("Producer  Thread calling th notify method");
        notifyAll();
    }

    public synchronized void consumeItem(){

        System.out.println("Consumert hread inside cnsume otem method ");
        //While is used to avoid spurious wake up
        while(!isItemPresent){
            try {
                System.out.println("Consumert hread iswaiting  ");
                wait(); //Realease all monitor locks
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isItemPresent  = false;
    }
}
