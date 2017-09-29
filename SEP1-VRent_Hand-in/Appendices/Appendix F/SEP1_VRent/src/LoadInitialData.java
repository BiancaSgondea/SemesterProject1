
import java.io.FileNotFoundException;
import java.io.IOException;


public class LoadInitialData
{
 
   public static void main(String[] args)
   {
      ReservationList cars = new ReservationList();
  
      MyTextFileIO mtfio = new MyTextFileIO();
      String[] carArray = null;
      
      try
      {
         carArray = mtfio.readArrayFromFile("cars.txt");
                     
        
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found, or could not be opened");
      }
    
      MyFileIO mfio = new MyFileIO();
      
      try
      {
         mfio.writeToFile("Reservations.bin", cars);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Error opening file ");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file ");
      }
      
      System.out.println("Done");
   }

}