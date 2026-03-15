package main;

import entity.*;
import input.*;
import output.*;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable {
    private MainFrame mainFrame = null;
    private Me me = null;
    private KeyHandler keyH = null;

    public MainPanel () {
        // call all constructor of entities, listener, environment class
        mainFrame = new MainFrame();
        keyH = new KeyHandler();
        me = new Me();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
