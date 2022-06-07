/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Show_Ticket_Program;

import java.util.Observable;

/**
 *
 * @author JL Lopez
 */
public class Model extends Observable {

    public Database db;
    private ShowData showAData = new ShowData();
    private ShowData showBData = new ShowData();
    private ShowData showCData = new ShowData();
    private ShowData inputData = new ShowData();
    private UserData userData = new UserData();
    
    /*
        Constructor for Model Class
    */
    public Model() {
        this.db = new Database();
        this.db.dbsetup();
    }
    
    /*
        @return Show ID
    
        Returns the show ID in inputData variable
    */
    public String getShowID(){
        return inputData.ID;
    }

    
    /*
        Assigns the data from the database to a variable for each show. 
    */
    public void displayData() {
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    showAData.ID = "A";
                    showAData = db.displayData(showAData.ID);
                    showAData.display = false;
//                    System.out.println("Show A ShowData done");
                    this.setChanged();
                    this.notifyObservers(showAData);
                    showAData.display = true;
                    break;
                case 1:
                    showBData.ID = "B";
                    showBData = db.displayData(showBData.ID);
                    showBData.display = false;
//                    System.out.println("Show B ShowData done");
                    this.setChanged();
                    this.notifyObservers(showBData);
                    showBData.display = true;
                    break;
                case 2:
                    showCData.ID = "C";
                    showCData = db.displayData(showCData.ID);
                    showCData.display = false;
//                    System.out.println("Show C ShowData done");
                    this.setChanged();
                    this.notifyObservers(showCData);
                    showCData.display = true;
                    break;
                default:
                    break;
            }
        }
    }

    /*
        @param show the show ID chosen
    
        Updates the JComboBoxes depending on the chosen show. 
    */
    public void updateBoxes(String show) {
        ShowData data = null;
        switch (show) {
            case "A":
                showAData.chosen = true;
                data = showAData;
                break;
            case "B":
                showBData.chosen = true;
                data = showBData;
                break;
            case "C":
                showCData.chosen = true;
                data = showCData;
            default:
                break;
        }
        inputData.ID = show;
//        System.out.println(userData.ID.ID);
        this.setChanged();
        this.notifyObservers(data);
    }
    
    
    /*
        @param quantity ticket quantity 
        @param type ticket type
    
        Calculates the total cost of the chosen tickets. 
    */
    public void updateTotalCost(String type, int quantity) {
        switch (type) {
            case "G":
//                System.out.println("gold");
                inputData.goldTicks.quantity = quantity;
                inputData.goldTicks.price = showAData.goldTicks.price;
//                System.out.println(inputData.goldTicks.price);

                break;
            case "S":
//                System.out.println("silver");
                inputData.silverTicks.quantity = quantity;
                inputData.silverTicks.price = showAData.silverTicks.price;
//                System.out.println(inputData.silverTicks.price);
                break;
            case "B":
//                System.out.println("bronze");
                inputData.bronzeTicks.quantity = quantity;
                inputData.bronzeTicks.price = showAData.bronzeTicks.price;
//                System.out.println(inputData.bronzeTicks.price);
                break;
            default:
                break;
        }

        inputData.update = true;
//        System.out.println(String.format("%d.%d.%d", userData.ID.goldTicks.quantity, userData.ID.silverTicks.quantity, userData.ID.bronzeTicks.quantity));
        this.setChanged();
        this.notifyObservers(inputData);
    }

    
    /*
        Changes state of the inputData variable and notifies the view class about thet change
    */
    public void cancelBooking() {
//        System.out.println("Cancelling booking");
        this.inputData.cancel = true;
        this.inputData.update = false;
//        System.out.println(inputData.chosen);
//        System.out.println(inputData.update);
//        System.out.println(inputData.display);
//        System.out.println(inputData.confirm);
//        System.out.println(inputData.cancel);
        this.setChanged();
        this.notifyObservers(inputData);
    }

    /*
        @param name User Name
        @param phNum User Phone number
    
        Changes state of inputData and calls database method to update database.
    */
    public void confirmBooking(String name, String phNum) {
//        System.out.println("Confirming booking");
        this.inputData.confirm = true;
        this.inputData.update = false;
        
        double totalCost = 1.0 * (inputData.goldTicks.quantity * inputData.goldTicks.price + 
                inputData.silverTicks.quantity*inputData.silverTicks.price + 
                inputData.bronzeTicks.quantity*inputData.bronzeTicks.price);
//        System.out.println(inputData.chosen);
//        System.out.println(inputData.update);
//        System.out.println(inputData.display);
//        System.out.println(inputData.confirm);
//        System.out.println(inputData.cancel);

        userData.name = name; 
        userData.phNum = phNum; 
        userData.show = this.inputData;
        
//        System.out.println(userData.name);
//        System.out.println(userData.phNum);
//        System.out.println(userData.show.ID);
//        System.out.println(userData.show.goldTicks.quantity);
//        System.out.println(userData.show.silverTicks.quantity);
//        System.out.println(userData.show.bronzeTicks.quantity);
        
        ShowData data = null; 
        switch(inputData.ID){
            case "A":
                data = this.showAData;
                break;
            case "B":
                data = this.showBData;
                break;
            case "C":
                data = this.showCData;
                break;
            default:
                break;
        }
        
        String bookingID = db.storeBooking(data, userData, totalCost);
        inputData.ID = bookingID;
        
        this.setChanged();
        this.notifyObservers(inputData);
    }
}
