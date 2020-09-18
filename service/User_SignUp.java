package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import controller.Main;
import dao.BankDetailsDAO;
import dao.UserDetailsDAO;
import model.BankDetails;
import model.UserDetails;

public class User_SignUp {
					
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		public static void signupOp() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
			
		while(true) {

		System.out.println("\n\n\t\t\t\t WELCOME \n\n\n");
		System.out.println("Choose the operation need to performed : \n\n");
		System.out.println("\t 1-> View \n\t 2-> Update\n\t 3-> Delete\n\t 4-> View Details\n\t 5-> Logout");
		int option = Integer.parseInt(br.readLine());
		
		// object to fetch and store the data
		Main mainpage = new Main();
		UserPage user = new UserPage();
		UserInput input = new UserInput();
		UserDetailsDAO userdao = new UserDetailsDAO();
		
		switch(option)
		{
		case 1: userdao.display();
				break;
		
		case 2: UpdatePage updpage = new UpdatePage();
				updpage.updateUserDetails();
				break;
		
		case 3: System.out.println("Enter the user id to delete :");
				String id = br.readLine();
				userdao.delete(id);
				break;
		
		case 4: userdao.display();
				break;
		
		case 5: System.out.println("Thankyou");
				mainpage.main(null);
				break;
		
		default: System.out.println("WARNING !!!!\n Please choose the correct operation .");
		}
	}
		}

}
