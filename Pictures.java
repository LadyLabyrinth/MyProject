package MyProject;

import javax.swing.*;

/**
 * Created by Panina Daria
 */
public class Pictures {
    private final int number;
    private final int x;
    private final int y;
    private final ImageIcon img;
    private final ImageIcon rubashka;
    private final String imgPath = "C:\\home\\term4\\lang\\src\\java\\MyProject\\Resources\\";

    public Pictures(int number, int x, int y) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.img = new ImageIcon(imgPath + "pic_" + number + ".png");
        this.rubashka = new ImageIcon(imgPath + "rub.png");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return number;
    }

    public ImageIcon getImg() {
        return img;
    }

    public ImageIcon getRubashka() {
        return rubashka;
    }
}
