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
public class SilverTicket extends Ticket {
    
    /**
     * @param amount
     * 
     * SilverTicket class constructor
     */
    public SilverTicket(int amount) {
        super(amount);
        this.setType("Silver");
        this.getTicketInfo();
    }        
}
