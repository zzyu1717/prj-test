package interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 关键字可以保证内存可见性和原子性
 */
public class SynchronizedDemo {

    private boolean flag = false;
    private int number = 1;
    private int result = 0;

    public synchronized void write() {
        flag = true;
        number = 2;
    }
    public synchronized void read() {
        if (flag) {
            result = 3 * number;
        }
        System.out.println(result);
    }

    class WriteReadThread extends Thread {

        private boolean isWrite;

        public WriteReadThread(boolean isWrite) {
            this.isWrite = isWrite;
        }

        @Override
        public void run() {
            if (isWrite) {
                write();
            } else {
                read();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo syncDemo = new SynchronizedDemo();
        // write thread
        syncDemo.new WriteReadThread(true).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // read thread
        syncDemo.new WriteReadThread(false).start();
    }
}
