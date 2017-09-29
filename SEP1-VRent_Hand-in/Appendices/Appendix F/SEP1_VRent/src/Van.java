
public class Van extends Vehicle
{

   // As usual, special field for this class as well
   
   private int loadSize;
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   /**
    * Constructor that sets all fields to some values
    * @param mileage
    * @param loadSize
    * @param make
    * @param model
    */
   public Van(int mileage, int loadSize, String make, String model)
   {
      // Again, we have to use the super constructor since this is a subclass
      
      super(mileage, make, model);
      this.loadSize = loadSize;
      
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // get method for the loadSize field, self explanatory
   /**
    * 
    * @return loadSize value
    */
   public int getLoadSize()
   {
      return loadSize;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // We need a to string method so we can easily export or the vehicle info to a file || Note : 19.05.2016 : Or maybe we don't, since we will be using binaries 
   
   public String toString()
   {
      return super.toString() +"  " + loadSize;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
}
