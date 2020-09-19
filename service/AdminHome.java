package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import controller.Main;
import dao.BankDetailsDAO;
import dao.EducationDataDAO;
import dao.GovernmentDataDAO;
import dao.OnlineAccountsDAO;
import dao.UserDetailsDAO;
import dao.UserInsuranceDAO;

public class AdminHome {
	public static void adminHomePage() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
		
		while(true) {
			
		System.out.println("************************************************************************************************************************************************************");
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");

		System.out.println("\n\n\t\t\t\t\t\t\t\t SMART E-LOCKER \n");
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");
		
		System.out.println("\t\t________________________________________________________________\n");

		System.out.println("\n\t\t\t\t\tADMIN MENU\n");
		System.out.println("\t\t________________________________________________________________\n");
		System.out.println("\t\t\tChoose the operation you want to perform  : ");

		System.out.println("");
		
		System.out.println("\t\t 1- View User Data\n\t\t 2- CRUD on Users\n\t\t 3- View  users data and Bank Details\n\t\t 4- View  users data and Government Details\n"
			+ "\t\t 5- View users  and Education Data\n\t\t 6- View users  and Online Account Details\n\t\t"
			+ " 7- View users data and User Insurance Details\n\t\t 8- View all User Details\n\t\t 9- Total Number of Users\n\t\t"
			+ " 10-Total Number OF Government ID\n\t\t 11-Total Number of Education Data\n\t\t 12-Total Number of Bank Details\n\t\t"
			+ " 13-Total Number of User Social Media or Email Accounts\n\t\t 14-Logout");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = Integer.parseInt(br.readLine());
		
		String id;
		Main mainpage = new Main();

		switch(choice)
		{
		case 1: AdminPage userpage1 = new AdminPage();
				userpage1.homePage();
				break;
				
		case 2:	User_SignUp  usp= new User_SignUp();
				usp.signupOp();
				
		case 3:// System.out.println("Enter the user ID : ");
				//id = br.readLine();
				BankDetailsDAO bank = new BankDetailsDAO();
				bank.userBank();
				break;
		
		case 4: GovernmentDataDAO govdao = new GovernmentDataDAO();
				govdao.userGovernment();
				break;
		
		case 5: EducationDataDAO edudao = new EducationDataDAO();
				edudao.userEducation();
				break;
		
		case 6: OnlineAccountsDAO accdao = new OnlineAccountsDAO();
				accdao.userOnlineAccounts();
				break;
		
		case 7: UserInsuranceDAO userins = new UserInsuranceDAO();
				userins.userInsurance();
				break;
		
		case 8: UserDetailsDAO usr = new UserDetailsDAO();
				usr.display();
				break;
		
		case 9: UserDetailsDAO user = new UserDetailsDAO();
				user.countUser();
				break;

		
		case 10: GovernmentDataDAO govt = new GovernmentDataDAO();
				govt.countGovtData();
				break;

		case 11: EducationDataDAO educationdao = new EducationDataDAO();
				educationdao.countEduIDDetails();
				break;

		case 12: BankDetailsDAO badao = new BankDetailsDAO();
				badao.countBankID();
				break;

		case 13: OnlineAccountsDAO socacc = new OnlineAccountsDAO();
				socacc.countID();
				break;

		
		case 14: System.out.println("Thankyou");
				mainpage.main(null);
				break;
		
		default : System.out.println("Invalid Choice !!!!!!!!!!1");
		
		}
	}
	}
}
