package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import dao.LoginAdminDAO;
import dao.LoginUserDAO;
import dao.UserDetailsDAO;
import model.LoginAdmin;
import model.LoginUser;
import model.UserDetails;
import service.AdminHome;
import service.UserInput;
import service.UserPage;
import service.AdminPage;
import service.User_SignUp;
import utility.ConnectionManager;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, ParseException {
		
		while(true) {
		// ---------------------------- Home Page --------------------------------------------------------------------	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ConnectionManager con = new ConnectionManager();           // getting the connection 
	
		System.out.println("********************************************************************************************************************************************************");
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");
		System.out.println("\n\n\t\t\t\t\t\t\t\t SMART E-LOCKER \n");
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");
		System.out.println("\t\t\t\t1- SIGNUP\n\n\t\t\t\t2- LOGIN USERS\n\n\t\t\t\t3- LOGIN ADMIN\n\n\t\t\t\t4- Exit\n");
	
		System.out.println("********************************************************************************************************************************************************");
		System.out.println();
		int choice = Integer.parseInt(br.readLine());

		UserInput input = new UserInput();
		
	// ------------------ calling the objects ---------------------------------------------------
		UserDetailsDAO  userDetailsdao = new UserDetailsDAO();
		
		LoginUser loginUser = new LoginUser();
		LoginUserDAO loginUserdao = new LoginUserDAO();
		
		LoginAdmin loginAdmin = new LoginAdmin();
		LoginAdminDAO loginAdmindao = new LoginAdminDAO();
		
		UserDetailsDAO userdao = new UserDetailsDAO();
		
		String uname;
		switch(choice)
		{
		case 1: UserDetails users = input.signUp();
				userdao.insert(users);
				break;
		
		case 2:	System.out.println("Enter Username : ");
		 		 uname = br.readLine();
		 		System.out.println("Enter Password");
				String password = br.readLine();
		 		loginUser.setUsername(uname);
		 		loginUser.setPassword(password);
		 		if(loginUserdao.validate(loginUser) == true) 
		 		{
		 		//	input.loginUser();
					System.out.println("Login Successfull");
				//	AdminPage userpage= new AdminPage();
					UserPage userpage = new UserPage();
					userpage.homePage();
		 		}
				else {
		 			System.out.println("Please Enter Correct Username or Password !!!");
		 		}
				break;
		
		case 3: LoginAdmin admin = input.loginAdmin();
				if(loginAdmindao.validate(admin) == true)
				{
					System.out.println("Login Successfull");
					AdminHome adminpage = new AdminHome();
					adminpage.adminHomePage();
					
				}
				else
					System.out.println("Invalid Username or Password");
			
			
				break;
		
		case 4: System.out.println("\t\tThankyou !!!!\n\t\tVisit Again\n\n\t\tFollow Social Distance and always wear mask .");
		System.out.println("\n********************************************************************************************************************************************************");

				System.exit(1);
				break;
		
		default : System.out.println("WARNING !!!!!!!!!!\nPlease Enter Correct Option !!!!!!!!");
		}
		

	}

	}
}
