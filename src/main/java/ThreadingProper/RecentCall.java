package ThreadingProper;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCall {

    Queue<Time> queue;

    public RecentCall() {
        queue = new LinkedList<>();
        queue.add(new Time(0, -3000, 0));
    }

    public int ping(int t) {
        Time peek = queue.peek();
        int stat = peek.startTime - t;
        int end = peek.endTime - t;

        while(queue.peek().startTime<=stat && queue.peek().endTime>=end){
            queue.poll();
        }

        return queue.size();
    }
}
