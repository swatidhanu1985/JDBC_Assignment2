package sqlandjava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Assignment2 {
	
	public static Connection getConnection() throws Exception {
		try {
			String url = "jdbc:mysql://localhost:3306/sqlandjava";
			String username = "user";
			String password = "password";
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected to Database!");
			return conn;
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        Connection conn = getConnection();
        
        Statement statement = conn.createStatement();
        
        ResultSet res = statement.executeQuery("Select * from cars");
        
        while(res.next()) {
        	System.out.println(res.getString("car_id")+ ":" + res.getString("brand")+" "+ res.getString("color"));
        }
	}

}

