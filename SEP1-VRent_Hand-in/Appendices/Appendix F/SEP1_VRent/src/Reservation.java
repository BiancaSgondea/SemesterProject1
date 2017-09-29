
import java.io.Serializable;
/**
 * 
 * @author Group 2 [ ]
 *
 */
public class Reservation implements Serializable
{

   // Well, the reservation obviously has the whole information packed at one place
   private Vehicle vehicle;
   private Customer customer;
   private MyDate dateInterval;
   private double finalPrice;
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // These are default prices per day for every vehicle type
   
   private final int CAR_PRICE = 100;
   private final int VAN_PRICE = 200;
   private final int CAMPER_PRICE = 300;
   private final int TRUCK_PRICE = 400;
   
   
   
   public Reservation(Customer customer,Vehicle vehicle, MyDate date){
      this.vehicle = vehicle;
      this.customer = customer;
      this.dateInterval = date;
    
   }
   
   public String getCustomerName()
   {
      return customer.getFullName();
   }
   
   //  - * - * - * - * - * - * - * - * - * - * - * 
   
   
   
   // 
   /**
    * We input the drivers licence in the method which calls another method in customer which sets the driver licence field to the given string
    * @param licence Licence that is inputed, basically a setter method
    */
   public void licenceInputer(String licence)
   {
      customer.setDriversLicence(licence);
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // 
   /**
    * True of False method that checks if the inputed customer object is equal to the customer in the reservation
    * @param customer Inputed customer for checking 
    * @return True or false
    */
   public boolean customerEquals(Customer customer)
   {
      if ( this.customer.getFirstName() == customer.getFirstName() && this.customer.getLastName() == customer.getLastName() &&
            this.customer.getPhoneNo() == customer.getPhoneNo() && this.customer.getAddress() == customer.getAddress())
      {
         return true;
      }
      else return false;
   }
   
   public String getCustomerNumber()
   {
      return customer.getDriversLicence();
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // 
   
   // 
   /**
    * When the deed is done, and the vehicle is returned back to the company, we need to clear out the date in the vehicles date interval list
    * Then we call this method which sparks off the chain-calling of other methods in order to delete the date interval
    */
   
   public void freeIntervalSpace()
   {
      vehicle.deleteDate(dateInterval);
   }
   
   
   
   
   
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   
   /**
    *  Ah, my crown jewel, or at least I think so :S
    *
    *Anyhow, the point is to calculate the price that a customer needs to pay, we can do that if we know what type he is renting, and for how long
    *
    *Since we know the date of the pickup and the date of return we can calculate the number of days that the car is being reserved
    *
    *For date we use method called "daysInInterval()", that method returns the number of days 
    *
    *Then we simply check what type of vehicle is rented and multiply the price per day for a specific vehicle with number of days
    */
   
   
   public double calculatePrice()
   {
      int numberOfDays = dateInterval.daysInInterval();
      if (vehicle instanceof Car)
      {
         if ( numberOfDays > 7)
         {
            finalPrice = (CAR_PRICE * numberOfDays)-(CAR_PRICE*numberOfDays*0.3);
         }
         else finalPrice = CAR_PRICE * numberOfDays;
      }
      else if ( vehicle instanceof Camper)
      {
         if (numberOfDays > 7)
         {
            finalPrice = (CAMPER_PRICE * numberOfDays)-(CAMPER_PRICE*numberOfDays*0.3);
            //finalPrice = (CAMPER_PRICE * 0.7) * (numberOfDays - 7) + 7 * CAMPER_PRICE;
         }
         else finalPrice = CAMPER_PRICE * numberOfDays;
      }
      else if ( vehicle instanceof Truck)
      {
         if ( numberOfDays > 7)
         {
            finalPrice = (TRUCK_PRICE * numberOfDays)-(TRUCK_PRICE*numberOfDays*0.3);
            //finalPrice = (TRUCK_PRICE * 0.7) * (numberOfDays - 7) + 7 * TRUCK_PRICE;
         }
         else finalPrice = TRUCK_PRICE * numberOfDays;
      }
      else if ( vehicle instanceof Van)
      {
         if ( numberOfDays > 7)
         {
            finalPrice = (VAN_PRICE * numberOfDays)-(VAN_PRICE*numberOfDays*0.3);
            //finalPrice = (VAN_PRICE * 0.7) * (numberOfDays - 7) + 7 * VAN_PRICE;
         }
         else finalPrice = VAN_PRICE * numberOfDays;
      }
      return finalPrice;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // 
   /**
    * Ordinary equals method for reservation
    */
   
   public boolean equals(Object obj)
   {
      if ( obj instanceof Reservation)
      {
         Reservation thisRes = (Reservation) obj;
         
         if ( thisRes.finalPrice == finalPrice)
         {
            return true;
         }
         else return false;
      }
      else return false;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *

 /**
  * Ordinary toString method
  */

    public String toString()
    {
        return customer.toString() + vehicle.toString() +
                dateInterval.nowStartDateToString() + dateInterval.nowEndDateToString() + calculatePrice();
    }
   
   
}
