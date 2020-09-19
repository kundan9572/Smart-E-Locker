package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import dao.BankDetailsDAO;
import model.BankDetails;

public class User_Bank_Details {

static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void bankOp() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
	
	while(true) {
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");
		System.out.println("\n\n\t\t\t\t\t\t\t\t SMART E-LOCKER \n");
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");
	System.out.println("_______________________________________________________________________________________________\n");
	System.out.println("\n\n\t\t\t\t BANK  \n\n");
	System.out.println("_______________________________________________________________________________________________\n");

	System.out.println("Choose the operation need to performed : \n\n");
	System.out.println("\t 1-> Insert\n\t 2-> Update\n\t 3-> Delete\n\t 4-> View Details\n\t 5-> Logout");
	int option = Integer.parseInt(br.readLine());
	
	// object to fetch and store the data
	
	UserPage user = new UserPage();
	UserInput input = new UserInput();
	BankDetailsDAO bankDetailsdao = new BankDetailsDAO();

	
	switch(option)
	{
	case 1: BankDetails details = input.bankDetails();
			bankDetailsdao.insert(details);
			break;
	
	case 2: UpdatePage page = new UpdatePage();
			page.updateBank();
			break;
	
	case 3: System.out.println("Enter the ID you want to delete");
			String id = br.readLine();
			bankDetailsdao.delete(id);
			break;
	
	case 4: System.out.println("Enter User Id : ");
			String uid = br.readLine();
		//	bankDetailsdao.display();
			bankDetailsdao.displayUserBank(uid);
			break;
	
	case 5: System.out.println("Thankyou");
			user.homePage();
			break;
	
	default: System.out.println("WARNING !!!!\n Please choose the correct operation .");
	}
	
	}
}
}
