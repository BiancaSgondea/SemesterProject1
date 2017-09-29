
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * 
 * @author Group 2
 *Class that is responsible for managing input and output streams (used for saving objects to files)
 */
public class MyFileIO
{
    
   /**
    * 
    * @param fileName is name of the file in which the object will be saved
    * @param obj the given object
    * @throws FileNotFoundException Possible exception, file does not exist
    * @throws IOException
    * Writes the given object to a file with the given file name
    */
   public void writeToFile(String fileName, Object obj) throws FileNotFoundException, IOException
   {
      ObjectOutputStream writeToFile = null;
        
      try
      {
         FileOutputStream fileOutStream = new FileOutputStream(fileName);
         writeToFile = new ObjectOutputStream(fileOutStream);

         writeToFile.writeObject(obj);
      }
      finally
      {
         if (writeToFile != null)
         {
            try
            {
               writeToFile.close();
            }
            catch (IOException e)
            {
               System.out.println("IO Error closing file " + fileName);
            }
         }
      }
   }
  
   
   
    
   /**
    * Reads the first object from the file with the given file name and returns it.
    * Whoever calls the method will need to cast it from type Object to its real type
    * @param fileName name of the file that will be used for reading stored objects
    * @return Saved object is returned
    * @throws FileNotFoundException Trying to operate on a non existing file
    * @throws IOException
    * @throws ClassNotFoundException
    */
   public Object readObjectFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
   {
      Object obj = null;
      ObjectInputStream readFromFile = null;
      try
      {
         FileInputStream fileInStream = new FileInputStream(fileName);
         readFromFile = new ObjectInputStream(fileInStream);
         try
         {
            obj = readFromFile.readObject();
         }
         catch (EOFException eof)
         {
           //Done reading
         }
      }
      finally
      {
         if (readFromFile != null)
         {
            try
            {
               readFromFile.close();
            }
            catch (IOException e)
            {
               System.out.println("IO Error closing file " + fileName);
            }
         }
      }

      return obj;
   }

 }
