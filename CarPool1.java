import java.util.List;
import java.util.Scanner;
//this is a start
//the code isnt hard to read,basically what we have done in CS1301,1302 and now. no added stuff
//Since i dont have all the information yet changes will be made.
//read it and let me know
public class CarPool1 implements CarDriver {

    public static void main(String[] args) {
        Scanner scannerin = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        //Carpool car = null;    //may not be needed

        boolean continueLoop = true;
        do {

            if (car == null) {
                do {
                    System.out.print("Please select the car ");
                    String id = scannerin.next();
                    car = CarchoiceSystem.checkcars(id);
                } while (car == null);

                do {
                    System.out.print("How many passengers? ");
                    String passengers = scannerin.nextLine();

                    if (car.passengers().equals(car))
                        break;
                } while (true);
            }
//gives the user options for carpool since we are using a GUI
            System.out.println("Please enter a number to complete one of the following action(1-6): ");
            System.out.println("1) Search cars");
            System.out.println("2) select CarModel");
            System.out.println("3) Add passengers to car");
            System.out.println("4) Save passengers data");
            System.out.println("5) View cars available ");
            System.out.println("6) Exit");

            int option = scannerin.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Please enter customers name ");
                    String CustomerName = input.nextLine().trim();
                    System.out.println("Enter the total number of passengers ");
                    String totalnumber = input.nextLine();

                    List<Car> matched = CarpoolSystem.FindCars(CustomerName,totalnumber);

                    if (matched.isEmpty()) {
                        System.out
                                .println("No carpool available");//LINE 53 and 55 may be switched
                    } else {
                        System.out.println("Carpool available ");
                    }
                    for (Car car : matched) {
                        System.out.println("\tcar" + car.getName() + ", Model: "  + car.getNumber() + " passNumber " + car.getSize() + "Size");
                    }
                    break;

                case 2:

                    Car car = null;
                    do {
                        System.out.print("Enter the carpool you are removing: ");//cancel/remove carpool
                        String remove = input.nextLine();
                        car = CarpoolSystem.getCar(remove);
                        if (car == null)
                            System.out.println("Carpool has been cancelled ");
                    } while (car == null);

                    CarDealershipSystem.removeCar(car);
                    break;

                case 3:
                    System.out.print("Enter a name: ");
                    String name = input.nextLine();
                    System.out.print("Enter the car choice: ");
                    String choice = input.nextLine();
                    System.out.print("Enter the passenger number: ");
                    String passengernum = input.nextLine();
                    System.out.print("Enter the customer info ");
                    String Cinfo = input.nextLine();
                    System.out.print("Enter the car's destination ");//we may not use this line
                    int destination = input.nextInt();
                    System.out.print("Enter the availablity ");
                    int availablity = input.nextDouble();

                    Car newCustomer = new  Customer(name, choice,passengernum, Cinfo, destination, availablity);
                    Car anotherCustomer = new Customer (name, choice,passengernum, Cinfo, destination, availablity);
                    CarPoolSystem.setCar(new Customer());
                    break;

                case 4:
                    System.out.println("Enter the information of the client ");
                    String client = input.nextLine();
                    car = CarpoolSystem.getCar(car);

                    System.out.print("Please enter the customer's name: ");
                    String name = input.nextLine();

                    System.out.print("Please enter the customer's address: ");
                    String address = input.nextLine();
                    System.out.print("Please enter the customer's carpool size ");
                    int acn = input.nextInt();
                    System.out.print("Please enter the customer's phone number: ");
                    String phoneNumber = input.nextLine();

                    String id = null;
                    Customer customer = new Customer(name, address, id, Csize,phoneNumber);

                    CarpoolSystem.INFOCollection(car, customer);break;

                case 5:
                    List<Car> availableCars = CarpoolSystem.getavailableCars();

                    System.out.println("Cars available: ");

                    for (Car c : availableCars) {
                        System.out.println("there are still cars available");
                    }
                    break;

                case 6:
                    int total = 0;//0-15 is ultimately our goal for carpool size
                    int total = 15;
                    for (passengersInfo s : CarpoolSystem.people) {
                        System.out.println(s.getName());
                    }


                    System.out.println("Total carpools" + total);
                    break;

                case 7:
                    System.out.println("Thank you for carpooling!");
                    continueLoop = false;
                    System.exit(0);
                default:
                    continueLoop = false;
            }

        } while (continueLoop);

        scannerin.close();
    }
}
