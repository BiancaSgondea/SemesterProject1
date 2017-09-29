
public class Truck extends Vehicle
{

   // There are enough comments for previous classes, --#same#--
   private int loadSize;
   
   /**
    * Constructor method that sets all the fields to some values
    * @param mileage
    * @param loadSize
    * @param make
    * @param model
    */
   public Truck(int mileage, int loadSize, String make, String model)
   {
      super(mileage, make, model);
      this.loadSize = loadSize;
   }
   /**
    * Simple get method
    * @return the loadSize value of the vehicle
    */
   public int getLoadSize()
   {
      return loadSize;
   }
   /**
    * Simple toString method
    */
   public String toString()
   {
      return super.toString() +"  "+ loadSize;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
}
