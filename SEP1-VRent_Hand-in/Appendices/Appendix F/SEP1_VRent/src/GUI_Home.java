import java.awt.*;

import javax.swing.*;

public class GUI_Home extends JPanel
{
   private ImageIcon logoIcon, logoIcon1;
   private JLabel logoLabel, logoLabel1;

   public GUI_Home()
   {
//      super("ImageIcon example");
      setLayout(new BorderLayout());

      logoLabel = new JLabel();
      logoLabel1 = new JLabel();
      logoLabel.setIcon(logoIcon);
      logoIcon1 = new ImageIcon("img/vrent4.jpg");
      logoLabel1.setIcon(logoIcon1);

      add(logoLabel);
      add(logoLabel1);
      setSize(450, 305);
      setVisible(true);
//      setDefaultCloseOperation(EXIT_ON_CLOSE);
//      setLocationRelativeTo(null);
   }

   {

   }
}
