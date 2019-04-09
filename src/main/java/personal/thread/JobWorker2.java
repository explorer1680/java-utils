package personal.thread;

public class JobWorker2 implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {//if you want this code working, you can't add sleep() inside of the while, I guess when sleep() throw InterruptedException, it will set the interrupted flag back.
            for (long i = 0; i <= 1000; i++) {
                System.out.println(i * i * i * i);
            }
        }
    }
}
