# JDBC_Assignment2

SQL: 2a

SHOW CREATE TABLE `sqlandjava`.`cars`;
SELECT * FROM `sqlandjava`.`cars` LIMIT 1000;
SHOW CREATE TABLE `sqlandjava`.`cars`;
INSERT INTO `sqlandjava`.`cars` (`car_id`, `brand`, `color`) VALUES ('1', 'Volvo', 'Black');
SELECT `car_id`, `brand`, `color` FROM `sqlandjava`.`cars` WHERE  `car_id`=1;
INSERT INTO `sqlandjava`.`cars` (`car_id`, `brand`, `color`) VALUES ('2', 'Saab', 'Blue');
SELECT `car_id`, `brand`, `color` FROM `sqlandjava`.`cars` WHERE  `car_id`=2;
INSERT INTO `sqlandjava`.`cars` (`car_id`, `brand`, `color`) VALUES ('3', 'Audi', 'Red');
SELECT `car_id`, `brand`, `color` FROM `sqlandjava`.`cars` WHERE  `car_id`=3;
INSERT INTO `sqlandjava`.`cars` (`car_id`, `brand`, `color`) VALUES ('4', 'Ford ', 'Green');
SELECT `car_id`, `brand`, `color` FROM `sqlandjava`.`cars` WHERE  `car_id`=4;

CREATE USER user@localhost IDENTIFIED BY 'password';
GRANT SELECT ON sqlandjava.cars TO user@localhost;


JAVA: 2b

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

Connected to Database!
1:Volvo Black
2:Saab Blue
3:Audi Red
4:Ford  Green

