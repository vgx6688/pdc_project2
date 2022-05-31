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
        try{
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            this.createTable("ShowsInfo");
            this.createTable("TicketsInfo");
            this.createTable("ShowsABookings");
            this.createTable("ShowsBBookings");
            this.createTable("ShowsCBookings");
        } catch(Throwable e){
            System.out.println(e.getMessage());
        }
        
    }

    public void createTable(String tableName) {
        try {
            Statement statement = conn.createStatement();
            if (!checkTableExists(tableName)) {
                if (tableName.equalsIgnoreCase("ShowsInfo")) {
                    statement.executeUpdate("CREATE TABLE " + tableName + " (showID VARCHAR(1), date DATE, goldticket INT, silverticket INT, bronzeticket INT)");
                    this.insertTableData(tableName);
                } else if (tableName.equalsIgnoreCase("TicketsInfo")) {
                    statement.executeUpdate("CREATE TABLE " + tableName + " (tickettype VARCHAR(10), price INT)");
                    this.insertTableData(tableName);
                } else {
                    statement.executeUpdate("CREATE TABLE " + tableName + " (bookingid VARCHAR(10), name VARCHAR(12), goldticket INT, silverticket INT, bronzeticket INT)");
                }
            }
            statement.close();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertTableData(String tableName) {
        try{
            Statement statement = conn.createStatement();
            if (tableName.equalsIgnoreCase("ShowsInfo")) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (showID VARCHAR(1), date DATE, goldticket INT, silverticket INT, bronzeticket INT)");
                statement.addBatch("INSERT INTO " + tableName + " VALUES('A', 21/05/2022, 11, 12, 13)");
                statement.addBatch("INSERT INTO " + tableName + " VALUES('B', 26/05/2022, 21, 22, 23)");
                statement.addBatch("INSERT INTO " + tableName + " VALUES('C', 31/05/2022, 31, 32, 33)");
                statement.executeBatch();
            } else if (tableName.equalsIgnoreCase("TicketsInfo")) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (tickettype VARCHAR(10), price INT)");
                statement.addBatch("INSERT INTO " + tableName + " VALUES('Gold', 30)");
                statement.addBatch("INSERT INTO " + tableName + " VALUES('Silver', 21)");
                statement.addBatch("INSERT INTO " + tableName + " VALUES('Bronze', 12)");
                statement.executeBatch();
            }  
        } catch(Throwable e){
            System.out.println(e.getMessage());
        }
        
    }

    public boolean checkTableExists(String tableName) {
        boolean exists = false;
        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = dbmd.getTables(null, null, null, types);

            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
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
}
