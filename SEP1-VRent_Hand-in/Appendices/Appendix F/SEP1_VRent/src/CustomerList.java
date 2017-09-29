
import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author SEP Group 2 [ ]
 *
 */
public class CustomerList implements Serializable
{
   /**
    * Obvs. a list of Customer objects, we need an array to store our dear customers
    */
   
   private ArrayList<Customer> customerList;
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   public CustomerList()
   {
      customerList = new ArrayList<>();
   }
   
   /**
    * 
    * @return the size of the array
    */
   
 public int size(){return customerList.size();}
   
   /**
    * Method that returns the customers position in the array
    * @param licenseNumber Vehicles licence number
    * @return Customers index in the array
    */
   public int indexOfCustomer(String licenseNumber)
   {
      for(int i =0;i<customerList.size();i++){
         if((licenseNumber.equals(customerList.get(i).getDriversLicence()))){   
            return i;
         }
      }
      return -1;
   }
   /**
    * Method that adds the customer object to the array
    * @param customer object
    */
   public void addCustomer(Customer customer)
   {
         if (indexOfCustomer(customer.getDriversLicence())==-1){
            customerList.add(customer);
      }
   }
   
   /**
    * We delete the given object from the array
    * @param customer object
    */
   public void deleteCustomer(Customer customer)
   {
     if (indexOfCustomer(customer.getDriversLicence())!=-1){
        customerList.remove(customer);
      }
     
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // 
   /**
    * A method that finds a specific customer by finding an exact first and last name
    * @param firstName Customers first name
    * @param lastName Customers last name
    * @return If customer with given parameter exist it returns that Customer object 
    */
   public Customer findByLastName(String lastName)
   {

      for (int i=0; i < customerList.size() ; i++)
      {
         if (customerList.get(i).getLastName().equals(lastName)){
            return customerList.get(i);           
         }
      }
      return null;
   }


   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // 
   /**
    * Similar seeker methods, just that this one searches by address
    * @param address Customers address
    * @return If given Customer is found, that object reference is returned 
    */
//   public Customer findByAddress(String address)
//   {
//      for (int i=0; i < list.length ; i++)
//      {
//         
//         if (list[i].getAddress().equals(address))         
//         {
//            return list[i];
//         }
//         
//      }
//      return null;
//   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // 
   /**
    * Same deal, just the phone no. this time
    * @param phoneNo Customers phone number
    * @return If the given customer is found return its reference 
    */
//   public Customer findByPhone(String phoneNo)
//   {
//
//      for (int i=0; i < list.length ; i++)
//      {
//         
//         if (list[i].getPhoneNo().equals(phoneNo))         
//         {
//            return list[i];
//         }
//      }
//      return null;
//   
//   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // 
 
   /**
    * This method calls a toString method for every customer that exists, when there are no more customers break the for loop
    */
   public String toString()
   {
 
         String rtStr = "";
         
         for(int i = 0; i<customerList.size();i++){
            rtStr += customerList.get(i)+"\n ";
         }
      return rtStr;
      }
   

}
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *

