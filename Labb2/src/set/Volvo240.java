package src.set;
import java.awt.*;

public class Volvo240 extends PassengerCar{
    private Engine engine;
    private double trimFactor = 1.25;
    
    public Volvo240(double enginePower){
        super(4, 100,0, Color.black, "Volvo240", 0.1);
        engine = new Engine(enginePower);
    }
    public double speedFactor(){
        return engine.trimSpeedFactor(trimFactor);
    }
}
