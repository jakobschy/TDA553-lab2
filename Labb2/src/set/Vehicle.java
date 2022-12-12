package src.set;
import java.awt.*;
import java.util.Random;
public abstract class Vehicle implements Moveable{
    private int nrDoors; // Number of doors on the src.car
    private double enginePower; // Engine power of the src.car
    private double currentSpeed; // The current speed of the src.car
    private Color color; // Color of the src.car
    private String modelName; // The src.car model name
    private double x,y;
    private final int maxCoords = 500;
    private double dir;
    private double turnFactor;
    private boolean allowedToMove = true;
    public Vehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnFactor, double x, double y) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.turnFactor = turnFactor;
        Random rnd = new Random();
        this.x = x;
        this.y = y;//rnd.nextDouble(0, maxCoords);
    }
    
    public void setCurrentSpeed(double speed){
        if(allowedToMove){
            if(speed > getEnginePower()) {
                this.currentSpeed = getEnginePower();
                System.out.print("speed too high, was set to enginePower");
            }
            if(speed < 0) {
                this.currentSpeed = 0;
                System.out.print("speed too low, was set to 0");
            }
            else{
                this.currentSpeed = speed;
            }
        }else{
            currentSpeed = 0;
        }
    }

    public void startEngine(){
        setCurrentSpeed(0.2);
    }
    public void setColor(Color clr){
        color = clr;
    }

    public void setDir(double dir) {
        if(dir > 0) this.dir = dir % (2 * Math.PI);
        if(dir < 0) this.dir = (2 * Math.PI) -((-dir) % (2 * Math.PI));
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setAllowedToMove(boolean allowedToMove) {
        this.allowedToMove = allowedToMove;
    }
    public boolean isAllowedToMove() {
        return allowedToMove;
    }

    public double getDir() {
        return dir;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }
    public int getMaxCoords() {
        return maxCoords;
    }

    public void stopEngine(){
        setCurrentSpeed(0);
    }
    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }
    public void move() {
        if(Math.abs(this.y+currentSpeed * Math.cos(dir)) <= maxCoords){
            this.y += currentSpeed * Math.cos(dir);
        }else{ this.y = Math.signum(currentSpeed * Math.cos(dir)) * maxCoords;}

        if(Math.abs(x+currentSpeed * Math.sin(dir)) <= maxCoords){
            x += currentSpeed * Math.sin(dir);
        }else{ x = Math.signum(currentSpeed * Math.sin(dir)) * maxCoords;}
    }
    public void turnLeft() {setDir(dir + turnFactor);}
    public void turnRight() {setDir(dir - turnFactor);}


    public void gas(double amount){
        if(amount > 0) {
            incrementSpeed(amount);
        }else{
            System.out.println("gas vehicle");
            System.out.print("Invalid amount: " + amount);
        }
    }
    public void brake(double amount){
        if(amount > 0) {
            decrementSpeed(amount);
        }else{
            System.out.print("Invalid amount: " + amount);
        }
    }
    
    public abstract double speedFactor();
}