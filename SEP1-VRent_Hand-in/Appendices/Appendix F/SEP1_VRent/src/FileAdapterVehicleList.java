
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class FileAdapterVehicleList implements Serializable
{
    private MyFileIO mfio;
    private String fileName;


    /**
     * Constructor
     * @param fileName designated file name on which the certain operations will be initiated
     */
    public FileAdapterVehicleList(String fileName)
    {

        mfio = new MyFileIO();
        this.fileName = fileName;
    }

    /**
     * Method that returns a vehicle list ( complete one )
     * @return object of VehicleList class is returned for use
     */
    public VehicleList getVehicleList()
    {
        VehicleList vehicleList = new VehicleList();
        
        try{
            vehicleList = (VehicleList) mfio.readObjectFromFile(fileName);
        }
        catch (FileNotFoundException e){
            System.out.println("File not Found");
        }
        catch(IOException e){
              
            System.out.println("IO ERROR reading file");
            
        }
        catch (ClassNotFoundException e){
            System.out.println("Class Not Found");
        }
        return vehicleList;
    }
    
    /**
     * Method that adds a vehicle to the file
     * @param vehicle object
     */
    public void addVehicle(Vehicle vehicle)
    {
       VehicleList vehicleList = getVehicleList();
       
       vehicleList.addVehicle(vehicle);
      
        try
        {
            mfio.writeToFile(fileName, vehicleList);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("IO Error reading file");
        }
    }

    /**
     * we add multiple vehicles with this method
     * @param vehicleList
     */
    public void addVehicleList(VehicleList vehicleList)
    {
        try
        {
            mfio.writeToFile(fileName, vehicleList);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("IO Error reading file");
        }
    }

    /**
     * Method for deleting object in the file
     * @param vehicle
     */
    public void deleteVehicle(Vehicle vehicle)
    {
        VehicleList vehicleList = getVehicleList();

       vehicleList.deleteVehicle(vehicle);

        try
        {
            mfio.writeToFile(fileName, vehicleList);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("IO Error reading file4");
        }
    }



}