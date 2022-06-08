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

    /*
        Sets up the database for use. 
     */
    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            this.createTable("ShowsInfo");
            this.createTable("TicketsInfo");
            this.createTable("ShowsABookings");
            this.createTable("ShowsBBookings");
            this.createTable("ShowsCBookings");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }

    }

    /*
        @param tableName
        
        Calls methods needed for table creation
     */
    public void createTable(String tableName) {
        try {
            Statement statement = this.conn.createStatement();
            if (!checkTableExists(tableName)) {
                if (tableName.equalsIgnoreCase("ShowsInfo")) {
                    this.insertTableData(tableName);
                } else if (tableName.equalsIgnoreCase("TicketsInfo")) {
                    this.insertTableData(tableName);
                } else {
                    this.insertTableData(tableName);
                }
            }
            statement.close();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    /*
        @param tableName
        
        Creates tables and inserts data into tables. 
     */
    public void insertTableData(String tableName) {
        try {
            Statement statement = conn.createStatement();
            if (tableName.equalsIgnoreCase("ShowsInfo")) {
                statement.addBatch("CREATE TABLE " + tableName + " (showID VARCHAR(1), date DATE, goldticket INT, silverticket INT, bronzeticket INT)");
                statement.addBatch("INSERT INTO " + tableName + " VALUES('A', '2022-05-27', 11, 12, 13)");
                statement.addBatch("INSERT INTO " + tableName + " VALUES('B', '2022-05-29', 21, 22, 23)");
                statement.addBatch("INSERT INTO " + tableName + " VALUES('C', '2022-05-31', 31, 32, 33)");
                statement.executeBatch();

//                ResultSet rs = statement.executeQuery("SELECT * FROM ShowsInfo");
//                while (rs.next()) {
//                    String id = rs.getString("showID");
//                    System.out.println(id);
//                }
            } else if (tableName.equalsIgnoreCase("TicketsInfo")) {
                statement.addBatch("CREATE TABLE " + tableName + " (tickettype VARCHAR(10), price INT)");
                statement.addBatch("INSERT INTO " + tableName + " VALUES('Gold', 30)");
                statement.addBatch("INSERT INTO " + tableName + " VALUES('Silver', 21)");
                statement.addBatch("INSERT INTO " + tableName + " VALUES('Bronze', 12)");
                statement.executeBatch();

//                ResultSet rs = statement.executeQuery("SELECT * FROM TicketsInfo");
//                while(rs.next()){
//                    String type =  rs.getString("tickettype");
//                    System.out.println(type);
//                }
            } else {
                statement.addBatch("CREATE TABLE " + tableName + " (bookingID VARCHAR(5), phNum VARCHAR(10), name VARCHAR(70), goldticket INT, silverticket INT, bronzeticket INT, totalcost DOUBLE)");
                statement.addBatch("INSERT INTO " + tableName + " VALUES('0000', 'null', 'null', 0, 0, 0, 0)");
                statement.executeBatch();
            }
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }

    }

    /*
        @param TableName 
    
        Checks if tables already exists in database
     */
    public boolean checkTableExists(String tableName) {
        boolean exists = false;
        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = dbmd.getTables(null, null, null, types);
            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                if (table_name.equalsIgnoreCase(tableName)) {
                    //System.out.println(tableName + " " + table_name);
                    exists = true;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return exists;
    }

    /*
        @param show Show ID
        
        Collects data from database that will be displayed in GUI
     */
    public ShowData displayData(String show) {
        ShowData data = new ShowData();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ShowsInfo WHERE showID = '" + show + "'");

            if (rs.next()) {
                data.ID = rs.getString("showID");
                data.date = rs.getString("date");
                data.goldTicks.quantity = rs.getInt("goldticket");
                data.silverTicks.quantity = rs.getInt("silverticket");
                data.bronzeTicks.quantity = rs.getInt("bronzeticket");

//                System.out.println(String.format("%s, %s, %d, %d, %d", data.ID, data.date, data.goldTicks, data.silverTicks, data.bronzeTicks));
                rs = statement.executeQuery("SELECT price FROM TicketsInfo WHERE tickettype = 'Gold'");
                if (rs.next()) {
                    data.goldTicks.price = rs.getInt("price");
//                System.out.println(data.goldTicks.price);
                }

                rs = statement.executeQuery("SELECT price FROM TicketsInfo WHERE tickettype = 'Silver'");
                if (rs.next()) {
                    data.silverTicks.price = rs.getInt("price");
//                System.out.println(data.silverTicks.price);
                }

                rs = statement.executeQuery("SELECT price FROM TicketsInfo WHERE tickettype = 'Bronze'");
                if (rs.next()) {
                    data.bronzeTicks.price = rs.getInt("price");
//                System.out.println(data.bronzeTicks.price);
                }

            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    /*
        @param sData Currently saved data of chosen show
        @param data User chosen data
        @param totalCost total cost of chosen tickets
     */
    public String storeBooking(ShowData sData, UserData data, double totalCost) {
        String bookingID = "";
        int row = 0;
        int num = 0;
        try {
            Statement statement = conn.createStatement();
            String sql = "";

            sql = String.format("SELECT * FROM Shows%sBookings", data.show.ID);
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                row++;

                System.out.println(rs.getString("bookingID"));
            }

            if (row == 0) {
                num = 1;
                bookingID = String.format("%s%04d", data.show.ID, num);
            } else {
                num = row++;
                bookingID = String.format("%s%04d", data.show.ID, num);
            }

//            System.out.println("Inserting data");
            sql = String.format("INSERT INTO Shows%sBookings VALUES('%s', '%s', '%s', %d, %d, %d, %f)",
                    data.show.ID, bookingID, data.phNum, data.name, data.show.goldTicks.quantity, data.show.silverTicks.quantity, data.show.bronzeTicks.quantity, totalCost);
            statement.executeUpdate(sql);

//            System.out.println("Updating data");
            sql = String.format("UPDATE ShowsInfo SET goldticket = %d, silverticket = %d, bronzeticket = %d WHERE showID = '%s'",
                    sData.goldTicks.quantity - data.show.goldTicks.quantity,
                    sData.silverTicks.quantity - data.show.silverTicks.quantity,
                    sData.bronzeTicks.quantity - data.show.bronzeTicks.quantity,
                    sData.ID);

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return bookingID;
    }
}
