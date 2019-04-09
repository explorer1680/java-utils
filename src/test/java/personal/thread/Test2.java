package personal.thread;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        JobWorker2 jb = new JobWorker2();
        Thread t = new Thread(jb);
        t.start();

        Thread.sleep(10);

        t.interrupt();

    }
}
