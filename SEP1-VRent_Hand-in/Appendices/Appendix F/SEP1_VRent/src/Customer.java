
import java.io.Serializable;
/**
 * 
 * @author Nikola Sevo :)
 * 
 * Class which holds information regarding specific customer
 *
 */
public class Customer implements Serializable
{
   /**  
    * 
    * Fields that our dear customer object will have ( driversLicence is set to null, just to be extra sure for the initial parameter )
    * 
    */
   
   private String firstName;
   private String lastName;
   private String address;
   private String phoneNo;
   private String driversLicence;
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
     
   
 
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   /**
    * And this one (constructor) is for booking ( in vase we are immediately handing out the vehicle to the customer )
    * In this case customer provides the driversLicence no. immediately
    * 
    * @param firstName Customers first name
    * @param lastName Customers last name
    * @param address Customers address
    * @param phoneNo Customers phone number
    * @param driversLicence Customers driving licence
    */ 
   
   public Customer(String firstName, String lastName,   String address,   String phoneNo, String driversLicence)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.address = address;
      this.phoneNo = phoneNo;
      this.driversLicence = driversLicence;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   /**
    * Simple get methods for the field in case we need them in the future
    * 
    * @return Customers first name
    */  
   
   public String getFirstName()
   {
      return firstName;
   }
   /**
    * Simple get methods for the field in case we need them in the future
    * 
    * @return Customers last name
    */
   public String getLastName()
   {
      return lastName;
   }
   /**
    * Method that returns customer full name
    * @return String that is made out of merging 2 class fields
    */
   public String getFullName()
   {
      return firstName + "  " + lastName;
   }
   
   
   /**
    * Simple get methods for the field in case we need them in the future
    * 
    * @return Customers address
    */
   public String getAddress()
   {
      return address;
   }
   /**
    * Simple get methods for the field in case we need them in the future
    * 
    * @return Customers phone number
    */
   public String getPhoneNo()
   {
      return phoneNo;
   }
   
   /**
    * Simple get methods for the field in case we need them in the future
    * 
    * @return Customers driving licence
    */
   public String getDriversLicence()
   {
      
      return driversLicence;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
     
   /**
    * A wild set method appears ( obviously we need this one [ not always will the booking constructor be used ] )
    * 
    * @param licence Customers driving licence that will be inserted in the Customer object
    */
   public void setDriversLicence(String licence)
   {
      driversLicence = licence;
   }
   
   
   
   
   
   
   /**
    * Method that compares the given object with another one, and chekcs if they are the same 
    */
   public boolean equals(Object obj)
   {
      if(!(obj instanceof Customer)){
         return false;
      }
      Customer other = (Customer) obj;
      return firstName.equals(other.firstName) && lastName.equals(other.lastName) && address.equals(other.address) && 
            phoneNo.equals(other.phoneNo) && driversLicence.equals(other.driversLicence); 
      
   }
   
   
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   //  A regular toString method for printing out the Customer info.
   /**
    * Regular toString method
    */
   public String toString()
   {
       return "\n"+firstName + "  " +  lastName + " Phone No. "   +phoneNo;
   }
/**
 * To string method for gui purposes
 * @return String value with all customer information
 */
   public String toStringGUI(){
       if ( driversLicence == null )
       {
           return "\n"+ firstName + "\n" +  lastName + "\n" + address + "\n" + "*"+phoneNo+"\n";
       }

       else return "\n"+firstName + "\n" +  lastName + "\n" + address + "\n" + phoneNo + "\n" + driversLicence+"\n";

   }

   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *

}
