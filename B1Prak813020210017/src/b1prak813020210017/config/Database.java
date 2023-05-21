/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1prak813020210017.config;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class Database {
    private static Connection con;
    public static Connection getConnection() {
        if (con == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setDatabaseName("db_praktikum");
            dataSource.setUser("root");
            dataSource.setPassword("");

            try {
                con = dataSource.getConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return con;
    }
    
    public static void closeConnection(){
        try{
            con.close();
        }catch (SQLException exc){
            System.out.println("FAILED TO CLOSE DATABASE CONNECTION : " + exc.getMessage());
        }
    }
}

