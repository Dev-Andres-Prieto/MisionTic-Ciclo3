package connection;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection connection;
    static String bd = "carrental";
    static String port = "3306"; 
    static String login = "root";
    static String password = "admin";
    
    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:"+this.port+"/"+this.bd;
            //String url = "jdbc:mysql://"+this.ip+":"+this.port+"/"+this.bd;
            connection = DriverManager.getConnection(url,this.login, this.password);
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            System.out.println("Error en la conexión " + e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void desconectar(){
        connection = null;
    }  
}
