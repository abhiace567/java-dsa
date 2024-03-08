package code.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HikingFriends {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);

        System.out.println(Thread.currentThread().getName() + " : Let's go for Hiking!");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " : Getting Ready...");
                sleep(ThreadLocalRandom.current().nextInt(400, 1000));
                System.out.println(Thread.currentThread().getName() + " : Ready!!!");
                latch.countDown();
            }, "Friend - " + (i + 1));
            thread.start();
        }
        latch.await();
        System.out.println(Thread.currentThread().getName() + " : Start Hiking!");
    }

    private static void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(HikingFriends.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
