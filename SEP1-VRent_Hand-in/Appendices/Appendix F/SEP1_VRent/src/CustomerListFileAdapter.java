import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class CustomerListFileAdapter implements Serializable {

    private MyFileIO mfio;
    private String fileName;

/**
 * Constructor
 * @param fileName String that designates the name of the file
 */
    public CustomerListFileAdapter(String fileName){

        mfio = new MyFileIO();
        this.fileName = fileName;
    }

    /**
     * Method that returns all customers in form of a customerList
     * @return an CustomerList object
     */
    public CustomerList getAllCustomers(){

        CustomerList customerList = new CustomerList();

        try{
            customerList = (CustomerList) mfio.readObjectFromFile(fileName);
        }
        catch (FileNotFoundException e){
            System.out.println("File not Found");
        }
        catch(IOException e){
            System.out.println("IO ERROR reading file1");
        }
        catch (ClassNotFoundException e){
            System.out.println("Class Not Found");
        }
        return customerList;
    }

    /**
     * Method that adds a customer to the file
     * @param Customer that is suppoused to be added to the file
     */
    public void addCustumer(Customer Customer)
    {
        CustomerList CustomerList = getAllCustomers();

        CustomerList.addCustomer(Customer);

        try
        {
            mfio.writeToFile(fileName, CustomerList);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("IO Error reading file2");
        }
    }

    /**
     * Method that adds multiple customers
     * @param CustomerList
     */
    public void addCustomers(CustomerList CustomerList) {

        try {
            mfio.writeToFile(fileName, CustomerList);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error reading file3");
        }

    }

    /**
     * Method that deletes a specific customer from a file
     * @param customer object
     */
    public void deleteCustomerByNumber(Customer customer)
    {
        CustomerList CustomerList= getAllCustomers();

        CustomerList.deleteCustomer(customer);

        try
        {
            mfio.writeToFile(fileName, CustomerList);
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

    /**
     * Method that returns a customer object if it exsits in a file
     * @param name of a customer
     * @return object of Customer class
     */
    public Customer getCustomerByName(String name){
        Customer customer1;

        CustomerList customerList = getAllCustomers();

        customer1 = customerList.findByLastName(name);

        try
        {
            mfio.writeToFile(fileName, customerList);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("IO Error reading file4");
        }
        return customer1;
    }



}