/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Show_Ticket_Program;

/**
 *
 * @author JL Lopez
 */
public class ShowData {
    String ID = ""; 
    String date = "";
    TicketData goldTicks = new TicketData(); 
    TicketData silverTicks = new TicketData(); 
    TicketData bronzeTicks = new TicketData();
    boolean display = true; 
    boolean chosen = false;
    boolean update = false;
    boolean confirm = false; 
    boolean cancel = false; 
}
