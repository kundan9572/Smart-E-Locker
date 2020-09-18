package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import dao.BankDetailsDAO;
import dao.EducationDataDAO;

public class AdminHome {
	public static void adminHomePage() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
		
		while(true) {
			
		
		System.out.println("\n\n\t\t\tWelcome\n\n\n\n");
		System.out.println("\t\t 1- View User Data\n\t\t 2- View  users data and Bank Details\n\t\t 3- View  users data and Government Details\n"
			+ "\t\t 4- View users  and Education Data\n\t\t 5- View users  and Online Account Details\n\t\t"
			+ " 6- View users data and User Insurance Details\n\t\t 7- View all User Details\n\t\t 8- Logout");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter want you want to see : ");
		int choice = Integer.parseInt(br.readLine());
		
		String id;
		
		switch(choice)
		{
		case 1: UserPage userpage1 = new UserPage();
				userpage1.homePage();
				break;
		
		case 2:// System.out.println("Enter the user ID : ");
				//id = br.readLine();
				BankDetailsDAO bank = new BankDetailsDAO();
				bank.userBank();
				break;
		
		case 3: 
				break;
		
		case 4: EducationDataDAO edudao = new EducationDataDAO();
				edudao.userEducation();
				break;
		
		case 5: break;
		
		case 6: break;
		
		case 7: break;
		
		case 8: break;
		
		default : System.out.println("Invalid Choice !!!!!!!!!!1");
		
		}
	}
	}
}
