package MyProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Panina Daria
 */
public class SupportPanel extends JPanel {
    private MyRunnable myRunnable;
    private final MainFrame mainFrame;

    public SupportPanel(MyRunnable myRunnable, MainFrame mainFrame) {
        this.myRunnable = myRunnable;
        this.mainFrame = mainFrame;
        setSize(200, 600);
        setLocation(600, 0);
        setLayout(null);
        setBackground(Color.GRAY);
        addWidgets();
        setVisible(true);
    }

    private void addWidgets() {
        JLabel time = new JLabel("Time: ");
        time.setSize(100, 50);
        time.setLocation(50, 50);
        JButton restartButton = new JButton("Restart");
        restartButton.setSize(100, 50);
        restartButton.setLocation(50, 100);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myRunnable.reTime();
                mainFrame.getContentPane().remove(1);
                mainFrame.getContentPane().add(new MainPanel(myRunnable));
                mainFrame.repaint();
            }
        });
        add(time);
        add(restartButton);
        Runnable timeRun = new TimeRunnable(time, myRunnable);
        Thread thread = new Thread(timeRun);
        thread.start();
    }
}
