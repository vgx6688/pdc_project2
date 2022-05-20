/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Show_Ticket_Program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author JL Lopez
 */
public abstract class Ticket {

    private String type;
    private double cost;
    private int amount;

    /**
     * @param amount
     *
     * Ticket class constructor
     */
    Ticket(int amount) {
        this.amount = amount;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Reads TicketsInfo.txt for ticket info and stores info in class.
     */
    protected void getTicketInfo() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("TicketsInfo.txt"));
            Scanner scan = new Scanner(br);
            StringTokenizer str;

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                str = new StringTokenizer(line, ":");

                if (str.nextToken().equalsIgnoreCase(this.getType())) {
                    this.setCost(Integer.parseInt(str.nextToken()));
                    break;
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *@return output
     * 
     * Formats class data for console printing.
     */
    @Override
    public String toString() {
        String output = String.format("%d %s tickets left at $%.2f each.\n", this.amount, this.type, this.cost);
        return output;
    }
}
