package interview.designpattern;

public class Tx implements Runnable {
    private Runnable task;

    public Tx(Runnable task) {
        this.task = task;
    }

    @Override
    public void run() {
        boolean shouldRollback = false;
        System.out.println("transactional begin.");
        try {
            // doWork
            task.run();
        } catch (Exception e) {
            shouldRollback = true;
            throw e;
        } finally {
            if (shouldRollback) {
                rollback();
            } else {
                commit();
            }
        }

    }

    private void commit() {
        System.out.println("commit.");
    }

    private void rollback() {
        System.out.println("rollback");
    }
}
