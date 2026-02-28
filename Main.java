import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        new MainFrame();
    }
}

class Visable {
    private ArrayList<Image> img = new ArrayList<>();
    private String imgPath = null;
    private ReadImageMethod readImgMethod = null;
    private int currImgId = 0;
    private int imgHeight, imgWidth;

    abstract class ReadImageMethod {
        public abstract void run(String imgPath, ArrayList<Image> img);
    }

    class DefaultReadImage extends ReadImageMethod {
        public void run (String imgPath, ArrayList<Image> img) {
            try {
                img.add(ImageIO.read(new File(imgPath)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Visable(String imgPath, int imgHeight, int imgWidth) {
        this.imgPath = imgPath;
        this.imgHeight = imgHeight;
        this.imgWidth = imgWidth;
        this.readImgMethod = new DefaultReadImage();
        this.readImgMethod.run(this.imgPath, img);
    }

    public Visable(String imgPath, int imgHeight, int imgWidth, ReadImageMethod readImgMethod) {
        this.imgPath = imgPath;
        this.imgHeight = imgHeight;
        this.imgWidth = imgWidth;
        this.readImgMethod = readImgMethod;
        this.readImgMethod.run(imgPath, img);
    }

    public Image getImage() {
        Image currImage = img.get(currImgId);
        currImgId = currImgId % img.size();
        return currImage;
    }

    public int getImgHeight() { return this.imgHeight; }
    public int getImgWidth() { return this.imgWidth; }
}

interface HasVisable { public Visable getVisable(); }
class Me implements HasVisable {
    private Visable visable = new Visable("me.png", 64,64);
    public Visable getVisable () { return this.visable; }
}

class MainFrame extends JFrame {
    Me me = new Me();

    public MainFrame() {
        setLayout(new FlowLayout());
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(me.getVisable().getImage(), me.getVisable().getImgHeight(), me.getVisable().getImgWidth(), this);
    }
}