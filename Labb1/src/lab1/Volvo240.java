package lab1;

import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4, 125, 0, Color.black, "Volvo240", 0.12);
        stopEngine();
    }
    
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
        
    @Override
    public void incrementSpeed(double amount){
	    setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
        }

    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }
}
