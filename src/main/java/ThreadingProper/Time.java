package ThreadingProper;

public class Time {

    int time;
    int startTime;
    int endTime;

    public Time(int time, int startTime, int endTime) {
        this.time = time;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getTime() {
        return time;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
