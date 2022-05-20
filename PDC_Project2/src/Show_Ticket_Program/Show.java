/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Show_Ticket_Program;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author JL Lopez
 */
public class Show {

    private String showCode;
    private String date;
    private Map tickets;
    
    /**
     * @param input
     * 
     * Show class constructor
     */
    Show(String input) {
        this.storeShowInfo(input);
    }

    /**
     * @return the showCode
     */
    public String getShowCode() {
        return showCode;
    }

    /**
     * @param showCode the showCode to set
     */
    public void setShowCode(String showCode) {
        this.showCode = showCode;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the tickets
     */
    public Map getTickets() {
        return tickets;
    }

    /**
     * @param tickets the tickets to set
     */
    public void setTickets(Map tickets) {
        this.tickets = tickets;
    }

    /**
     * @param input
     * 
     * Stores show info using input
     */
    private void storeShowInfo(String input) {

        setTickets(new HashMap());

        String line = input;
        StringTokenizer str = new StringTokenizer(line, ":");

        this.setShowCode(str.nextToken());
        this.setDate(str.nextToken());

        int i = 0;
        while (str.countTokens() != 0) {
            try {
                int token = Integer.parseInt(str.nextToken());

                if (i == 0) {
                    getTickets().put("Bronze", new BronzeTicket(token));
                    i++;
                } else {
                    if (i == 1) {
                        getTickets().put("Silver", new SilverTicket(token));
                        i++;
                    } else {
                        getTickets().put("Gold", new GoldTicket(token));
                    }
                }

            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    
    /**
     * @return output
     * 
     * Formats class data for file printing. 
     */
    public String toFile() {
        int bronze = ((Ticket)this.tickets.get("Bronze")).getAmount();
        int silver = ((Ticket)this.tickets.get("Silver")).getAmount();
        int gold = ((Ticket)this.tickets.get("Gold")).getAmount();
        return String.format("%s:%s:%d:%d:%d\n", this.showCode, this.date, bronze, silver, gold);
    }

    /**
     * @return output
     * @param  booking
     * 
     * Updates show info based on recent booking by changing quantity of available tickets
     */
    public String updateShowInfo(Booking booking) {

        int newBronze = ((Ticket) this.tickets.get("Bronze")).getAmount() - Integer.parseInt(booking.getTickets().get("Bronze").toString());
        int newSilver = ((Ticket) this.tickets.get("Silver")).getAmount() - Integer.parseInt(booking.getTickets().get("Silver").toString());
        int newGold = ((Ticket) this.tickets.get("Gold")).getAmount() - Integer.parseInt(booking.getTickets().get("Gold").toString());

        this.tickets.replace("Bronze", new BronzeTicket(newBronze));
        this.tickets.replace("Silver", new SilverTicket(newSilver));
        this.tickets.replace("Gold", new GoldTicket(newGold));

        String output = this.toFile();
        return output;
    }
    
    /**
     * @return output
     * 
     * Formats class data for a summary display.
     */
    public String display(){
        int bronzeTickets = ((Ticket)this.tickets.get("Bronze")).getAmount();
        int silverTickets = ((Ticket)this.tickets.get("Silver")).getAmount();
        int goldTickets = ((Ticket)this.tickets.get("Gold")).getAmount();
        String output = String.format("%-5s %-5s %-8d %-8d %-8d", this.showCode, this.date, bronzeTickets, silverTickets, goldTickets);
        
        return output;
    }
    
    /**
     * @return output
     * 
     * Formats class data for a detailed display of show info. 
     */
    @Override
    public String toString() {
        String output = String.format("Show %s Details \nDate: %s\n", this.getShowCode(), this.getDate());

        Collection tickets = this.tickets.values();

        for (Object t : tickets) {
            output += t.toString();
        }
        return output;
    }
}
