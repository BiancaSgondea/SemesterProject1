
public class Car extends Vehicle
{

   /* The car has its own special field, the model
      
   private String model;      <------ This part has become obsolete with Bianca's request
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
      Simple constructor
   */ 
   /**
    * Constructor that sets all fields to given ones in the parameter section
    * @param mileage
    * @param model
    * @param make
    */
   public Car(int mileage, String model, String make)
   {
      // We have to use the super constructor since the Class Car extends Vehicle Class ( it is its subclass)
      
      super(mileage, make, model);
      
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // And as usual we have a get method for the Car's special field
   /*
   public String getModel()      <------ This part has become obsolete with Bianca's request
   {
      return model;
   }
   */
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // We need a to string method so we can easily export or the vehicle info to a file
   /**
    * toString method, prints all information for the vehicle
    */
   public String toString()
   {
      return super.toString();
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
}
