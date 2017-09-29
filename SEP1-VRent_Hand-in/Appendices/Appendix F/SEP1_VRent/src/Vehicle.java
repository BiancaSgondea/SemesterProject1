
import java.io.Serializable;

public class Vehicle implements Serializable
{

   // We have 2 basic fields, mileage - how many kilometers has a certain vehicle drove 
   // and we have vehicleChecked which represents has a certain vehicle been taken for repair check
   // Available is for the availability of the vehicle, if its true then the car is available
   private int mileage;
   private boolean vehicleChecked;
   private boolean available;
   // mileageChecker holds the number of kilometers that have been driven after last check
   private int mileageChecker;
   // ReservationList holds a list of MyDate objects and few methods for array manipulation 
   private IntervalList list;
   
   // Standard constructor, Note : vehicleChecked is always set to true when we add a new vehicle, 
   //                                           since we consider that it has been checked prior to being added to the list 
   
   /* Who would not check a vehicle before making it available ?
      We need to take a car after every 20k km to repairs, thats why we are reseting the mileageChecker counter
      Added 2 more fields on Bianca's request, now I need to modify the constructor and to remove model field from Car class
                                 Ty Bee :3
   */
   private String make;
   private String model;
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   /**
    * Constructor method
    * @param mileage
    * @param make
    * @param model
    */
   public Vehicle(int mileage,String make, String model)
   {
      this.make = make;
      this.model = model;
      this.mileage = mileage;
      vehicleChecked = true;
      available = true;
      mileageChecker = mileage % 20000;
      list = new IntervalList();
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   //Simple get methods for 3 fields, we will need them later in GUI stuff
   public boolean getStatus()
   {
      return vehicleChecked;
   }
   
   public boolean getAvailability()
   {
      return available;
   }
   
   public int getMileage()
   {
      return mileage;
   }
   
   public int getMileageChecker()
   {
      return mileageChecker;
   }
   public void setMileage(int mileage)
   {
      this.mileage = mileage;
   }
   
   
   public boolean checkAvaliability(MyDate date)
   {
      return list.freeDate(date);

   }
   
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   
   /**
    * // When the customer returns the car, we need to update the information on the mileage ( thus the reason for the method )
    * @param plus
    */
   public void addMileage(int plus)
   {
      mileage += plus;
      mileageChecker += plus;
      
      if ( mileageChecker >= 20000 )
      {
         mileageChecker %= 20000;
         statusFalse();
      }
   }
   
   public String getModel(){
      return model;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // Set methods for the repair status of the vehicle 
   public void statusFalse()
   {
      vehicleChecked = false;
   }
   
   public void statusTrue()
   {
      vehicleChecked = true;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // Setter methods for available field ( if someone rents/reserves the car we will obv. call the first method for the given object )
  
  
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   
   
   /**
    * // This is one of chain linking methods that inserts the MyDate object into another method if there is no overlaping of dates in the list
   
   // Effectively it does this :
   // 1) Check if the given date overlaps with any of the dates in the list
   // 2) If it doesn't add the date to the list
    * @param insertDate
    */
   public void insertedDate(MyDate insertDate)
   {
      if (list.freeDate(insertDate))
      {
         list.addReservation(insertDate);
      }
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
  
   
   /**
    *  // Simple method that prints all reserved dates for a specific vehicle 
    */
   public void printDates()
   {
      list.printReservations();
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   
   /**
    * // Method that deletes a specific date from the list
    * @param date desired date object for deletion
    */
   
   public void deleteDate(MyDate date)
   {
      list.deleteReservation(date);
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // Regular equals method that checks if 2 vehicles are the same
   
   public boolean equals(Object obj)
   {
      if ( obj instanceof Vehicle)
      {
         Vehicle vehi = (Vehicle)obj;
         
         if (vehi.make.equals(make) && vehi.model.equals(model) && vehi.mileage == mileage)
         {
            return true;
         }
         else return false;
      }
      else return false;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // Simple toString method used for printing out the information
   
   public String toString()
   {
      return make + "  " + model+"  "+ mileage+"km" +"\n";
      //+ "Condition: "+vehicleChecked + "\n" + "Availability: "+available + "\n" ;
   }
   
   public String toStringGUI()
   {
      return make+ "  " +model ;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
}
