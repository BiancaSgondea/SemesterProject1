import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

/**
 * 
 */
public class ReservationFileAdapter implements Serializable{


    private MyFileIO mfio;
    private String fileName;

    public ReservationFileAdapter(String fileName){

        mfio = new MyFileIO();
        this.fileName = fileName;
    }

    public ReservationList getReservationList(){

        ReservationList reservationList= new ReservationList();

        try{
            reservationList = (ReservationList) mfio.readObjectFromFile(fileName);
        }
        catch (FileNotFoundException e){
            System.out.println("File not Found");
        }
        catch(IOException e){
            System.out.println("IO ERROR reading file");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            System.out.println("Class Not Found");
        }
        return reservationList;
    }

    /**
     * Adding reservation to the file
     * @param reservation desired reservation
     */
    public void addReservation(Reservation reservation)
    {
        ReservationList list= getReservationList();

        list.addReservation(reservation);

        try
        {
            mfio.writeToFile(fileName, list);
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
     * For adding multiple reservations to the file
     * @param ReservationList
     */
    public void addReservationList(ReservationList ReservationList) {

        try {
            mfio.writeToFile(fileName, ReservationList);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error reading file");
        }

    }

    /**
     * Method that searches the file for a specific customer
     * @param customer object that is compared to other customers in the file
     */
    public void findCustomer(Customer customer){
        ReservationList reservation = new ReservationList();

        reservation.findReservation(customer);

        try
        {
            mfio.writeToFile(fileName, reservation);
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
     * Method that completes the reservation by imputting missing info
     * @param license
     * @param customer
     */
    public void completeReservation(String license, Customer customer){
        ReservationList reservation = new ReservationList();

        reservation.inputDriversLicence(license,customer);
        try
        {
            mfio.writeToFile(fileName, reservation);
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
     * Get reservation method
     * @param customer that is used to search for a reservation containing that object 
     * @return Reservation object if found
     */
    public Reservation getReservetion(Customer customer){

        ReservationList ReservationList = new ReservationList();

        try
        {
            mfio.writeToFile(fileName, ReservationList);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("IO Error reading file");
        }
        return ReservationList.reservationReturner(customer);
    }

    /**
     * Method that deletes the specific reservation
     * @param reservation
     */
    public void deleteReservation(Reservation reservation)
    {
        ReservationList reservationList = getReservationList();

       reservationList.deleteReservation(reservation);

        try
        {
            mfio.writeToFile(fileName, reservationList);
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