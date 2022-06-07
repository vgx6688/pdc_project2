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

    private Database db;
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

    /**
     * @return the db
     */
    public Database getDb() {
        return db;
    }

    /**
     * @param db the db to set
     */
    public void setDb(Database db) {
        this.db = db;
    }

    /**
     * @return the showAData
     */
    public ShowData getShowAData() {
        return showAData;
    }

    /**
     * @param showAData the showAData to set
     */
    public void setShowAData(ShowData showAData) {
        this.showAData = showAData;
    }

    /**
     * @return the showBData
     */
    public ShowData getShowBData() {
        return showBData;
    }

    /**
     * @param showBData the showBData to set
     */
    public void setShowBData(ShowData showBData) {
        this.showBData = showBData;
    }

    /**
     * @return the showCData
     */
    public ShowData getShowCData() {
        return showCData;
    }

    /**
     * @param showCData the showCData to set
     */
    public void setShowCData(ShowData showCData) {
        this.showCData = showCData;
    }

    /**
     * @return the inputData
     */
    public ShowData getInputData() {
        return inputData;
    }

    /**
     * @param inputData the inputData to set
     */
    public void setInputData(ShowData inputData) {
        this.inputData = inputData;
    }

    /**
     * @return the userData
     */
    public UserData getUserData() {
        return userData;
    }

    /**
     * @param userData the userData to set
     */
    public void setUserData(UserData userData) {
        this.userData = userData;
    }
    
    /*
        @return Show ID
    
        Returns the show ID in inputData variable
    */
    public String getShowID(){
        return getInputData().ID;
    }

    
    /*
        Assigns the data from the database to a variable for each show. 
    */
    public void displayData() {
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    showAData.ID = "A";
                    setShowAData(getDb().displayData(getShowAData().ID));
                    showAData.display = false;
//                    System.out.println("Show A ShowData done");
                    this.setChanged();
                    this.notifyObservers(getShowAData());
                    showAData.display = true;
                    break;
                case 1:
                    showBData.ID = "B";
                    setShowBData(getDb().displayData(getShowBData().ID));
                    showBData.display = false;
//                    System.out.println("Show B ShowData done");
                    this.setChanged();
                    this.notifyObservers(getShowBData());
                    showBData.display = true;
                    break;
                case 2:
                    showCData.ID = "C";
                    setShowCData(getDb().displayData(getShowCData().ID));
                    showCData.display = false;
//                    System.out.println("Show C ShowData done");
                    this.setChanged();
                    this.notifyObservers(getShowCData());
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
                data = getShowAData();
                break;
            case "B":
                showBData.chosen = true;
                data = getShowBData();
                break;
            case "C":
                showCData.chosen = true;
                data = getShowCData();
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
                inputData.goldTicks.price = getShowAData().goldTicks.price;
//                System.out.println(inputData.goldTicks.price);

                break;
            case "S":
//                System.out.println("silver");
                inputData.silverTicks.quantity = quantity;
                inputData.silverTicks.price = getShowAData().silverTicks.price;
//                System.out.println(inputData.silverTicks.price);
                break;
            case "B":
//                System.out.println("bronze");
                inputData.bronzeTicks.quantity = quantity;
                inputData.bronzeTicks.price = getShowAData().bronzeTicks.price;
//                System.out.println(inputData.bronzeTicks.price);
                break;
            default:
                break;
        }

        inputData.update = true;
//        System.out.println(String.format("%d.%d.%d", userData.ID.goldTicks.quantity, userData.ID.silverTicks.quantity, userData.ID.bronzeTicks.quantity));
        this.setChanged();
        this.notifyObservers(getInputData());
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
        this.notifyObservers(getInputData());
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
        
        double totalCost = 1.0 * (getInputData().goldTicks.quantity * getInputData().goldTicks.price + 
                getInputData().silverTicks.quantity*getInputData().silverTicks.price + 
                getInputData().bronzeTicks.quantity*getInputData().bronzeTicks.price);
//        System.out.println(inputData.chosen);
//        System.out.println(inputData.update);
//        System.out.println(inputData.display);
//        System.out.println(inputData.confirm);
//        System.out.println(inputData.cancel);

        userData.name = name; 
        userData.phNum = phNum; 
        userData.show = this.getInputData();
        
//        System.out.println(userData.name);
//        System.out.println(userData.phNum);
//        System.out.println(userData.show.ID);
//        System.out.println(userData.show.goldTicks.quantity);
//        System.out.println(userData.show.silverTicks.quantity);
//        System.out.println(userData.show.bronzeTicks.quantity);
        
        ShowData data = null; 
        switch(getInputData().ID){
            case "A":
                data = this.getShowAData();
                break;
            case "B":
                data = this.getShowBData();
                break;
            case "C":
                data = this.getShowCData();
                break;
            default:
                break;
        }
        
        String bookingID = getDb().storeBooking(data, getUserData(), totalCost);
        inputData.ID = bookingID;
        
        this.setChanged();
        this.notifyObservers(getInputData());
    }
}
