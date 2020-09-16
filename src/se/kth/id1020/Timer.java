package se.kth.id1020;

/**
 * A simple timer that starts when instantiated.
 */
public class Timer {
    private long startTime = System.nanoTime();

    public long getStartTime(){return this.startTime;}

    public void reset(){
        this.startTime = System.nanoTime();
    }

    public long getRunTime(){
        return (System.nanoTime()-startTime)/1000000;
    }
}
