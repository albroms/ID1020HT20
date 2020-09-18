package se.kth.id1020;

/**
 * A simple timer that starts when instantiated.
 */
public class Timer {
    private long startTime = System.currentTimeMillis();

    public long getStartTime(){return this.startTime;}

    public void reset(){
        this.startTime = System.currentTimeMillis();
    }

    public long getRunTime(){
        return (System.currentTimeMillis()-startTime);
    }
}
