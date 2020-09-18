package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import controller.Main;
import model.EducationData;



public class UserPage {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void homePage() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
		
		while(true) {
			
		
		System.out.println("\t\t\t\t WELCOME \n\n\n\n\n");
		System.out.println("What you want  to add :\n\n");
		System.out.println("\t 1->  Government ID Or Card Details\n\t 2->  Education Details\n\t 3->  Bank Details\n\t 4->  Social Media or Email Account Details\n\t 5->  Insurance Details\n\t 6->  Other Details(Images/Video)\n\t 7->  Logout");
		
		int choice = Integer.parseInt(br.readLine());
		
		UserInput input = new UserInput();
		Main mainpage = new Main();
		
		
		switch(choice)
		{
		case 1: User_Govt_Id govObject = new User_Govt_Id();
				govObject.govtOp();
				break;
		
		case 2: User_Edu_Data eduObject = new User_Edu_Data();
				eduObject.eduOp();
				break;
		
		case 3: User_Bank_Details bankObject = new User_Bank_Details();
				bankObject.bankOp();
				break;
		
		case 4: User_Online_Accounts accObjects = new User_Online_Accounts();
				accObjects.accountOp();
				input.onlineAccount();
				break;
		
		case 5: User_Insurance_Op insuranceObject = new User_Insurance_Op();
				insuranceObject.insuranceOp();
				input.insurance();
				break;
		
		case 6: input.others();
				break;
		
		case 7: System.out.println("Thankyou");
				mainpage.main(null);
				break;
				
		default : System.out.println("WARNING !!!!\n You have choosen wrong choice . ");
		}
		
		}
	}
	
}
