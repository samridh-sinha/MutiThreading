package Producer_Consumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedQueueResource {
    Queue<Integer> queue;
    int size;
    int capacity;

    public SharedQueueResource(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.size = 0;
    }

    public synchronized void insertElement(int val) {
        if (this.size >= this.capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        notifyAll();
        System.out.println("Add element "+ val);
        queue.add(val);
        this.size++;
    }

    public synchronized void removeElement() {
        while (this.size == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
        }
        notifyAll();
        System.out.println("Remove element "+ queue.peek());
        queue.remove();
        this.size--;
    }

}
