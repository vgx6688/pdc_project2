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
public class User {

    private String name;
    private String phNum;
    private Booking userBooking;

    User(Booking userBooking) {
        this.userBooking = userBooking;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phNum
     */
    public String getPhNum() {
        return phNum;
    }

    /**
     * @param phNum the phNum to set
     */
    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    /**
     * @return the userBooking
     */
    public Booking getUserBooking() {
        return userBooking;
    }

    /**
     * @param userBooking the userBooking to set
     */
    public void setUserBooking(Booking userBooking) {
        this.userBooking = userBooking;
    }
}
