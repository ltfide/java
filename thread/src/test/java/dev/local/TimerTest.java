package dev.local;

import java.util.Timer;
import java.util.TimerTask;

import org.junit.jupiter.api.Test;

public class TimerTest {

    @Test
    void delayedJob() throws InterruptedException {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Running");
            }
        };

        // Schedule task to run after 2 seconds
        timer.schedule(timerTask, 2000); // Running

        Thread.sleep(3000L);
    }

    @Test
    void periodicJob() throws InterruptedException {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Running");
            }
        };

        // Schedule task to run after 2s and every 2s
        timer.schedule(timerTask, 2000, 2000);

        Thread.sleep(10_000L);
    }
}
