package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Database;
import Model.Patient;

public class CreatePatient {
	
	private Patient p;
	private Database database;
	//private Connection con;
	
	public CreatePatient(Patient p, Database database) {
		this.p = p;
		this.database = database;
	}
	
	public boolean isCreated() {
		boolean created = false;
		String insert = "insert into patients(FirstName,LastName,Email,PhoneNumber,Password,BloodGroup) values(?,?,?,?,?,?);";
		try {
			Connection con = database.getConnection(); // Make sure this method exists in your Database class
			System.out.println("Prepared SQL: " + insert);
			System.out.println("Length: " + insert.length());

			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, p.getFirstName());
			ps.setString(2, p.getLastName());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getPhoneNumber());
			ps.setString(5, p.getPassword());
			ps.setString(6, p.getBloodGroup());
			
			ps.executeUpdate();
			created = true;
		} catch (SQLException e) {
			e.printStackTrace();
			created = false;
		}
		return created;
	}

}
