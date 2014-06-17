package MyProject;

import javax.swing.*;

/**
 * Created by Panina Daria
 */
public class MyRunnable implements Runnable {
    private JButton button1;
    private Pictures pic1;
    private JButton button2;
    private Pictures pic2;
    private boolean time = false;
    private int numberOfPic = 0;

    public void addPic(JButton button, Pictures pic) {
        time = true;
        if ((pic1 == null) || (pic1.equals(pic))) {
            button1 = button;
            pic1 = pic;
        } else if ((pic2 == null) || (pic2.equals(pic))) {
            button2 = button;
            pic2 = pic;
        } else {
            check();
            button1 = button;
            pic1 = pic;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (pic2 != null) {
                    Thread.sleep(1000);
                    if (pic2 != null) {
                        check();
                    }
                }
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void check() {
        if (pic1.getNumber() != pic2.getNumber()) {
            button1.setIcon(pic1.getRubashka());
            button2.setIcon(pic2.getRubashka());
        }
        if (pic1.getNumber() == pic2.getNumber()) {
            button1.setEnabled(false);
            button2.setEnabled(false);
            numberOfPic += 2;
        }
        pic1 = null;
        pic2 = null;
    }

    public void reTime() {
        time = false;
        numberOfPic = 0;
    }

    public boolean getTime() {
        return time;
    }

    public int getNumberOfPic() {
        return numberOfPic;
    }
}
