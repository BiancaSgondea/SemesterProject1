
import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author Group 2 [ ]
 *
 */
public class ReservationList implements Serializable
{

   private ArrayList<Reservation> reservations;
   
   // 
   /**
    * We add the provided reservation on the first null space in the reservations list
    * @param reservation Specific Reservation object that we want to add to the list
    */
   public ReservationList()
   {
      reservations = new ArrayList<>();
   }
   /**
    * 
    * @return size of the reservation list array
    */
   public int size(){return reservations.size();}
   
   /**
    * When provided with licensNummer we can find the specific reservation
    * @param licenseNumber of the Customer
    * @return seeked reservation
    */
   public int indexOfCustomer(String licenseNumber)
   {
      for(int i =0;i<reservations.size();i++){
         
         if((licenseNumber.equals(reservations.get(i).getCustomerNumber()))){
            
            return i;
         }
      }
      return -1;
   }
   
   public void addReservation(Reservation reservation)
   {
         if (indexOfCustomer(reservation.getCustomerNumber())==-1){
            reservations.add(reservation);
      }
   }
   
   public void deleteReservation(Reservation reservation)
   {
     if (indexOfCustomer(reservation.getCustomerNumber())!=-1){
        reservations.remove(reservation);
      }
     
   }
   // * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   //  
   /**
    * Finds the specific reservation on the list ( in case everything goes south we get -1 as a return value to signalize that something is not right
    * @param customer The Customer object we are searching for in the list
    * @return If the provided customer is found in the list, its position in the array is returned
    */
   public int findReservation(Customer customer)
   {
      for ( int i = 0; i < reservations.size(); i++ ) 
      {
         if(reservations.get(i).customerEquals(customer)){
            return i;
         }
      } 
      return -1;
   }
   
   public Reservation getReservations(int index)
   {
      return reservations.get(index);
   }
   
   // * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // 
   // 
   // 
   /**
    * We input the licence, and for which reservation it is in the method
    * Then the method finds at which spot in the list is the specific customer object
    * And lastly it sets that customers object licence field to the given String by calling the method "licenceInputer"
    * @param licence Drivers licence that needs to be inputed
    * @param customer This object is the customer that is providing the licence number
    */
   public void inputDriversLicence( String licence, Customer customer)
   {
      int position = findReservation(customer);
    
      reservations.get(position).licenceInputer(licence);
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   
   /**
    *  This method returns the Reservation object if we know the customer details
    * @param customer The customer we are searching for
    * @return Return the specific reservation in which is the customer found
    */
   public Reservation reservationReturner(Customer customer)
   {
      int position = findReservation(customer);
      return reservations.get(position);
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *

   /**
    * Prints out information regarding reservations
    */
   public String toString() {
      String rtStr = "";
      
      for(int i = 0; i<reservations.size();i++){
         rtStr += reservations.get(i)+"\n ";
      }
   return rtStr;
   }
   
   
}
