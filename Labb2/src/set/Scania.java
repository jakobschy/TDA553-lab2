package src.set;
import java.awt.*;

public class Scania extends Truck{
    private int rampAngle = 0;

    public Scania(double x, double y){
        super(2, 125, 0, Color.red, "Scania", 0.05, x, y);
    }

    public boolean canChangeRampAngle(){
        if(getCurrentSpeed() != 0){
            return false;
        } else {
            return true;
        }
    }

    public void lowerRampByDegrees(int degrees){
        if(canChangeRampAngle()){
            if(rampAngle - degrees >= 0 && degrees >= 0){
                rampAngle -= degrees;
                checkIfAllowedToMove();
    
            } else {
                System.out.println("Degrees were out of range or negative : " + degrees);
            }
        }
    }

    public void raiseRampByDegrees(int degrees){
        if(canChangeRampAngle()){
            if(rampAngle + degrees <= 70 && degrees >= 0){
                rampAngle += degrees;
                checkIfAllowedToMove();
    
            } else {
                System.out.println("Degrees were out of range or negative : " + degrees);
            }    
        }
    }


    public void checkIfAllowedToMove(){
        if(rampAngle == 0){
            setAllowedToMove(true);
        } else {
            setAllowedToMove(false);
        }

    }


}
