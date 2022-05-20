/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Show_Ticket_Program;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JL Lopez
 */
public class Database {

    Connection conn = null;
    String url = "jdbc:derby:ShowsDB;create=true";
    String dbusername = "pdc";
    String dbpassword = "pdc";

    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";

            if (!checkTableExists(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(12), password VARCHAR(12), score INT ");
            }
            statement.close();
        } catch (Throwable e) {
            System.out.println("ERROR");
        }
    }

    public Data checkName(String username, String password) {
        Data data = new Data();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password, score FROM UserInfo WHERE userid = '" + username + "'");
            if (rs.next()) {
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");

                if (password.compareTo(pass) == 0) {
                    data.currentScore = rs.getInt("score");
                    data.loginFlag = true;
                } else {
                    data.loginFlag = false;
                }
            } else {
                System.out.println("User not found");
                statement.executeUpdate("INSERT INTO UserInfo VALUES('" + username + "', '" + password + "', 0");
                data.currentScore = 0;
                data.loginFlag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public boolean checkTableExists(String tableName) {
        boolean exists = false;
        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            Statement statement;
            statement = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, types);

            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                System.out.println(table_name);
                if (table_name.equalsIgnoreCase(tableName)) {
                    exists = true;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return exists;
    }
    
    public void quitGame(int score, String username){
        try{
            Statement statement = this.conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET score-" + score+ " WHERE userid-" + username);
        } catch (SQLException ex){
            System.out.println("Error");
        }
        
    }
}
