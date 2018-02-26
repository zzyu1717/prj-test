package interview.designpattern;

import java.util.concurrent.TimeUnit;

public class CodingTask implements Runnable {

    @Override
    public void run() {
        System.out.println("writing code...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
