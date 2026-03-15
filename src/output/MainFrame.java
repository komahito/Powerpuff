package output;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import entity.Me;
import main.InitFactor;
import main.UpdateFactor;

public class MainFrame extends JFrame implements InitFactor, UpdateFactor {
    ArrayList<Visible> visibleArr = null;
    Me me = new Me();

    public MainFrame() {
        visibleArr = new ArrayList<>();
        setLayout(new FlowLayout());
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(me.getVisible().getImage(), me.getVisible().getImgHeight(), me.getVisible().getImgWidth(), this);
    }
}