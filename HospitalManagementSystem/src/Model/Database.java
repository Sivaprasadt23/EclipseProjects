package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	private String driver="com.mysql.cj.jdbc.Driver";
	private String user = "root";
	private String pass = "root@123";
	private String url = "jdbc:mysql://localhost:3306/hospital";
	private Statement statement;
	private Connection connection;
	
	public Database() {
		try {
			Class.forName(driver);
			 connection = DriverManager.getConnection(url, user, pass);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Statement getStatement() {
		return statement;
	}
	public Connection getConnection()

	{
		return connection;
	}
}
