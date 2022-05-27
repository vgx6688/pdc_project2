/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Show_Ticket_Program;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author JL Lopez
 */
public class View extends JFrame implements Observer {

    private JPanel infoPanel = new JPanel();
    private JLabel showID = new JLabel("Show ID: ");
    private JLabel date = new JLabel("Date: ");
    private JLabel goldTicks = new JLabel("Gold Tickets left: ");
    private JLabel silverTicks = new JLabel("Silver Tickets left: ");
    private JLabel bronzeTicks = new JLabel("Bronze Tickets left: ");

    public View() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLocationRelativeTo(null);
        infoPanel.add(showID);
        infoPanel.add(date); 
        infoPanel.add(goldTicks);
        infoPanel.add(silverTicks);
        infoPanel.add(bronzeTicks);
        this.add(infoPanel); 
        this.setVisible(true); 
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        View view = new View();
    }
}
