package src.set;
import java.util.*;

public class CarLoader {
    

    public void loadCar(Vehicle car, LoaderInter loader){
        if(!car.equals(loader)){
            if(Math.sqrt(Math.pow(loader.getX()-car.getX(), 2) + Math.pow(loader.getY()-car.getY(), 2)) <= 10){
                if(loader.getLoadedCars().size() < loader.getLoadCapacity()){
                    loader.getLoadedCars().add(car);
                } else {
                    System.out.println("Max loaded cars reached");
                }
            }
        }
        
    }

    public void unloadCar(Vehicle car, LoaderInter loader){
        loader.getLoadedCars().remove(car);
    }
}
