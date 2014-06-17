package MyProject;

import javax.swing.*;

/**
 * Created by Panina Daria
 */
public class MainFrame extends JFrame {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }

    public MainFrame() {
        super("Find Two");
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        addWidgets();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addWidgets() {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        JPanel supportPanel = new SupportPanel(myRunnable, this);
        getContentPane().add(supportPanel);
        JPanel mainPanel = new MainPanel(myRunnable);
        getContentPane().add(mainPanel);
    }

}
