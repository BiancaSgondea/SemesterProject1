
import javax.swing.*;

public class GUI_Frame extends JFrame {
    private JTabbedPane tabbedPane;

    public GUI_Frame() {

        super("V-Rent");

        tabbedPane = new JTabbedPane();
        GUI_PINFO info = new GUI_PINFO(this);
        GUI_MakeReservation booking = new GUI_MakeReservation(info);
        GUI_SerchReservation reservation = new GUI_SerchReservation(booking);

        GUI_Home home = new GUI_Home();

        tabbedPane.add("Home", home);
        tabbedPane.add("Renting info", info);
        tabbedPane.add("Reservation", booking);
        tabbedPane.add("Serch reservation", reservation);

        getContentPane().add(tabbedPane);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 700);
        pack();
        setLocationByPlatform(true);
        setVisible(true);

    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

}
