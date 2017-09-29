import java.io.Serializable;
import java.util.ArrayList;

public class VehicleList implements Serializable
{
   // This is a class that has an array in which we can find all the company's
   // vehicles

   private ArrayList<Vehicle> vehicleList;

   // Method adds a inputed vehicle to the list, by searching for the first free
   // ( null ) space in the array
   /**
    * Constructor that creates the array in which vehicles will be stored
    */
   public VehicleList()
   {
      vehicleList = new ArrayList<>();
   }

   /**
    * 
    * @return size of the array
    */
  public int size(){return vehicleList.size();}
  
  /**
   * 
   * @param model of a vehicle
   * @return position of the vehicle in the array
   */
   public int indexOfModel(String model)
   {
      for(int i =0;i<vehicleList.size();i++){
         
         if((model.equals(vehicleList.get(i).getModel()))){
            return i;
         }
      }
      return -1;
   }
   /**
    * 
    * @param index is a designated position of a vehicle in an array
    * @return the searched vehicle
    */
   public Vehicle getVehicle(int index){
      
      return vehicleList.get(index);  
      }
   
   /**
    * Adds vehicle object to the array
    * @param vehicle
    */
   public void addVehicle(Vehicle vehicle)
   {
         if (indexOfModel(vehicle.getModel())==-1){
            vehicleList.add(vehicle);
      }
   }

   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * -
   // * - * - * - * - *

   

   /**
    * // This method searches for a specific vehicle, and if finds it "deletes" it
   // ( sets the array field to null )
    * @param vehicle
    */
   public void deleteVehicle(Vehicle vehicle)
   {
     if (indexOfModel(vehicle.getModel())!=-1){
        vehicleList.remove(vehicle);
      }
   }

   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * -
   // * - * - * - * - *

   /*
    * Next four methods return a list of specific vehicles ( they return a
    * specific type of vehicles) Example : 1) We want to get a list of only car
    * vehicles, so we call carList method 2) New local VehicleList called list
    * is created 3) We go trough the existing VehicleList ( where all vehicle
    * types are mixed ) 4) If we find that vehicle is of car type we add it to
    * the local list by calling a method for adding vehicles 5) And when we go
    * trough the whole list, we return the car only list
    */
   public VehicleList carList()
   {
      VehicleList list = new VehicleList();

      for (int i = 0; i < vehicleList.size(); i++)
      {
         if (vehicleList.get(i) instanceof Car)
         {
            list.addVehicle(vehicleList.get(i));
         }
      }
      return list;
   }

   public VehicleList vanList()
   {
      VehicleList list = new VehicleList();

      for (int i = 0; i < vehicleList.size(); i++)
      {
         if (vehicleList.get(i) instanceof Van)
         {
            list.addVehicle(vehicleList.get(i));
         }
      }
      return list;
   }

   public VehicleList camperList()
   {
      VehicleList list = new VehicleList();

      for (int i = 0; i < vehicleList.size(); i++)
      {
         if (vehicleList.get(i) instanceof Camper)
         {
            list.addVehicle(vehicleList.get(i));
         }
      }
      return list;
   }

   public VehicleList truckList()
   {
      VehicleList list = new VehicleList();

      for (int i = 0; i < vehicleList.size(); i++)
      {
         if (vehicleList.get(i) instanceof Truck)
         {
            list.addVehicle(vehicleList.get(i));
         }
      }
      return list;
   }

   public String toString(){
      String str="";
      
      for(int i =0; i<vehicleList.size();i++){
         str +=vehicleList.get(i)+"\n";
      }
      return str;
   }
   
   public String toStringGUI(){
      String str="";
      
      for(int i =0; i<vehicleList.size();i++){
         str +=vehicleList.get(i).toStringGUI()+"\n";
      }
      return str;
   }

   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * -
   // * - * - * - * - *

   /**
    * When provided with the info for the vehicle this method prints information only regarding that object
    * @param position of the searched vehicle
    */
   public void printVehicleInfo(int position)
   {
      vehicleList.get(position).toString();
   }
}
