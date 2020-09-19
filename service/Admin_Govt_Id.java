package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import dao.BankDetailsDAO;
import dao.GovernmentDataDAO;
import model.BankDetails;
import model.GovernmentData;

public class Admin_Govt_Id {
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		public static void govtOp() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
		
		while(true) {
			System.out.println("\t\t\t\t\t__________________________________________________________________\n");
			System.out.println("\n\n\t\t\t\t\t\t\t\t SMART E-LOCKER \n");
			System.out.println("\t\t\t\t\t__________________________________________________________________\n");
		System.out.println("\n\n\t\t\t\t\t\t\t\t WELCOME \n\n\n");
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");
		System.out.println("Choose the operation need to performed : \n\n");
		System.out.println("\t 1-> Insert\n\t 2-> Update\n\t 3-> Delete\n\t 4-> View Details\n\t 5-> Logout");
		int option = Integer.parseInt(br.readLine());
		
		AdminPage user = new AdminPage();
		UserInput input = new UserInput();
		GovernmentDataDAO  governmentDatadao = new GovernmentDataDAO();

		
		
		switch(option)
		{
		case 1: GovernmentData gdata = input.governmentData();
				governmentDatadao.insert(gdata);
				break;
		
		case 2: UpdatePage page = new UpdatePage();
				page.updateGovernmentData();
				break;
		
		case 3: System.out.println("Enter the Government ID to delete :");
				String id= br.readLine();
				governmentDatadao.delete(id);
				break;
		
		case 4: governmentDatadao.display();
				break;
		
		case 5: System.out.println("Thankyou");
				user.homePage();
				break;
		
		default: System.out.println("WARNING !!!!\n Please choose the correct operation .");
		}
		
		}
	}
}
