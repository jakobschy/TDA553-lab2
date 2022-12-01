package src.set;

import java.awt.*;

public class Trim extends PassengerCar{
    private double trimFactor;

    public Trim(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnFactor, double trimFactor){
        super(nrDoors, enginePower, currentSpeed, color, modelName, turnFactor);
        this.trimFactor = trimFactor;

    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
    
}
