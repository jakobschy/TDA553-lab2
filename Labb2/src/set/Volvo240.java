package src.set;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class Volvo240 extends PassengerCar{
    private Engine engine;
    private double trimFactor = 1.25;
    public Volvo240(double x, double y){
        super(4, 125,0, Color.black, "Volvo240", 0.1, x, y);
        engine = new Engine(125);
    }
    public double speedFactor(){
        return engine.trimSpeedFactor(trimFactor);
    }
}