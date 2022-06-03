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
//                    System.out.println("Show C ShowData done");
                    showCData.display = false;
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
        switch (show) {
            case "A":
                showAData.chosen = true;
                this.setChanged();
                this.notifyObservers(showAData);
                break;
            case "B":
                showBData.chosen = true;
                this.setChanged();
                this.notifyObservers(showBData);
                break;
            case "C":
                showCData.chosen = true;
                this.setChanged();
                this.notifyObservers(showCData);
            default:
                break;
        }
    }

    public void updateTotalCost(String type, int quantity) {
        switch (type) {
            case "G":
//                System.out.println("gold");
                inputData.goldTicks.quantity = quantity;
                inputData.goldTicks.price = showAData.goldTicks.price;
//                System.out.println(inputData.goldTicks.price);
                inputData.update = true;
                this.setChanged();
                this.notifyObservers(inputData);
                break;
            case "S":
//                System.out.println("silver");
                inputData.silverTicks.quantity = quantity;
                inputData.silverTicks.price = showAData.silverTicks.price;
//                System.out.println(inputData.silverTicks.price);
                inputData.update = true;
                this.setChanged();
                this.notifyObservers(inputData);
                break;
            case "B":
//                System.out.println("bronze");
                inputData.bronzeTicks.quantity = quantity;
                inputData.bronzeTicks.price = showAData.bronzeTicks.price;
//                System.out.println(inputData.bronzeTicks.price);
                inputData.update = true;
                this.setChanged();
                this.notifyObservers(inputData);
                break;
            default:
                break;
        }
    }
}
