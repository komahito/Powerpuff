package entity;

import output.Visible;
import main.InitFactor;
import main.UpdateFactor;
import output.HasVisible;

public class Me implements HasVisible, InitFactor, UpdateFactor {
    private Visible visable = new Visible("me.png", 64,64);
    public Visible getVisible () { return this.visable; }
}
