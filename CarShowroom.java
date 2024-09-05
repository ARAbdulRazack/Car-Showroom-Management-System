import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private double price;

    public Car(String make, String model, int year, String color, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Car Information:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Price: " + price);
    }

    public double getPrice() {
        return price;
    }
}

class Showroom {
    private String name;
    private List<Car> cars;

     public List<Car> getCars() {
        return cars;
    }

    public Showroom(String name) {
        this.name = name;
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void displayCars() {
        System.out.println( );
        System.out.println("Cars available in " + name + " showroom:");
        for (Car car : cars) {
            car.displayInfo();
            System.out.println("--------------");
        }
    }

    public String toString() {
        return name;
    }

    public Car selectCar(int index) {
        if (index >= 0 && index < cars.size()) {
            return cars.get(index);
        } else {
            return null;
        }
    }
}

class Payment {
    private double amount;
    private String paymentMethod;

    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public void displayInfo(double carPrice) {
        System.out.println("Payment Information: ");
        System.out.println("Amount Paid: " + amount);
        
        double difference = amount - carPrice;
        if (difference > 0) {
            System.out.println("You paid more amount. Enjoy the benefits! "+difference);
        } else if (difference < 0) {
            System.out.println("You paid less amount. Additional payment may be required. " +Math.abs(difference));
        } else {
            System.out.println("Your payment is complete. Thank you!");
        }
        System.out.println("Payment Method: " + paymentMethod);
    }

    }

class Customer {
    private String name;
    private String phno;
    private String address;
    private String proof;
    private Payment payment;

