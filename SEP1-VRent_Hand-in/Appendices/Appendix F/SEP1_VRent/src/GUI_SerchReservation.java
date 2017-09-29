import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class GUI_SerchReservation extends JPanel
{

   private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
   private JButton button1, button2, button3;
   private JLabel label1, label2, label3, label4;
   private JTextField field1, field2, field3, field4;
   private JList<Reservation> list;

    private GUI_MakeReservation booking;

  
   public GUI_SerchReservation(GUI_MakeReservation booking)
   {

       this.booking= booking;

      panel1= new JPanel(new GridLayout(2,1));
      label1= new JLabel("First name:");
      field1 = new JTextField(5); 
      panel1.add(label1);
      panel1.add(field1);
      
      panel2= new JPanel(new GridLayout(2,1));
      label2= new JLabel("Last name:");
      field2 = new JTextField(5); 
      panel2.add(label2);
      panel2.add(field2);
      
      panel3= new JPanel(new GridLayout(2,1));
      label3= new JLabel("Address:");
      field3 = new JTextField(5); 
      panel3.add(label3);
      panel3.add(field3);
      
      panel4= new JPanel(new GridLayout(2,1));
      label4= new JLabel("Phone number:");
      field4 = new JTextField(5); 
      panel4.add(label4);
      panel4.add(field4);
      
      
      button1 = new JButton("Search");
      button2 = new JButton("Hand out");
      button3= new JButton("Update reservation list");

      
      panel5= new JPanel();
      list= new JList<>();
      list.setVisibleRowCount(13);
      list.setFixedCellWidth(200);
      list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      list.setLayoutOrientation(JList.VERTICAL);
      JScrollPane js = new JScrollPane(list);
      js.setPreferredSize(new Dimension(400,200));
      panel5.add(js);
      
      panel6= new JPanel (new GridLayout(7,1));
      panel6.add(panel1);
      panel6.add(panel2);
      panel6.add(panel3);
      panel6.add(panel4);
      panel6.add(button1);
      panel6.add(button2);
      panel6.add(button3);
   
      panel7= new JPanel(new GridLayout(1,2));
      panel7.add(panel5);
      panel7.add(panel6);
      

      add(panel7);
      registerHandlers();

      setSize(500, 300);
      setVisible(true);
   }
   
  private void registerHandlers()
  {
     ButtonHandler handler = new ButtonHandler(); 
     
     button1.addActionListener(handler);
     button2.addActionListener(handler);
     button3.addActionListener(handler);
     
     MouseHandler mhandler = new MouseHandler();
     list.addMouseListener(mhandler);
  }

  public void addReservationList()
  {
     ReservationList reservationList;
     reservationList = booking.adapterR.getReservationList();
     DefaultListModel<Reservation> lm1 = new DefaultListModel<>();
     
     for (int i = 0;i<reservationList.size();i++){
        lm1.addElement(reservationList.getReservations(i));
     }
     list.setModel(lm1);
  }
  
  public class ButtonHandler implements ActionListener
  {
     
  public void actionPerformed (ActionEvent e)
  {
     if(e.getSource().equals(button1))
     {
        
     
     if(!(field1.getText().equals("")) || !(field2.getText().equals("")) || !(field3.getText().equals("")) || !(field4.getText().equals("")))
     {
        
        GUI_ReservationInfo g = new GUI_ReservationInfo();
        
     }
     else
     {
        JOptionPane.showMessageDialog(null, "Complete at least one field",
              "No information", JOptionPane.ERROR_MESSAGE);
     }
     }
     
     if(e.getSource().equals(button2))
     {
        JOptionPane.showMessageDialog(null, "The vehicle was handed out",
              "Handed out", JOptionPane.ERROR_MESSAGE);
     }
     
     if(e.getSource().equals(button3))
     {
        addReservationList();
     }
  }
  }
  
  public class MouseHandler extends MouseAdapter
  {
     public void mouseClicked(MouseEvent e)
     {
        if (e.getClickCount()== 2)
        {
           GUI_ReservationInfo g = new GUI_ReservationInfo();
        }
     }
  }

   
}
