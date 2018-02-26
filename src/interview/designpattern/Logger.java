package interview.designpattern;

public class Logger implements Runnable {

    private Runnable task;

    public Logger(Runnable task) {
        this.task = task;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("start time : " + startTime);
        // doWork
        task.run();
        System.out.println("elapsed time : " + (System.currentTimeMillis()-startTime));
    }
}
