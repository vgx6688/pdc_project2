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
public class GoldTicket extends Ticket{
    
    /**
     * @param amount
     * 
     * GoldTicket class constructor
     */
    public GoldTicket(int amount) {
        super(amount);
        this.setType("Gold");
        this.getTicketInfo();
    }
}