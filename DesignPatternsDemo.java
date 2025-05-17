import java.util.ArrayList;
import java.util.List;

public class DesignPatternsDemo {

    // Singleton - Logger
    static class Logger {
        private static Logger instance;

        private Logger() {}

        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            System.out.println("[LOG] " + message);
        }
    }

    // Factory Method - Vehicle and Factories
    abstract static class Vehicle {
        public abstract void drive();
    }

    static class Car extends Vehicle {
        @Override
        public void drive() {
            System.out.println("Car is driving");
        }
    }

    static class Motorcycle extends Vehicle {
        @Override
        public void drive() {
            System.out.println("Motorcycle is driving");
        }
    }

    abstract static class VehicleFactory {
        public abstract Vehicle createVehicle();
    }

    static class CarFactory extends VehicleFactory {
        @Override
        public Vehicle createVehicle() {
            return new Car();
        }
    }

    static class MotorcycleFactory extends VehicleFactory {
        @Override
        public Vehicle createVehicle() {
            return new Motorcycle();
        }
    }

    // Observer - Notification System
    interface VehicleObserver {
        void onVehicleEvent(String event);
    }

    static class VehicleEventNotifier {
        private List<VehicleObserver> observers = new ArrayList<>();

        public void addObserver(VehicleObserver observer) {
            observers.add(observer);
        }

        public void removeObserver(VehicleObserver observer) {
            observers.remove(observer);
        }

        public void notifyObservers(String event) {
            for (VehicleObserver observer : observers) {
                observer.onVehicleEvent(event);
            }
        }
    }

    static class VehicleEventLogger implements VehicleObserver {
        @Override
        public void onVehicleEvent(String event) {
            Logger.getInstance().log("Vehicle event: " + event);
        }
    }

    // Main method para testar tudo
    public static void main(String[] args) {
        VehicleEventNotifier notifier = new VehicleEventNotifier();
        VehicleObserver eventLogger = new VehicleEventLogger();
        notifier.addObserver(eventLogger);

        VehicleFactory factory = new CarFactory();
        Vehicle car = factory.createVehicle();
        car.drive();
        notifier.notifyObservers("Car started driving");

        factory = new MotorcycleFactory();
        Vehicle motorcycle = factory.createVehicle();
        motorcycle.drive();
        notifier.notifyObservers("Motorcycle started driving");
    }
}
