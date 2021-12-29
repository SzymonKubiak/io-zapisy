package AppStart;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
	
	private static boolean driverInitialized = false;
	
	public static Connection connect() {
		if(!driverInitialized) initializeDriver();
		String DBURL = "jdbc:mysql://127.0.0.1:3306/io_zapisy";
	 	String DBUSER = "root";
	 	String DBPASS = "root";

	 	Connection connection = null;
	 	try {
			connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
	 	return connection;
	}
	
	private static void initializeDriver() {
	 	String DBDRIVER = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(DBDRIVER).getDeclaredConstructor(null).newInstance(null);
			driverInitialized = true;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static ResultSet executeQuery(String query) {
		Connection con = DatabaseConnector.connect();
		ResultSet res = null;
		try {
			Statement st = con.createStatement();
			res = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static int executeUpdate(String query) {
		Connection con = DatabaseConnector.connect();
		int res = -1;
		try {
			Statement st = con.createStatement();
			res = st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
