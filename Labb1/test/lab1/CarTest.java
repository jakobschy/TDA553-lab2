package lab1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CarTest {
    
    @Test
    public void carTester(){
        Volvo240 car = new Volvo240();
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed(), 0.00000001);

    }

    @Test
    public void moveAndTurnTest(){
        Saab95 car = new Saab95();
        double oldx = car.getX();
        double oldy = car.getY();
        car.turnLeft();
        car.gas(0.5);
        car.move();
        assertEquals(false, oldx == car.getX());
        assertEquals(false, oldy == car.getY());

    }

    @Test
    public void breakTest(){
        Volvo240 car = new Volvo240();
        car.startEngine();
        car.gas(0.5);
        double oldSpeed = car.getCurrentSpeed();
        car.brake(0.5);
        assertEquals(true, oldSpeed > car.getCurrentSpeed());

    }

    @Test
    public void gasTooMuchTest(){
        Volvo240 car = new Volvo240();
        car.startEngine();
        double maxEnginePower = car.getEnginePower();
        car.setCurrentSpeed(car.getEnginePower() + 1);
        assertEquals(maxEnginePower, car.getEnginePower(), 0.00000001);
    }



}