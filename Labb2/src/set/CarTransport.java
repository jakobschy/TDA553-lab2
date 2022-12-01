package src.set;
import java.awt.*;
import java.util.List;
import java.lang.Math.*;
import java.util.ArrayList;

public class CarTransport extends Truck{
    private boolean rampDown = false;
    private List<PassengerCar> loadedCars = new ArrayList<>();
    private int loadCapacity = 5;

    public CarTransport(){
        super(2, 125, 0, Color.red, "CarTransport", 0.05);
    }

    public boolean canChangeRampAngle(){
        if(getCurrentSpeed() != 0){
            return false;
        } else {
            return true;
        }
    }

    public void lowerRamp(){
        if(canChangeRampAngle()){
            rampDown = true;
        }
    }

    public void raiseRamp(){
        if(canChangeRampAngle()){
            rampDown = false;  
        }
    }

    @Override
    public boolean allowedToMove(){
        return !rampDown;

    }

    public void loadCar(PassengerCar car){
        if(Math.sqrt(Math.pow(this.getX()-car.getX(), 2) + Math.pow(this.getY()-car.getY(), 2)) <= 10){
            if(loadedCars.size() < 5){
                loadedCars.add(car);
            } else {
                System.out.println("Max loaded cars reached");
            }
        }
    }

    public void unloadCar(PassengerCar car){
        loadedCars.remove(car);
    }
}