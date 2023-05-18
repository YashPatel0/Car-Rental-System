import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String make;
    private String model;
    private boolean isRented;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.isRented = false;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}

class CarRentalSystem {
    private List<Car> cars;

    public CarRentalSystem() {
        cars = new ArrayList<>();
    }

    public void addCar(String make, String model) {
        Car car = new Car(make, model);
        cars.add(car);
    }

    public void rentCar(String make, String model) {
        for (Car car : cars) {
            if (car.getMake().equals(make) && car.getModel().equals(model) && !car.isRented()) {
                car.setRented(true);
                System.out.println("Car rented: " + car.getMake() + " " + car.getModel());
                return;
            }
        }
        System.out.println("Car not available for rent.");
    }

    public void returnCar(String make, String model) {
        for (Car car : cars) {
            if (car.getMake().equals(make) && car.getModel().equals(model) && car.isRented()) {
                car.setRented(false);
                System.out.println("Car returned: " + car.getMake() + " " + car.getModel());
                return;
            }
        }
        System.out.println("Car not rented or does not exist.");
    }
}

public class CAR_RENTAL_SYSTEM{
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        // Add some cars to the rental system
        rentalSystem.addCar("Toyota", "Camry");
        rentalSystem.addCar("Honda", "Civic");
        rentalSystem.addCar("Ford", "Mustang");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Rent a car");
            System.out.println("2. Return a car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter the make of the car: ");
                String make = scanner.next();
                System.out.print("Enter the model of the car: ");
                String model = scanner.next();
                rentalSystem.rentCar(make, model);
            } else if (choice == 2) {
                System.out.print("Enter the make of the car: ");
                String make = scanner.next();
                System.out.print("Enter the model of the car: ");
                String model = scanner.next();
                rentalSystem.returnCar(make, model);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
