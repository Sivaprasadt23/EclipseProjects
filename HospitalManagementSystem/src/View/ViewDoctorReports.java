package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.ReadDoctorReports;
import Model.Database;
import Model.Doctor;
import Model.Option;
import Model.Report;
import Model.User;

public class ViewDoctorReports implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		ArrayList<Report> reports = new ReadDoctorReports(
				(Doctor) u, database).getReports();
		System.out.println("------------------------------------");
		for (Report r : reports) {
			System.out.println("ID:\t\t"+r.getID());
			System.out.println("Doctor:\t\t"+r.getDoctor().getName());
			System.out.println("Patient:\t"+r.getPatient().getName());
			System.out.println("Date Time:\t"+r.getDateTime());
			System.out.println("Diagnosis:\t"+r.getDiagnosis());
			System.out.println("Treatment:\t"+r.getTreatment());
			System.out.println("Paid:\t\t"+r.isPaid());
			System.out.println("------------------------------------");
		}
	}

	@Override
	public String getName() {
		return "View My(Doctor) Reports";
	}

}
