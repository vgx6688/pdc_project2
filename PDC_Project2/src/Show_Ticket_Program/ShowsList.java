/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Show_Ticket_Program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JL Lopez
 */
public class ShowsList {

    private ArrayList<Show> shows;
    
    /**
     * @ShowsList constructor
     */
    ShowsList() {
        this.shows = new ArrayList<>();
        getShowsInfo();
    }

    /**
     * @return the shows
     */
    public ArrayList<Show> getShows() {
        return shows;
    }

    /**
     * @param shows the shows to set
     */
    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }

    /**
     * Reads ShowsInfo.txt for the shows info.
     */
    private void getShowsInfo() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("ShowsInfo.txt"));
            Scanner scan = new Scanner(br);

            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                Show aShow = new Show(s);
                this.shows.add(aShow);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param booking
     * 
     * Updates the ShowsInfo.txt with new info after a completed booking transaction
     */
    public void updateFileInfo(Booking booking) {
        String output = "";
        for(Show s: this.shows){
            if(s.getShowCode().equalsIgnoreCase(booking.getShowCode())){
                output += s.updateShowInfo(booking);
            } else{
                output += s.toFile();
            }
        }
 
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("ShowsInfo.txt"));
            pw.print(output);
            
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * @return a specific Show
     * @param showcode
     * 
     * Returns a show from the shows list based on given show code.
     */
    public Show getShow(String showcode){
        Show show = null;
        for(Show s : this.shows){
            if(s.getShowCode().equalsIgnoreCase(showcode)){
                show = s;
                break;
            }
        }
        return show;
    }

    /**
     * @return output
     * 
     * Formats class data for console printing.
     */
    @Override
    public String toString() {
        String output = "";
        int i = 1;
        output += "Showcode    Date    Bronze   Silver   Gold\n";
        for (Show s : this.shows) {
            output += String.format("%d. %s\n", i++, s.display());
        }
        return output;
    }
}
