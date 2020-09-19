package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import dao.EducationDataDAO;
import dao.UserInsuranceDAO;
import model.EducationData;
import model.UserInsurance;

public class Admin_Insurance_Op {

	public static void insuranceOp() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
		
		while(true) {
			
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");
	    System.out.println("\n\n\t\t\t\t\t\t\t\t SMART E-LOCKER \n");
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");
		System.out.println("\n\n\t\t\t\t\\t\t\t\t WELCOME \n\n\n");
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");
		System.out.println("Choose the operation need to performed : \n\n");
		System.out.println("\t 1-> Insert\n\t 2-> Update\n\t 3-> Delete\n\t 4-> View Details\n\t 5-> Logout");
		int option = Integer.parseInt(br.readLine());
		
		// object to fetch and store the data
		
		AdminPage user = new AdminPage();
		UserInput input = new UserInput();
		UserInsuranceDAO insurancedao  = new UserInsuranceDAO();

		
		switch(option)
		{
		case 1: UserInsurance insu = input.insurance();
				insurancedao.insert(insu);
				break;
		
		case 2: UpdatePage page = new UpdatePage();
				page.updateInsurance();
				break;
		
		case 3: System.out.println("Enter the id you want to delete :");
				String id = br.readLine();
				insurancedao.delete(id);
				break;
		
		case 4: insurancedao.display();
				break;
		
		case 5: System.out.println("Thankyou");
				user.homePage();
				break;
		
		default: System.out.println("WARNING !!!!\n Please choose the correct operation .");
		}
	}
	}
}
