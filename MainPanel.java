package MyProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Panina Daria
 */
public class MainPanel extends JPanel {
    private final int K = 8;
    private Pictures[][] imgs;
    private MyRunnable myRunnable;

    public MainPanel(MyRunnable myRunnable) {
        this.myRunnable = myRunnable;
        setSize(600, 600);
        setLocation(0, 0);
        setLayout(null);
        setBackground(Color.BLACK);
        imgs = new Pictures[4][4];
        addPics(4, 4);
    }

    private void addPics(int n, int m) {
        JButton[][] buttons = new JButton[n][m];
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = n * m / K;
        }
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int rndImg = rnd.nextInt(K);
                while (arr[rndImg] == 0) {
                    rndImg = rnd.nextInt(K);
                }
                imgs[i][j] = new Pictures(rndImg + 1, i * 100 + 100, j * 100 + 100);
                arr[rndImg]--;
                JButton button = new JButton(imgs[i][j].getRubashka());
                button.setSize(100, 100);
                button.setLocation(imgs[i][j].getX(), imgs[i][j].getY());
                button.addActionListener(new MyAction(button, i, j));
                buttons[i][j] = button;
                add(button);
            }
        }
    }

    private class MyAction implements ActionListener {
        private final JButton button;
        private final int x;
        private final int y;

        public MyAction(JButton button, int i, int j) {
            this.button = button;
            this.x = i;
            this.y = j;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            button.setIcon(imgs[x][y].getImg());
            myRunnable.addPic(button, imgs[x][y]);
        }
    }
}
