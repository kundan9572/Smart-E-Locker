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
import service.User_SignUp;
import utility.ConnectionManager;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, ParseException {
		
		while(true) {
			
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ConnectionManager con = new ConnectionManager();
	//	con.getConnection();
		System.out.println("********************************************************************************************************************************************************");
		System.out.println("\n\n\t\t\t\t\t\t\t\t WELCOME \n\n\n");
		
		System.out.println("\t\t\t\t1- SIGNUP\n\n\t\t\t\t2- LOGIN USERS\n\n\t\t\t\t3- LOGIN ADMIN\n\n\t\t\t\t4- VIEW Profile\n\n\t\t\t\t5- Exit\n");
	
		System.out.println("********************************************************************************************************************************************************");
		System.out.println();
		int choice = Integer.parseInt(br.readLine());

		UserInput input = new UserInput();
		
	//	UserDetails  userDetails = new UserDetails();
		UserDetailsDAO  userDetailsdao = new UserDetailsDAO();
		
		LoginUser loginUser = new LoginUser();
		LoginUserDAO loginUserdao = new LoginUserDAO();
		
		LoginAdmin loginAdmin = new LoginAdmin();
		LoginAdminDAO loginAdmindao = new LoginAdminDAO();
		
		UserDetailsDAO userdao = new UserDetailsDAO();
		
		
		switch(choice)
		{
		case 1: UserDetails users = input.signUp();
				userdao.insert(users);
				break;
		
		case 2:	UserPage userpage= new UserPage();
				userpage.homePage();
//				System.out.println("Enter Username : ");
//		 		String uname = br.readLine();
//		 		System.out.println("Enter Password");
//				String password = br.readLine();
//		 		loginUser.setUsername(uname);
//		 		loginUser.setPassword(password);
//		 		if(loginUserdao.validate(loginUser) == true) 
//		 		{
//		 		//	input.loginUser();
//					System.out.println("Login Successfull");
//					UserPage userpage= new UserPage();
//					userpage.homePage();
//		 		}
//				else {
//		 			System.out.println("Please Enter Correct Username or Password !!!");
//		 		}
//				break;
		
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
				
		case 4: User_SignUp signup = new User_SignUp();
				signup.signupOp();
				break;
		
		case 5: System.out.println("\t\tThankyou !!!!\n\t\tVisit Again");
				System.exit(1);
				break;
		
		default : System.out.println("WARNING !!!!!!!!!!\nPlease Enter Correct Option !!!!!!!!");
		}
		
	}
	}
}
