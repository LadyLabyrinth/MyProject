package MyProject;

import javax.swing.*;

/**
 * Created by Panina Daria
 */
public class TimeRunnable implements Runnable {
    private final JLabel timeLabel;
    private int time;
    private MyRunnable myRunnable;

    public TimeRunnable(JLabel timeLabel, MyRunnable myRunnable) {
        this.timeLabel = timeLabel;
        this.myRunnable = myRunnable;
    }

    @Override
    public void run() {
        time = 0;
        while (true) {
            if (myRunnable.getTime()) {
                timeLabel.setText("Time: " + time + " sec");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (myRunnable.getNumberOfPic() != 16) {
                    time++;
                }
            } else {
                time = 0;
                timeLabel.setText("Time: " + time + " sec");
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
