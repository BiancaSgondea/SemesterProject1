
import java.io.Serializable;
import java.util.ArrayList;
public class IntervalList implements Serializable
{

   private ArrayList<MyDate>dates ;
   
 
   
   /**
    * We search for a free space and input the reservation in the array
    * @param date object of MyDate class that is supposed to be added to list
    */
   public void addReservation(MyDate date)
   {
      for(int i=0; i < dates.size() ; i++)
      {
         date = dates.get(i);
      }
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * 
   
    
   /**
    * The specific date is deleted from the list of reservations for a specific vehicle
    * @param date
    */
   public void deleteReservation(MyDate date)
   {
      dates.remove(date);
   }
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * 
   
    
   /**
    * This method checks if potential reservation/booking date overlaps with already existing one
   // We must pay attention to potential null fields in the array of myDate objects, thats why we first check it
   
   // There are 2 settings in which the method returns true :
   // 1) The whole list of reservations/bookings is null ( there are no reservations for a specific vehicle )
   // 2) The list is not null and the given date is before/after a reserved date/dates
    * @param date given date that is being compared to already existing dates in an array
    * @return a true or false, depending if some of the dates overlap 
    */
   public boolean freeDate(MyDate date)
   {
      boolean returnValue = true;
      for(int i=0; i<dates.size(); i++)
      { 
         if(!(date.isBefore(dates.get(i)) || date.isAfter(dates.get(i))))
         {
              returnValue = false;
         }  
      }
      return returnValue;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * 
   
   // We need a copy method in order to make every list unique for every vehicle || Actually we do not need this...
   /**
    * Copy method
    * @return new IntervalList object with same parameters 
    */
   public IntervalList copy()
   {
      return new IntervalList();
   }
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * 
   
   
   /**
    * // Method that prints all the reserved dates for a specific vehicle ( again we pay attention to null fields )
    */
   public void printReservations()
   {
      for(int i=0; i < dates.size(); i++)
      {
            System.out.println(dates.get(i));
         
      }
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
}
