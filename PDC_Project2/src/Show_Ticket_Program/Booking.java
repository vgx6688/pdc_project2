/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Show_Ticket_Program;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JL Lopez
 */
public class Booking {

    private String showCode;
    private Map tickets;

    /**
     * Booking class constructor
     */
    Booking(String showCode) {
        this.showCode = showCode.toUpperCase();
        this.tickets = new HashMap();
        this.tickets.put("Bronze", 0);
        this.tickets.put("Silver", 0);
        this.tickets.put("Gold", 0);
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
     * @param type
     * @param quantity Replaces current ticket type amount with inputted amount
     *
     */
    public void addTickets(String type, Integer quantity) {
        this.tickets.replace(type, quantity);
    }

    /**
     * @param show
     * @param input
     * @return valid
     *
     * Checks if user input is in valid format for booking tickets.
     */
    public boolean checkInput(Show show, String input) {
        boolean valid = false;
        boolean typeCheck = false;
        boolean quantCheck = false;

        Character type = input.charAt(0);
        Integer quantity = 0;
        try {
            if (type == 'g' || type == 's' || type == 'b') {
                typeCheck = true;
                String ticketType = "";
                Collection<Ticket> tickets = show.getTickets().values();
                switch (type) {
                    case 'g':
                        ticketType = "Gold";
                        break;
                    case 's':
                        ticketType = "Silver";
                        break;
                    default:
                        ticketType = "Bronze";
                        break;
                }

                quantity = Integer.parseInt(input.substring(1, input.length()));
                for (Ticket t : tickets) {
                    if (t.getType().equalsIgnoreCase(ticketType) && t.getAmount() >= quantity) {
                        quantCheck = true;
                        break;
                    }
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("\nNo ticket quantity found.");
        } finally {
            if (typeCheck && quantCheck) {
                valid = true;
            } else if (!typeCheck) {
                System.out.println("\nInvalid ticket type. Please try again.");
            } else {
                System.out.println("\nInvalid ticket quantity. Please try again.");
            }
        }

        return valid;
    }

    /**
     * @param input
     *
     * Splits user input into ticket type and ticket quantity then adds to data
     * to ticket Map.
     */
    public void bookTickets(String input) {

        Character type = input.charAt(0);
        Integer quantity = Integer.parseInt(input.substring(1, input.length()));

        String ticketType;

        switch (type) {
            case 'g':
                ticketType = "Gold";
                break;
            case 's':
                ticketType = "Silver";
                break;
            default:
                ticketType = "Bronze";
                break;
        }

        addTickets(ticketType, quantity);
    }

    /**
     *
     * @param input
     * @return confirmation
     *
     * Checks input if user has inputted 'y' to confirm their booking.
     */
    public boolean confirmBooking(String input) {
        boolean confirmation = false;

        if (input.equalsIgnoreCase("y")) {
            System.out.println("Booking Confirmed\n");
            confirmation = true;
        } else {
            System.out.println("Booking Cancelled\n");
            this.tickets.clear();
        }

        return confirmation;
    }

    /**
     * @return output
     *
     * Formats the data in the class for printing into a file
     */
    public String toFile() {
        String output = "";
        int i = 0;
        for (Object o : tickets.values()) {
            Ticket ticketType;

            if (i == 0) {
                ticketType = new BronzeTicket(Integer.parseInt(o.toString()));
            } else if (i == 1) {
                ticketType = new SilverTicket(Integer.parseInt(o.toString()));;
            } else {
                ticketType = new GoldTicket(Integer.parseInt(o.toString()));;
            }
            if (!o.equals(0)) {
                output += String.format("%c%d ", ticketType.getType().charAt(0), ticketType.getAmount());
            }
            i++;
        }
        return output;
    }

    /**
     * @return output
     *
     * Formats class data for printing into console.
     */
    @Override
    public String toString() {
        String output = String.format("\nOrder Details: \nShow %s\n", this.showCode);

        double total = 0.0;
        int i = 0;
        for (Object o : tickets.values()) {
            Ticket ticketType;

            switch (i) {
                case 0:
                    ticketType = new BronzeTicket(Integer.parseInt(o.toString()));
                    break;
                case 1:
                    ticketType = new SilverTicket(Integer.parseInt(o.toString()));
                    ;
                    break;
                default:
                    ticketType = new GoldTicket(Integer.parseInt(o.toString()));
                    ;
                    break;
            }
            if (!o.equals(0)) {
                total += ticketType.getCost() * ticketType.getAmount();
                output += String.format("%d %s ticket/s: $%.2f \n", o, ticketType.getType(), ticketType.getCost() * ticketType.getAmount());
            }
            i++;
        }
        output += String.format("\nTotal: $%.2f\n", total);
        return output;
    }

}
