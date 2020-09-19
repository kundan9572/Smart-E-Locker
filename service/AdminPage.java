package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import controller.Main;
import dao.UserDetailsDAO;
import model.EducationData;



public class AdminPage {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void homePage() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
		
		while(true) {
			System.out.println("\t\t\t\t\t__________________________________________________________________\n");
			System.out.println("\n\n\t\t\t\t\t\t\t\t SMART E-LOCKER \n");
			System.out.println("\t\t\t\t\t__________________________________________________________________\n");	
	    System.out.println("\t\t________________________________________________________________\n");
		System.out.println("\t\t\t\t\t\t ADMIN MENU \n\n");
		System.out.println("\t\t________________________________________________________________\n");
		System.out.println("\t\tChoose the operation :\n");
		System.out.println("\t 1->  Government ID Or Card Details\n\t 2->  Education Details\n\t 3->  Bank Details\n\t 4->  Social Media or Email Account Details\n\t 5->  Insurance Details\n\t 6->  Search Profile\n\t 7->  Logout");
		
		int choice = Integer.parseInt(br.readLine());
		
		UserInput input = new UserInput();
		Main mainpage = new Main();
		UserDetailsDAO udao = new UserDetailsDAO();
		
		switch(choice)
		{
		case 1: Admin_Govt_Id govObject = new Admin_Govt_Id();
				govObject.govtOp();
				break;
		
		case 2: Admin_Edu_Data eduObject = new Admin_Edu_Data();
				eduObject.eduOp();
				break;
		
		case 3: Admin_Bank_Details bankObject = new Admin_Bank_Details();
				bankObject.bankOp();
				break;
		
		case 4: Admin_Online_Accounts accObjects = new Admin_Online_Accounts();
				accObjects.accountOp();
			//	input.onlineAccount();
				break;
		
		case 5: Admin_Insurance_Op insuranceObject = new Admin_Insurance_Op();
				insuranceObject.insuranceOp();
			//	input.insurance();
				break;
		
		case 6: System.out.println("Enter User ID");
				String userId = br.readLine();
				udao.showUser(userId);
				break;
		
		case 7: System.out.println("Thankyou");
				AdminHome admin = new AdminHome();
				admin.adminHomePage();
			//	mainpage.main(null);
				break;
				
		default : System.out.println("WARNING !!!!\n You have choosen wrong choice . ");
		}
		
		}
	}
	
}
