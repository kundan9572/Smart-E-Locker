package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import dao.BankDetailsDAO;
import dao.OnlineAccountsDAO;
import model.BankDetails;
import model.OnlineAccounts;

public class User_Online_Accounts {

static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void accountOp() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
	
	while(true) {
		
	
	System.out.println("\n\n\t\t\t\t WELCOME \n\n\n");
	System.out.println("Choose the operation need to performed : \n\n");
	System.out.println("\t 1-> Insert\n\t 2-> Update\n\t 3-> Delete\n\t 4-> View Details\n\t 5-> Logout");
	int option = Integer.parseInt(br.readLine());
	
	// object to fetch and store the data
	
	UserPage user = new UserPage();
	UserInput input = new UserInput();
	OnlineAccountsDAO accountsdao = new OnlineAccountsDAO();
	
	switch(option)
	{
	case 1: OnlineAccounts accounts = input.onlineAccount();
			accountsdao.insert(accounts);
			break;
	
	case 2: UpdatePage page = new UpdatePage();
			page.UpdateOnlineAccount();
			break;
	
	case 3: System.out.println("Enter the id to delete");
			String id = br.readLine();
			accountsdao.delete(id);
			break;
	
	case 4: accountsdao.display();
			break;
	
	case 5: System.out.println("Thankyou");
			user.homePage();
			break;
	
	default: System.out.println("WARNING !!!!\n Please choose the correct operation .");
	}
}

	}
}