    public Customer(String name,String phno,String address,String proof) {
        this.name = name;
        this.phno = phno;
        this.address = address;
        this.proof = proof;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void info(){
        // System.out.println("Customer Information:");
        // System.out.println("Enter your Name: " + name);
        // System.out.println("Enter your Phone Number: " + phno);
        // System.out.println("Enter your Address: " + address);
        // System.out.println("Enter your Address: " + proof);
         if (payment != null) {
            payment.displayInfo(0);;
        }
    }


    public void registerCar(Car car, double amount, String paymentMethod) {
        Payment payment = new Payment(amount, paymentMethod);
        setPayment(payment);
        System.out.println();
        System.out.println("-----------");
        System.out.println("Customer Information:"+"\n"+"Name: " + name.toUpperCase() + "\n" + "Phno: " + phno + "\n" + "Address: " + address + "\n" + "Proof Submitted: " + proof +" \nHas Registered the following car");
        System.out.println();
        car.displayInfo();
        System.out.println();
        payment.displayInfo(car.getPrice());
        System.out.println();
        System.out.println("Congratulations! Enjoy your new car.");
        System.out.println("-----------");
    }
}

public class CarShowroom {
    public static void main(String[] args) {
        // Create three showrooms in Chennai
        Showroom showroom1 = new Showroom("Honda at Adyar");
        Showroom showroom2 = new Showroom("Honda at Alwarpet");
        Showroom showroom3 = new Showroom("Honda at Besant Nagar");


        // Add cars to showrooms
        showroom1.addCar(new Car("Honda", "Civic", 2023, "Silver", 25000.0));
        showroom1.addCar(new Car("Honda", "Accord", 2023, "Blue", 32000.0));
        showroom1.addCar(new Car("Honda", "CR-V", 2023, "Red", 28000.0));
        showroom1.addCar(new Car("Honda", "Rav4", 2023, "White", 27000.0));


        showroom2.addCar(new Car("Honda", "Camry", 2023, "Black", 30000.0));
        showroom2.addCar(new Car("Honda", "Rav4", 2023, "White", 27000.0));
        showroom2.addCar(new Car("Honda", "CR-V", 2023, "Red", 28000.0));

        showroom3.addCar(new Car("Honda", "Escape", 2023, "Green", 26000.0));
        showroom3.addCar(new Car("Honda", "Explorer", 2023, "Gray", 35000.0));
        showroom3.addCar(new Car("Honda", "CR-V", 2023, "Red", 28000.0));
        showroom3.addCar(new Car("Honda", "Camry", 2023, "Black", 30000.0));

        Scanner sc = new Scanner(System.in);
        System.out.println("Available Showrooms in Chennai:");
        System.out.println("1. "+showroom1 );
        System.out.println("2. "+showroom2  );
        System.out.println("3. "+showroom3  );
        
        Showroom selectedShowroom = null;

        do{
        System.out.print("Enter the number of the showroom you want to visit: ");
        int selectedShowroomIndex = sc.nextInt();

        switch (selectedShowroomIndex) {
            case 1:
                selectedShowroom = showroom1;
                break;
            case 2:
                selectedShowroom = showroom2;
                break;
            case 3:
                selectedShowroom = showroom3;
                break;
            default:
                System.out.println("Invalid showroom selection. Please try again.");
                // System.exit(0);
        }

        } while (selectedShowroom == null);



        // Display cars in the selected showroom
         selectedShowroom.displayCars();

        // Let the customer select a car from the showroom
        Scanner scanner = new Scanner(System.in);
        int selectedCarIndex ;
        do{
        System.out.print("Enter the index of the car you want to select: ");
        selectedCarIndex = scanner.nextInt();
        if (selectedCarIndex < 1 || selectedCarIndex > selectedShowroom.getCars().size()) {
                System.out.println("Invalid car selection. Please try again.");
            }
        }while(selectedCarIndex < 1 || selectedCarIndex > selectedShowroom.getCars().size());

        Car selectedCar =  selectedShowroom.selectCar(selectedCarIndex-1);


        if (selectedCar != null) {
            Scanner inputScanner = new Scanner(System.in);
            
            System.out.print("Enter your Name: ");
            String name = inputScanner.nextLine();
            System.out.print("Enter your Phone number: ");
            String phno = inputScanner.nextLine();
            System.out.print("Enter your Address: ");
            String address = inputScanner.nextLine();
            // Select proof method using switch case
            System.out.println("Proof Method Available:");
            System.out.println("1. Aadhar");
            System.out.println("2. Driving Licence");
            System.out.println("3. Pan Card");
            System.out.print("Select Any Proof Method:");
            int proofmethodchoice = inputScanner.nextInt();  
            String proof; 

            switch (proofmethodchoice) {
            case 1:
                proof = "Aadhar";
                break;
            case 2:
                proof = "Driving Licence";
                break;
            case 3:
                proof = "Pan Card";
                break;
            default:
                System.out.println("Invalid proof method choice. Defaulting to Aadhar.");
                proof = "Aadhar";
                break;
             }
   

            // Get payment information
            System.out.print("Enter the payment amount: ");
            double paymentAmount = inputScanner.nextDouble();
            inputScanner.nextLine(); // Consume the newline character


        // Select payment method using switch case
        System.out.println("Payment Method Available:");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. Cash");
        System.out.println("4. UPI");
        System.out.print("Select Any Payment Method:");

        int paymentMethodChoice = inputScanner.nextInt();
        String paymentMethod;

  
        switch (paymentMethodChoice) {
            case 1:
                paymentMethod = "Credit Card";
                break;
            case 2:
                paymentMethod = "Debit Card";
                break;
            case 3:
                paymentMethod = "Cash";
                break;
            case 4:
                paymentMethod = "UPI Payment";
                break;
            default:
                System.out.println("Invalid payment method choice. Defaulting to Cash.");
                paymentMethod = "Cash";
                break;
        }
    

            // System.out.print("Enter the payment method: ");
            // String paymentMethod = inputScanner.nextLine();

            // Create a customer and register the selected car
            Customer customer = new Customer(name,phno,address,proof);
            customer.registerCar(selectedCar, paymentAmount, paymentMethod);
        } 
        // else {
        //     System.out.println("Invalid car selection. Please try again.");
        // }
    }
}
