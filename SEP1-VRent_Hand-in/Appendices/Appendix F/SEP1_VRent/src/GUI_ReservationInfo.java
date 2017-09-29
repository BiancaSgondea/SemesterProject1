import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;




public class GUI_ReservationInfo extends JFrame
{
   private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel8, panel9, panel10, panel11, panel12, panel13, panel14,panel15,panel16,panel17;
   private JButton button1;
   private JLabel label1,label2, label3, label4, label5, label6, label8, label9, label10, label11,label12,label13;
  private JLabel label14, label15, label16, label17, label18, label19, label20,label21,label22;

   public GUI_ReservationInfo()
   {
      super("Reservation information");
      setLayout(new FlowLayout(FlowLayout.LEFT));


      
      panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
      label1 = new JLabel("Personal information:");
      label1.setPreferredSize(new Dimension(130, 20));
      panel1.add(label1);
      add(panel1);
      
      panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
     
      label2 = new JLabel("First Name:");
      label2.setPreferredSize(new Dimension(70, 20));
      panel2.add(label2);
      label14 = new JLabel("");
      panel2.add(label14);     
      add(panel2);
      
      panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      label3 = new JLabel("Last Name:");
      label3.setPreferredSize(new Dimension(70, 20));
      panel3.add(label3);
      label15 = new JLabel("");
      panel3.add(label15);  
      add(panel3);
      
      panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      label4 = new JLabel("Phone no.:");
      label4.setPreferredSize(new Dimension(70, 20));
      panel4.add(label4);
      label16 = new JLabel("");
      panel4.add(label16);     
      add(panel4);
      
      panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      label5 = new JLabel("Adress:");
      label5.setPreferredSize(new Dimension(70, 20));
      panel5.add(label5);
      label17 = new JLabel("");
      panel5.add(label17);  
      add(panel5);
     
      
      panel13 = new JPanel(new GridLayout(7,1));
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
      label9 = new JLabel("Pick-up location:");
      label9.setPreferredSize(new Dimension(100, 20));
      panel9.add(label9);
      label19 = new JLabel("");
      panel9.add(label19);    
      add(panel9);
    
      panel10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      label10 = new JLabel("Delivery location:");
      label10.setPreferredSize(new Dimension(100, 20));
      panel10.add(label10);
      label20 = new JLabel("");
      panel10.add(label20);    
      add(panel10);
      
      panel11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      label11 = new JLabel("Driving license:");
      label11.setPreferredSize(new Dimension(100, 20));
      panel11.add(label11);
      label21 = new JLabel("");
      panel11.add(label21);    
      add(panel11);
      
      
      panel16 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      label12 = new JLabel("Pick-up Date:");
      label12.setPreferredSize(new Dimension(100, 20));
      panel16.add(label12);
      label21 = new JLabel("");
      panel16.add(label21);    
      add(panel16);
      
      panel17 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      label13 = new JLabel("Delivery Date:");
      label13.setPreferredSize(new Dimension(100, 20));
      panel17.add(label13);
      label22 = new JLabel("");
      panel17.add(label22);    
      add(panel17);
      
   
      
      panel9.setPreferredSize(new Dimension(240, 30));
      panel10.setPreferredSize(new Dimension(240, 30));
      panel11.setPreferredSize(new Dimension(240, 30));
      panel16.setPreferredSize(new Dimension(240,30));
      panel17.setPreferredSize(new Dimension(240,30));
      
      
      
      panel14 = new JPanel(new GridLayout(6,1));
      panel14.add(panel8);
      panel14.add(panel9);
      panel14.add(panel10);
      panel14.add(panel11);
      panel14.add(panel16);
      panel14.add(panel17);
      add(panel14);
      
     panel15 = new JPanel(new GridLayout(1,2));
      panel15.add(panel13);
      panel15.add(panel14);
      add(panel15);
      

      
      add(panel15);

      setSize(500, 300);
      setVisible(true);

      setLocationRelativeTo(null);
     
   }
   
//   private void registerHandlers()
//   {
//      ButtonHandler handler = new ButtonHandler();
//      button1.addActionListener(handler);
//   }
//   
//   private class ButtonHandler implements ActionListener
//   {
//
//      public void actionPerformed(ActionEvent e)
//      {
//         if(e.getSource().equals(button1))
//         {
//            
//         
//         if(!(label14.getText().equals("")) && !(label15.getText().equals("")) && !(label16.getText().equals(""))&& !(label17.getText().equals("")) && !(label19.getText().equals(""))&& !(label20.getText().equals("")))
//         {
//            JOptionPane.showMessageDialog(null, "Reservation saved");
//         }
//         else
//         {
//            JOptionPane.showMessageDialog(null, "Invalid date!",
//                  "Error date", JOptionPane.ERROR_MESSAGE);
//         }
//         }
//         
//      }
//      
//   }
   
}