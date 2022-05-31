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

    public Model() {
        this.db = new Database(); 
        this.db.dbsetup();
    }
    
}
