package output;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Visible {
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

    public Visible(String imgPath, int imgHeight, int imgWidth) {
        this.imgPath = imgPath;
        this.imgHeight = imgHeight;
        this.imgWidth = imgWidth;
        this.readImgMethod = new DefaultReadImage();
        this.readImgMethod.run(this.imgPath, img);
    }

    public Visible(String imgPath, int imgHeight, int imgWidth, ReadImageMethod readImgMethod) {
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

