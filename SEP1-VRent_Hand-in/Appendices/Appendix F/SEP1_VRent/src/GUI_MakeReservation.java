import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_MakeReservation extends JPanel {
    FileAdapterVehicleList adapter = new FileAdapterVehicleList("cars.bin");
    ReservationFileAdapter adapterR = new ReservationFileAdapter("Reservations.bin");
    GUI_PINFO newPinfo ;


    private Vehicle vehicle;

    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
    private JButton button1, button2;
    private JLabel label1, label2, label3;
    private JTextField field1, field2, field3, field4, field5, field6;
    private JList<Vehicle> list;

;

    private JRadioButton carRadioButton;
    private JRadioButton camperRadioButton;
    private JRadioButton truckRadioButton;
    private JRadioButton vanRadioButton;
    private ButtonGroup vehicleType;

    public GUI_MakeReservation(GUI_PINFO pinfo) {
        newPinfo = pinfo;

        panel1 = new JPanel(new FlowLayout());
        label1 = new JLabel("*Pick up date:");
        field1 = new JTextField(3);
        field3 = new JTextField(3);
        field4 = new JTextField(3);
        panel1.add(label1);
        panel1.add(field1);
        panel1.add(field3);
        panel1.add(field4);

        panel2 = new JPanel(new FlowLayout());
        label2 = new JLabel("*Returning date:");
        field2 = new JTextField(3);
        field5 = new JTextField(3);
        field6 = new JTextField(3);
        panel2.add(label2);
        panel2.add(field2);
        panel2.add(field5);
        panel2.add(field6);

        panel3 = new JPanel(new GridLayout(3, 1));

        panel3.add(panel1);
        panel3.add(panel2);

        panel4 = new JPanel(new GridLayout(5, 1));
        label3 = new JLabel("Vehicle type");
        vehicleType = new ButtonGroup();
        carRadioButton = new JRadioButton("Car", true);
        camperRadioButton = new JRadioButton("Camper");
        truckRadioButton = new JRadioButton("Truck");
        vanRadioButton = new JRadioButton("Van");
        vehicleType.add(carRadioButton);
        vehicleType.add(camperRadioButton);
        vehicleType.add(truckRadioButton);
        vehicleType.add(vanRadioButton);
        panel4.add(label3);
        panel4.add(carRadioButton);
        panel4.add(camperRadioButton);
        panel4.add(truckRadioButton);
        panel4.add(vanRadioButton);

        panel7 = new JPanel(new BorderLayout(0, 5));
        list = new JList<>();
        list.setVisibleRowCount(7);
        list.setFixedCellWidth(200);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        JScrollPane js = new JScrollPane(list);
        button1 = new JButton("Save reservation");
        button2 = new JButton("Update the upper list");
        panel7.add(js, BorderLayout.NORTH);

        panel7.add(button1, BorderLayout.SOUTH);
        panel7.add(button2);

        panel5 = new JPanel(new BorderLayout(20, 0));
        panel5.add(panel3, BorderLayout.WEST);
        panel5.add(panel4, BorderLayout.CENTER);
        panel5.add(panel7, BorderLayout.EAST);

        panel6 = new JPanel();
        panel6.add(panel5);
        add(panel6);
        registerHandlers();
    }

    private void registerHandlers() {
        ButtonHandler handler = new ButtonHandler();
        button1.addActionListener(handler);
        button2.addActionListener(handler);

    }

    public void addVechicleList(VehicleList list2) {

        DefaultListModel<Vehicle> lm = new DefaultListModel<>();

        for (int i = 0; i < list2.size(); i++) {
            lm.addElement(list2.getVehicle(i));
        }
        list.setModel(lm);
    }


    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            VehicleList list1 = adapter.getVehicleList();

            if (e.getSource().equals(button2) && carRadioButton.isSelected()) {
                for (int i = 0; i < list1.size(); i++) {
                    addVechicleList(list1.carList());
                }
            } else if (e.getSource().equals(button2) && camperRadioButton.isSelected()) {
                for (int i = 0; i < list1.size(); i++) {
                    addVechicleList(list1.camperList());
                }
            } else if (e.getSource().equals(button2) && truckRadioButton.isSelected()) {
                for (int i = 0; i < list1.size(); i++) {
                    addVechicleList(list1.truckList());
                }
            } else if (e.getSource().equals(button2) && vanRadioButton.isSelected()) {
                for (int i = 0; i < list1.size(); i++) {
                    addVechicleList(list1.vanList());
                }
            }

            if (e.getSource().equals(button1)) {


                if (!(field1.getText().equals(""))
                        && !(field3.getText().equals(""))
                        && !(field4.getText().equals(""))
                        && !(field2.getText().equals(""))
                        && !(field5.getText().equals(""))
                        && !(field6.getText().equals(""))) {


                    MyDate newDate = new MyDate(Integer.parseInt(field1.getText()), Integer.parseInt(field3.getText()),
                            Integer.parseInt(field4.getText()), Integer.parseInt(field2.getText()),
                            Integer.parseInt(field5.getText()), Integer.parseInt(field6.getText()));


                    IntervalList newDateList = new IntervalList();

                    if (newPinfo.getCustomer()!=null ) {


                        Reservation newReservation = new Reservation(newPinfo.getCustomer(), list.getSelectedValue(), newDate);

                        ReservationList newReservationList = adapterR.getReservationList();

                        newReservationList.addReservation(newReservation);

                        adapterR.addReservationList(newReservationList);

                        JOptionPane.showMessageDialog(null, "Reservation saved");
                    }


                } else {
                    JOptionPane.showMessageDialog(null,
                            "Insert information in all fields (*)",
                            "Insert information", JOptionPane.ERROR_MESSAGE);
                }
            }

            setSize(800, 250);
            setVisible(true);

        }
        //
        // if(e.getSource().equals(button2))
        // {
        //
        //
        //
        // else
        // {
        // JOptionPane.showMessageDialog(null,
        // "Insert information in all fields (*)",
        // "Insert information", JOptionPane.ERROR_MESSAGE);
        // }
        // }
    }
}
