package bj.zzy.tree;

import java.util.concurrent.TimeUnit;

public class Tester {
    public static void main(String[] args)   {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
