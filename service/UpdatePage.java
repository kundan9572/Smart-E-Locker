package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

import dao.BankDetailsDAO;
import dao.EducationDataDAO;
import dao.GovernmentDataDAO;
import dao.OnlineAccountsDAO;
import dao.UserDetailsDAO;
import dao.UserInsuranceDAO;

public class UpdatePage {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	// ----------------------------------------- USER DETAILS UPDATION ------------------------------------------------

	public static void updateUserDetails() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");
		System.out.println("\n\n\t\t\t\t\t\t\t\t SMART E-LOCKER \n");
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");
		System.out.println("Select what you want to update( userid,first name,last name, date of birth and username cannot be updated ) :\n\n\n ");
		System.out.println("\t\t 1- Update Password\n\t\t 2- Update Mobile Number\n\t\t 3- Update Email Id\n\t\t 4- Update city\n\t\t"
				+ " 5- Update State\n\t\t 6- Update Pincode\n\t\t 7- Update Complete address\n\t\t 8- Exit");
		int choice =Integer.parseInt(br.readLine());
		
		UserDetailsDAO users = new UserDetailsDAO();
		String id;
		
		switch(choice)
		{
		case 1: System.out.println("Enter user Id");
				id=br.readLine();
				System.out.println("Enter New Password :");
				String password = br.readLine();
				users.updatePassword(id,password);
				break;
		
		case 2: System.out.println("Enter user Id");
				id=br.readLine();
				System.out.println("Enter New Mobile Number :");
				Long mobile = Long.parseLong(br.readLine());
				users.updateMobile(id,mobile);
				break;
		
		case 3: System.out.println("Enter user Id");
				id=br.readLine();
				System.out.println("Enter New Email ID :");
				String email = br.readLine();
				users.updateEmail(id,email);
				break;
		
		case 4: System.out.println("Enter user Id");
				id=br.readLine();
				System.out.println("Enter New City :");
				String city = br.readLine();
				users.updateCity(id,city);
				break;
		
		case 5: System.out.println("Enter user Id");
				id=br.readLine();
				System.out.println("Enter New State :");
				String state = br.readLine();
				users.updateState(id,state);
				break;
		
		case 6: System.out.println("Enter user Id");
				id=br.readLine();
				System.out.println("Enter New Pincode :");
				Long pincode = Long.parseLong(br.readLine());
				users.updatePinCode(id,pincode);
				break;
				
		case 7: System.out.println("Enter user ID : ");
				id=br.readLine();
				System.out.println("Enter new city");
				String ncity = br.readLine();
				System.out.println("Enter new State : ");
				String nstate= br.readLine();
				System.out.println("Enter new Pincode : ");
				Long npin = Long.parseLong(br.readLine());
				users.updateAddress(id,ncity,nstate,npin);
		
		case 8: System.out.println("Thankyou !!!!!!!!!!!");
				break;
		
		default: System.out.println("Invalid Choice");
		}
		
	}
	
	// --------------------------------- BANK DETAILS UPDATION --------------------------------------------------------
	
	public static void updateBank() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
		System.out.println("Select what you want to update(ID,Bank name, Account Number, ifsc cannot be update) : ");
		System.out.println("\t\t 1- Update Bank Type\n\t\t 2- Update NetBanking Id\n\t\t 3- Update Password\n\t\t 4- Logout");
		int choice = Integer.parseInt(br.readLine());
		
		Admin_Bank_Details bank = new Admin_Bank_Details();
		BankDetailsDAO bankdao = new BankDetailsDAO();
		String id;
		
		switch (choice)
		{
		case 1: System.out.println("Enter the Bank Id :");
				id=br.readLine();
				System.out.println("Enter  new Bank Type :");
				String type = br.readLine();
				bankdao.updateBankType(id,type);
				break;
		
		case 2: System.out.println("Enter the Bank Id :");
				id=br.readLine();
				System.out.println("Enter New NetBanking ID :");
				String netBankId = br.readLine();
				bankdao.updateNetBankingId(id,netBankId);
				break;
		
		case 3: System.out.println("Enter the Bank Id :");
				id=br.readLine();
				System.out.println("Enter New Password  :");
				String password = br.readLine();
				bankdao.updatePassword(id,password);
				break;
		
		case 4: System.out.println("Thanks for updating data .");
				bank.bankOp();
				break;
		
		default : System.out.println("Invalid Choice !!!!!!");
		}
	}
	
	// -------------------------------- EDUCATION DETAILS UPDATIONS -----------------------------------------------

	public void updateEduDetails() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
		System.out.println("Select what you want to update( ID and User ID cannot be updated .):");
		System.out.println("\t\t 1- Update Education Type\n\t\t 2- Update Education Board or University Name\n\t\t 3- Update Registration Number\n\t\t 4- Update Marks\n\t\t 5- Update Passing Year\n\t\t 6- Exit");
		int choice = Integer.parseInt(br.readLine());
		EducationDataDAO edudao = new EducationDataDAO();
		String id;
		
		
		switch(choice)
		{
		case 1: System.out.println("Enter Educational Id");
				id= br.readLine();
				System.out.println("Enter New Education Type:");
				String type = br.readLine();
				edudao.updateeduType(id,type);
				break;
		
		case 2: System.out.println("Enter Educational Id");
				id= br.readLine();
				System.out.println("Enter New Education Board or University:");
				String board = br.readLine();
				edudao.updateBoard(id,board);
				break;
		
		case 3: System.out.println("Enter Educational Id");
				id= br.readLine();
				System.out.println("Enter New Registration Number:");
				String regNum = br.readLine();
				edudao.updteRegistrationNumber(id,regNum);
				break;
		
		case 4: System.out.println("Enter Educational Id");
				id= br.readLine();
				System.out.println("Enter New Marks:");
				int marks = Integer.parseInt(br.readLine());
				edudao.updateMarks(id,marks);
				break;
		
		case 5: System.out.println("Enter Educational Id");
				id= br.readLine();
				System.out.println("Enter New  date of passingr:");
				String dop = br.readLine();
				LocalDate date = LocalDate.parse(dop);
				edudao.updateYearOfPassing(id,date);
				break;
		
		case 6: System.out.println("Thanks for updating data .");
				Admin_Edu_Data edu = new Admin_Edu_Data();
				edu.eduOp();
				break;
		
		 default: System.out.println("Invalid Choice");;
		
		}
	}

	//--------------------------- UPDATE GOVERNMENT DATA -------------------------------------------------------
	public void updateGovernmentData() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
		System.out.println("Select what you want to update(ID and user id cannot be updated ):");
		System.out.println("\t\t 1- Update ID Type\n\t\t 2- Update Card Number\n\t\t 3- Update Validity\n\t\t 4- Update Issuer Organization\n\t\t 5- Exit");
		
		int choice = Integer.parseInt(br.readLine());
		String id;
		GovernmentDataDAO govdao = new GovernmentDataDAO();
		
		switch(choice)
		{
		case 1: System.out.println("Enter Government Id");
				id= br.readLine();
				System.out.println("Enter New ID Type:");
				String type = br.readLine();
				govdao.updateGovtIDType(id,type);
				break;
		
		case 2: System.out.println("Enter Government Id");
				id= br.readLine();
				System.out.println("Enter New Card Number:");
				String cardNum = br.readLine();
				govdao.updateCardNumber(id,cardNum);
				break;

		case 3: System.out.println("Enter Government Id");
				id= br.readLine();
				System.out.println("Enter New Validity:");
				String validity = br.readLine();
				LocalDate date = LocalDate.parse(validity);
				govdao.updateValidity(id,date);
				break;

		case 4:  System.out.println("Enter Government Id");
				id= br.readLine();
				System.out.println("Enter New Issuer Organization:");
				String issuer = br.readLine();
				govdao.updateIssuerName(id,issuer);
				break;

		case 5: System.out.println("Thanks for Updating data .");
				Admin_Govt_Id gid= new Admin_Govt_Id();
				gid.govtOp();
				break;

		default: System.out.println("Invalid Choice !!!!!!!!!!!!!!!!111");
		
		}
		
	}
	
	// ----------------------------- updating Social media accounts -----------------------------------------

	public void UpdateOnlineAccount() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Select what you want to update(ID and user id cannot be updated ):");
		System.out.println("\t\t 1- Update Account Type\n\t\t 2- Update User Name\n\t\t 3- Update Password\n\t\t 4- Exit");
		
		int choice = Integer.parseInt(br.readLine());
		String id;
		OnlineAccountsDAO online = new OnlineAccountsDAO();
		
		
		switch(choice)
		{
		case 1: System.out.println("Enter Social Media Account Id");
				id= br.readLine();
				System.out.println("Enter New Account Type:");
				String type = br.readLine();
				online.updateAccountType(id,type);
				break;
		
		case 2: System.out.println("Enter Social Media Account Id");
				id= br.readLine();
				System.out.println("Enter New Username :");
				String uname = br.readLine();
				online.updateUsername(id,uname);
				break;
		
		case 3: System.out.println("Enter Social Media Account Id");
				id= br.readLine();
				System.out.println("Enter New Password :");
				String password = br.readLine();
				online.updatePassword(id,password);
				break;
		
		case 4: break;
		
		default :System.out.println("Invalid Choice");
		}
		
	}

	// ----------------------------------- Updating Insurance -------------------------------------------------
	
	public void updateInsurance() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
		
		System.out.println("Select what you want to update(ID and user id cannot be updated ):");
		System.out.println("\t\t 1- Update Insurance Type\n\t\t 2- Update Insurance Number\n\t\t 3- Update Start Date\n\t\t 4- Update End date\n\t\t 5- Exit");

		int choice = Integer.parseInt(br.readLine());
		String id;
		UserInsuranceDAO insurancedao = new UserInsuranceDAO();
		
		switch(choice)
		{
		case 1:  System.out.println("Enter Insurance  Id");
				id= br.readLine();
				System.out.println("Enter New Insurance Type:");
				String type = br.readLine();
				insurancedao.updateInsuranceType(id,type);
				break;
		
		case 2:  System.out.println("Enter Insurance  Id");
				id= br.readLine();
				System.out.println("Enter New Insurance Number:");
				String number = br.readLine();
				insurancedao.updateInsuranceNumber(id,number);
				break;
		
		case 3:  System.out.println("Enter Insurance  Id");
				 id= br.readLine();
				 System.out.println("Enter New Start Date :");
				 String startdate = br.readLine();
				 LocalDate sdate = LocalDate.parse(startdate);
				 insurancedao.updateStartDate(id,sdate);
				 break;
		
		case 4: System.out.println("Enter Insurance  Id");
		 		id= br.readLine();
		 		System.out.println("Enter New End Date:");
		 		String enddate = br.readLine();
		 		LocalDate edate = LocalDate.parse(enddate);
		 		insurancedao.updateEndDate(id,edate);
				break;
		
		case 5: Admin_Insurance_Op user = new Admin_Insurance_Op();
				user.insuranceOp();
				break;
		
		default : System.out.println("Invalid Choice !!!!!!!!!!!");
		}
		
	}
	
	
}
