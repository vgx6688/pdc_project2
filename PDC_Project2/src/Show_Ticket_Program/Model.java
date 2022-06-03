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
    String show = "";
    private UserData userData = new UserData();

    public Model() {
        this.db = new Database();
        this.db.dbsetup();
    }

    public void displayData() {
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    showAData.show = "A";
                    showAData = db.displayData(showAData.show);
                    showAData.display = false;
//                    System.out.println("Show A ShowData done");
                    this.setChanged();
                    this.notifyObservers(showAData);
                    showAData.display = true;
                    break;
                case 1:
                    showBData.show = "B";
                    showBData = db.displayData(showBData.show);
                    showBData.display = false;
//                    System.out.println("Show B ShowData done");
                    this.setChanged();
                    this.notifyObservers(showBData);
                    showBData.display = true;
                    break;
                case 2:
                    showCData.show = "C";
                    showCData = db.displayData(showCData.show);
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
        userData.show.show = show;
        System.out.println(userData.show.show);
        this.setChanged();
        this.notifyObservers(data);
    }

    public void updateTotalCost(String type, int quantity) {
        switch (type) {
            case "G":
//                System.out.println("gold");
                inputData.goldTicks.quantity = quantity;
                inputData.goldTicks.price = showAData.goldTicks.price;
                
                userData.show.goldTicks.quantity = quantity;
                userData.show.goldTicks.price = showAData.goldTicks.price;
//                System.out.println(inputData.goldTicks.price);

                break;
            case "S":
//                System.out.println("silver");
                inputData.silverTicks.quantity = quantity;
                inputData.silverTicks.price = showAData.silverTicks.price;
                
                userData.show.silverTicks.quantity = quantity;
                userData.show.silverTicks.price = showAData.silverTicks.price;
//                System.out.println(inputData.silverTicks.price);
                break;
            case "B":
//                System.out.println("bronze");
                inputData.bronzeTicks.quantity = quantity;
                inputData.bronzeTicks.price = showAData.bronzeTicks.price;
                
                userData.show.bronzeTicks.quantity = quantity;
                userData.show.bronzeTicks.price = showAData.bronzeTicks.price;
//                System.out.println(inputData.bronzeTicks.price);
                break;
            default:
                break;
        }

        inputData.update = true;
        System.out.println(String.format("%d.%d.%d", userData.show.goldTicks.quantity, userData.show.silverTicks.quantity, userData.show.bronzeTicks.quantity ));
        this.setChanged();
        this.notifyObservers(inputData);
    }

    public void cancelBooking() {
        System.out.println("Cancelling booking");
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

    public void confirmBooking() {
        System.out.println("Confirming booking");
        this.inputData.confirm = true;
        this.inputData.update = false;
        System.out.println(inputData.chosen);
        System.out.println(inputData.update);
        System.out.println(inputData.display);
        System.out.println(inputData.confirm);
        System.out.println(inputData.cancel);
        this.setChanged();
        this.notifyObservers(inputData);
    }
}
