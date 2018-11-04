package stoplimit1;
//

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class go {

    public static Connection con;
    public static ResultSet rs;

    public void SetConnection() {//olkiasjuvg // (482, 295);
        try {

// first step Load Driver 

            //Class.forName("oracle.jdbc.driver.OracleDriver");
            // secend step Connection 
            
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/stoplimit", "yaakoubox", "yaakoub0602");
            
                    
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void addGoalPrice(String GOAL_PRICE) {

        SetConnection();
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("select goal_price from coin where ID_COIN=1");
            rs = stmt.executeQuery();
            if (rs.next()) {
                stmt = con.prepareStatement("update COIN set GOAL_PRICE =" + GOAL_PRICE + " where ID_COIN=1");
                stmt.executeUpdate();
            } else {
                stmt = con.prepareStatement("insert into COIN values( 1 , " + GOAL_PRICE + ")");
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void add(String Coin_Symbole, float Price_Of_Buy, float Stop_limit_price, float Now_Price, String Traed_with, float perrcentage) {

        SetConnection();
        PreparedStatement stmt;

        try {
            //if (Get("coin_id").equals("1")) {
                stmt = con.prepareStatement("select coin_id from coin where coin_id = 1");
                rs = stmt.executeQuery();
                stmt = con.prepareStatement("insert into coin values( "
                        + "'" + Coin_Symbole + "',"
                        + Price_Of_Buy + ","
                        + Stop_limit_price + ","
                        + Now_Price + ","
                        + getId() + ","
                        + "'" + Traed_with + "',"
                        + perrcentage + ")");
                stmt.executeUpdate();
           // }

        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String chekName() {

        SetConnection();
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("select name from coinname where name_id = 1");
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String Get(String coulum) {

        SetConnection();
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("select " + coulum + " from coin where coin_id = 1");
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public int getId() {
        SetConnection();
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("SELECT count(coin_id) FROM coin");
            rs = stmt.executeQuery();
            if (rs.next()) {
                return Integer.parseInt(rs.getString(1)) + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }
    public void delete(){
     SetConnection();
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("DELETE FROM COIN where PRICE_OF_BUY > 0 ");
             stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

}
