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
    public Data data;
    String show = "";

    public Model() {
        this.db = new Database();
        this.db.dbsetup();
    }

    public void displayData() {
        Data showAData = new Data();
        Data showBData = new Data(); 
        Data showCData = new Data(); 
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    showAData.show = "A";
                    showAData = db.displayData(showAData.show);
                    showAData.display = false;
                    this.setChanged();
                    this.notifyObservers(showAData);
                    break;
                case 1:
                    showBData.show = "B";
                    showBData = db.displayData(showBData.show);
                    showBData.display = false;
                    this.setChanged();
                    this.notifyObservers(showBData);
                    break;
                case 2:
                    showCData.show = "C";
                    showCData = db.displayData(showCData.show);
                    showCData.display = false;
                    this.setChanged();
                    this.notifyObservers(showCData);
                    break;
                default:
                    break;
            }   
        }
    }
}
