
public class Camper extends Vehicle
{
   // Special field for this one too ? . . . Huh ..
   
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private int capacity;
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // Let me guess, this is a constructor ?
   /**
    * 
    * @param mileage Inputed value, mileage of the vehicle
    * @param capacity integer representing vehicles person capacity
    * @param make What make it is
    * @param model What model it is
    */
   
   public Camper(int mileage, int capacity, String make, String model)
   {
      // Hmmm "super" is also a constructor ?
      super(mileage, make, model);
      this.capacity = capacity;
      
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // Heh, this one is easy. A get method for the capacity obviously.
   /**
    * Method for returning capacity value
    * @return stored capacity value
    */
   public int getCapacity()
   {
      return capacity;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // Needed for the file stuff I guess ?
   /**
    * Simple toString method 
    */
   public String toString()
   {
      return super.toString() + "  " + capacity + " kg";
   }

   // 5 points for Grifindor ! Ups, wrong program. 
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
}
