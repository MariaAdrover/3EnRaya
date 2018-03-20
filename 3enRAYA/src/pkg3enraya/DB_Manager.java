package pkg3enraya;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!
public class DB_Manager {

    
    public DB_Manager() {
        /// Crear la conexión
        Connection conn;
        Statement stmt;
        ResultSet rs;
        
         
        // Conectar ??
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations
            System.out.println("Conectando...");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        
        //DB_Manager manager = new DB_Manager;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ranking?autoReconnect=true&useSSL=false&user=root&password=123456");
            // Do something with the Connection

            // Crear el Statement
            stmt = conn.createStatement();  

            // Creamos la consulta
            // stme.execute para INSERT y UPDATE            
            //rs = stmt.executeQuery("INSERT INTO sesion VALUES (1,2,3,4,5,6);");
            
            rs = stmt.executeQuery("SELECT * FROM sesion;");
            ResultSetMetaData rsmd = rs.getMetaData();
            //System.out.println("INSERT INTO sesion VALUES (1,2,3,4,5,6)");
            System.out.println("SELECT * FROM sesion;");
            System.out.println("");
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) {
                        System.out.print(",  ");
                    }
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }

            System.out.println(rs);
            } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
