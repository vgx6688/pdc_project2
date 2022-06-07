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
                break;
            case "Gold Ticket":
//                System.out.println("Gold ticket box has been changed");
                JComboBox source = (JComboBox) e.getSource();
                if (source.getItemCount() != 0) {
                    int numTickets = Integer.parseInt((String) source.getSelectedItem());
                    model.updateTotalCost("G", numTickets);
                }
                break;
            case "Silver Ticket":
//                System.out.println("Silver ticket box has been changed");
                source = (JComboBox) e.getSource();
                if (source.getItemCount() != 0) {
                    int numTickets = Integer.parseInt((String) source.getSelectedItem());
                    model.updateTotalCost("S", numTickets);
                }
                break;
            case "Bronze Ticket":
//                System.out.println("Bronze ticket box has been changed");
                source = (JComboBox) e.getSource();
                if (source.getItemCount() != 0) {
                    int numTickets = Integer.parseInt((String) source.getSelectedItem());
                    model.updateTotalCost("B", numTickets);
                }
                break;
            case "Confirm":
                String name = view.nameField.getText();
                String phNum = view.phNumField.getText();
                String show = model.getShowID();
                int gold = Integer.parseInt((String)view.goldQuant.getSelectedItem());
                int silver = Integer.parseInt((String)view.silverQuant.getSelectedItem());
                int bronze = Integer.parseInt((String)view.bronzeQuant.getSelectedItem());
                
                if(name.equalsIgnoreCase("") || name == null){
                    JOptionPane.showMessageDialog(view, "Please input your name", "Error", JOptionPane.ERROR_MESSAGE);
                } else if(phNum.length() < 9){
                    JOptionPane.showMessageDialog(view, "Please input valid phone number", "Error", JOptionPane.ERROR_MESSAGE);
                } else if(gold == 0 && silver == 0 && bronze == 0){
                    JOptionPane.showMessageDialog(view, "Please choose valid ticket quantities", "Error", JOptionPane.ERROR_MESSAGE);
                } else{
                    String output = String.format("Name: %s\n Phone Number: %s\n Show: %s\n Gold: %d\n Silver: %d\n Bronze: %d",
                            name, phNum, show, gold, silver, bronze);
                    int confirm = JOptionPane.showConfirmDialog(view, output, "Booking confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (confirm == JOptionPane.YES_OPTION) {
                        model.confirmBooking(name, phNum);
                    }
                }
                break;
            case "Cancel":
                int cancel = JOptionPane.showConfirmDialog(view, "Do you want to cancel booking session?", "Cancel Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(cancel == JOptionPane.YES_OPTION){
                    model.cancelBooking();
                }
                break;
            default:
                break;
        }
    }
}
