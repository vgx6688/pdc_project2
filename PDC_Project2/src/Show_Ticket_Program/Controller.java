/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Show_Ticket_Program;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author JL Lopez
 */
public class Controller implements ActionListener {

    public View view;
    public Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
        model.displayData();
        view.setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Show A":
//                System.out.println("Show A Button selected");
                model.updateBoxes("A");
                break;
            case "Show B":
//                System.out.println("Show B Button selected");
                model.updateBoxes("B");
                break;
            case "Show C":
//                System.out.println("Show C Button selected");
                model.updateBoxes("C");
            case "Gold Ticket":
                System.out.println("Gold ticket box has been changed");
                JComboBox source = (JComboBox)e.getSource();
                int numTickets = Integer.parseInt((String)source.getSelectedItem());
                model.updateTotalCost("G", numTickets);
                break;
            case "Confirm":
                int confirm = JOptionPane.showConfirmDialog(view, "Please double check inputs then press Yes to confirm.", "Booking confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                break;
            case "Cancel":
                int cancel = JOptionPane.showConfirmDialog(view, "Do you want to cancel booking session?", "Cancel Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                break;  
            default:
                break;
        }
    }
}
