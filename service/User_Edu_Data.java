package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import dao.EducationDataDAO;
import model.EducationData;

public class User_Edu_Data {

static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void eduOp() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
	
	while(true)	{
		
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");

		System.out.println("\n\n\t\t\t\t\t\t\t\t SMART E-LOCKER \n");
		System.out.println("\t\t\t\t\t__________________________________________________________________\n");
	System.out.println("\n\n\t\t\t\t\t\t\t\t WELCOME \n\n\n");
	System.out.println("\t\t\t\t\t__________________________________________________________________\n");

	System.out.println("Choose the operation need to performed : \n\n");
	System.out.println("\t 1-> Insert\n\t 2-> Update\n\t 3-> Delete\n\t 4-> View Details\n\t 5-> Logout");
	int option = Integer.parseInt(br.readLine());
	
	// object to fetch and store the data
	
	UserPage user = new UserPage();
	UserInput input = new UserInput();
	EducationDataDAO edudao = new EducationDataDAO();

	
	switch(option)
	{
	case 1: EducationData edu = input.educationDetails();
			edudao.insert(edu);
			break;
	
	case 2: UpdatePage page = new UpdatePage();
			page.updateEduDetails();

			break;
	
	case 3: System.out.println("Enter the ID to be deleted : ");
			String id = br.readLine();
			edudao.delete(id);
			break;
	
	case 4: System.out.println("Enter user ID:");
			String uid = br.readLine();
			edudao.displayUserEducation(uid);
			break;
	
	case 5: System.out.println("Thankyou");
			user.homePage();
			break;
	
	default: System.out.println("WARNING !!!!\n Please choose the correct operation .");
	}
	
	}
}
}
