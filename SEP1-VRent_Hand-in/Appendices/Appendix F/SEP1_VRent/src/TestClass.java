public class TestClass {

    public static void main(String[] args) {

        Vehicle car = new Car(0, "", "");
        Vehicle car1= new Car(0, "Volkswagen", "Golf");
        Vehicle car2= new Car(0, "Doolkswagen", "Golf");
        Vehicle car3= new Car(0, "Dolkswagen", "Golf");
        Vehicle car4= new Car(0, "Solkswagen", "Golf");
        Vehicle car5= new Car(0, "Polkswagen", "Golf");
        Vehicle car6= new Car(0, "Lolkswagen", "Golf");
        Vehicle car7= new Car(0, "Kolkswagen", "Golf");
        Vehicle car8= new Car(0, "Jolkswagen", "Golf");
        Vehicle car9= new Car(0, "Holkswagen", "Golf");
        Vehicle car10= new Car(0, "Molkswagen", "Golf");
        Vehicle car11= new Car(0, "Nolkswagen", "Golf");
        Vehicle car12= new Car(0, "Xolkswagen", "Golf");
        Vehicle car13= new Car(0, "Zolkswagen", "Golf");
        Vehicle car14= new Car(0, "Tolkswagen", "Golf");
        Vehicle car15= new Car(0, "Folkswagen", "Golf");
        Vehicle car16= new Car(0, "Colkswagen", "Golf");
        Vehicle car17= new Car(0, "Bolkswagen", "Golf");
        Vehicle car18= new Car(0, "Vokswagen", "Golf");
        Vehicle car19= new Car(0, "wagen", "Golf");
        Vehicle car20= new Car(0, "Volksgen", "Golf");
        Vehicle car21= new Car(0, "Volkswa", "Golf");
        Vehicle car22= new Car(0,"kswagen", "Golf");
        Vehicle car23= new Car(0, "BMWn", "Golf");
        Vehicle car24= new Car(0, "BMC", "Golf");
        Vehicle car25= new Car(0, "VBMW", "Golf");
        Vehicle car26= new Car(0, "BMQ", "Golf");
        Vehicle car27= new Car(0, "BMW", "Golf");
        
        Vehicle van1= new Van(0, 4, "Mercede", "Sprinter");
        Vehicle van2= new Van(0, 8, "Mercdes", "Sprter");
        Vehicle van3= new Van(0, 5, "Mercedes", "Spinte");
        Vehicle van4= new Van(0, 17, "Merdes", "Sprint");
        Vehicle van5= new Van(0, 16, "Mercees", "Ster");
        Vehicle van6= new Van(0, 15, "Mdes", "Nter");
        Vehicle van7= new Van(0, 22, "Mercedees", "Arinter");
        Vehicle van8= new Van(0, 8, "Mrcedes", "Spnter");
        Vehicle van9= new Van(0, 13, "Medes", "Sinter");
        Vehicle van10= new Van(0, 14, "Mercedes", "Bprinter");
        Vehicle van11= new Van(0, 8, "ercedes", "Vprinter");
        Vehicle van12= new Van(0, 8, "Mecessddes", "Rprinter");
        
        Vehicle truck1= new Truck(0, 12, "Volvo", "Upper");
        Vehicle truck2= new Truck(0, 12, "Vol", "Super");
        Vehicle truck3= new Truck(0, 12, "Colvo", "Volori");
        Vehicle truck4= new Truck(0, 12, "SAAB", "BAAS");
        
        Vehicle camper= new Camper(0, 12, "Opel","Sub");
        
        
        
        Customer newCustomer = new Customer("First Name", "Last Name", "Phone", "STAFF", "STAFF");
        MyDate newDate = new MyDate(0, 0, 0, 0, 0, 0);
        Reservation reservation = new Reservation(newCustomer, car, newDate);

        

/**
 * create a new vehicle
 * add it by doing -- vehicleList.addVehicle()......(repeat multiple times)
 * adapter.addVehicleList(vehicleList)
 *
 */

        FileAdapterVehicleList adapter = new FileAdapterVehicleList("cars.bin");
        VehicleList vehicleList = adapter.getVehicleList();

       adapter.addVehicle(camper);
//       vehicleList.addVehicle(van11);
       
       

        vehicleList = adapter.getVehicleList();
        System.out.println(vehicleList);


        ReservationFileAdapter rfa = new ReservationFileAdapter("Reservations.bin");
        ReservationList newReservationList = rfa.getReservationList();

        rfa.addReservation(reservation);
        

        newReservationList = rfa.getReservationList();
        System.out.println(newReservationList.toString());



        CustomerListFileAdapter cfa = new CustomerListFileAdapter("Customers.bin");
        CustomerList customerList = cfa.getAllCustomers();

        cfa.addCustumer(newCustomer);
        
        customerList = cfa.getAllCustomers();System.out.println(customerList);

    }
}
