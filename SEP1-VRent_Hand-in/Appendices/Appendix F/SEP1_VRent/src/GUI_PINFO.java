import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_PINFO extends JPanel {

    public CustomerListFileAdapter cfa = new CustomerListFileAdapter("Customers.bin");
    Customer customer;
    CustomerList customerList = cfa.getAllCustomers();
    String lastname;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel8, panel9, panel10, panel11, panel12, panel13, panel14, panel15;
    private JButton button2;
    private JLabel label1, label2, label3, label4, label5, label6, label8, label9, label10, label11;
    private JTextField field2, field3, field4, field5, field6, field9, field10, field11;

    private GUI_Frame parent;

    public GUI_PINFO(GUI_Frame parent) {

        this.parent= parent;
        setLayout(new FlowLayout(FlowLayout.LEFT));

        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        label1 = new JLabel("Personal information:");
        label1.setPreferredSize(new Dimension(130, 20));
        panel1.add(label1);
        add(panel1);

        panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        label2 = new JLabel("*First Name:");
        label2.setPreferredSize(new Dimension(70, 20));
        panel2.add(label2);
        field2 = new JTextField(7);
        panel2.add(field2);
        add(panel2);

        panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label3 = new JLabel("*Last Name:");
        label3.setPreferredSize(new Dimension(70, 20));
        panel3.add(label3);
        field3 = new JTextField(7);
        panel3.add(field3);
        add(panel3);

        panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label4 = new JLabel("*Phone no.:");
        label4.setPreferredSize(new Dimension(70, 20));
        panel4.add(label4);
        field4 = new JTextField(6);
        panel4.add(field4);
        add(panel4);

        panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label5 = new JLabel("*Adress:");
        label5.setPreferredSize(new Dimension(70, 20));
        panel5.add(label5);
        field5 = new JTextField(10);
        panel5.add(field5);
        add(panel5);

        panel13 = new JPanel(new GridLayout(7, 1));
        panel13.add(panel1);
        panel13.add(panel2);
        panel13.add(panel3);
        panel13.add(panel4);
        panel13.add(panel5);

        add(panel13);

        panel8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label8 = new JLabel("Renting information:");
        label8.setPreferredSize(new Dimension(240, 20));
        panel8.add(label8);
        add(panel8);

        panel9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label9 = new JLabel("*Pick-up location:");
        label9.setPreferredSize(new Dimension(100, 20));
        panel9.add(label9);
        field9 = new JTextField(7);
        panel9.add(field9);
        add(panel9);

        panel10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label10 = new JLabel("*Delivery location:");
        label10.setPreferredSize(new Dimension(100, 20));
        panel10.add(label10);
        field10 = new JTextField(7);
        panel10.add(field10);
        add(panel10);

        panel11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label11 = new JLabel(" Driving license:");
        label11.setPreferredSize(new Dimension(100, 20));
        panel11.add(label11);
        field11 = new JTextField(10);
        panel11.add(field11);
        add(panel11);


        panel9.setPreferredSize(new Dimension(240, 30));
        panel10.setPreferredSize(new Dimension(240, 30));
        panel11.setPreferredSize(new Dimension(240, 30));


        panel14 = new JPanel(new GridLayout(5, 1));
        panel14.add(panel8);
        panel14.add(panel9);
        panel14.add(panel10);
        panel14.add(panel11);

        add(panel14);

        panel15 = new JPanel(new GridLayout(1, 2));
        panel15.add(panel13);
        panel15.add(panel14);
        add(panel15);


        button2 = new JButton("Next");
        panel13.add(button2);
        add(panel15);
        registerHandlers();
        setSize(500, 300);
        setVisible(true);

    }

    private void registerHandlers() {
        ButtonHandler handler = new ButtonHandler();
        button2.addActionListener(handler);
    }


    public Customer makeCustomer() {

        customer = new Customer(field2.getText(), field3.getText(), field5.getText(), field4.getText(), field10.getText());


        System.out.println(customer);
        return customer;

    }

    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(button2)) {
                if (!(field2.getText().equals("")) && !(field3.getText().equals("")) && !(field4.getText().equals(""))
                        && !(field5.getText().equals("")) && !(field9.getText().equals("")) && !(field10.getText().equals(""))) {

                    customerList.addCustomer(makeCustomer());

                    cfa.addCustomers(customerList);
                    customerList = cfa.getAllCustomers();
                    lastname = field3.getText();

                    parent.getTabbedPane().setSelectedIndex(2);

                } else {
                    JOptionPane.showMessageDialog(null, "Insert information in all fields (*)",
                            "Insert information", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public Customer getCustomer() {

        return customerList.findByLastName(lastname);
    }
}

   

