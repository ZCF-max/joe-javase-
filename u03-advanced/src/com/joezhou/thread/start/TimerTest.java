package com.joezhou.thread.start;

import lombok.SneakyThrows;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class TimerTest {

    private static class AlarmClockTask extends TimerTask {

        private boolean ring;

        @SneakyThrows
        @Override
        public void run() {
            Date now = new Date();
            String pattern = "HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(now);
            String str = "16:45:00";
            if (str.equals(dateStr)) {
                ring = true;
                for (int i = 0,j=3; i < j; i++) {
                    System.out.println("Got up.....");
                    TimeUnit.SECONDS.sleep(1L);
                }

            }

        }

        void setRing(boolean ring) {
            this.ring = ring;
        }
    }

    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        AlarmClockTask alarmClockTask = new AlarmClockTask();
        timer.schedule(alarmClockTask, 0, 1000);
        char exitFlag = 'q';
        if (System.in.read() == exitFlag) {
            timer.cancel();
            alarmClockTask.setRing(false);
        }
    }
}

