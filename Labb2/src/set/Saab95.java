package src.set;
import java.awt.*;

public class Saab95 extends Turbo{

    public boolean turboOn;
    
    public Saab95(){
        super(2, 125, 0, Color.red, "Saab95", 0.07, 1.3);
	    turboOn = false;
    }

}
