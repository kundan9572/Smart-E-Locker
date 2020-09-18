	
	package service;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.sql.SQLException;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.time.LocalDate;
	import java.util.Date;

	import dao.BankDetailsDAO;
	import dao.GovernmentDataDAO;
	import dao.UserDetailsDAO;
	import model.BankDetails;
	import model.EducationData;
	import model.GovernmentData;
	import model.LoginAdmin;
	import model.LoginUser;
	import model.OnlineAccounts;
	import model.Others;
	import model.UserDetails;
	import model.UserInsurance;
	import utility.Validation;


public class ZZZZZZZZZZZZZZz {

		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		static Validation validate = new Validation();
		static UserDetailsDAO userdao = new UserDetailsDAO();
		public static UserDetails signUpssssssssss() throws IOException, ParseException, ClassNotFoundException, SQLException {
			
			
			System.out.println("Enter User ID : ");
			String id= br.readLine();
			System.out.println("Enter First Name : ");
			String fname = br.readLine();
			System.out.println("Enter Last Name : ");
			String lname = br.readLine();
			System.out.println("Enter Username : ");
			String username = br.readLine();
			System.out.println("Enter Password : ");
			String password =br.readLine();
			System.out.println("Enter Date Of Birth(format : yyyy-mm-dd) ");
			String dob = br.readLine();
			LocalDate date = LocalDate.parse(dob);
			
		//	SimpleDateFormat  formatter2 = new SimpleDateFormat("yyyy-mm-dd"); 
		//	Date date= formatter2.parse(dob);		
		//	System.out.println(date);
			
			System.out.println("Enter Mobile Number : ");
			Long mobNum=Long.parseLong(br.readLine());
			System.out.println("Enter Email Id : ");
			String email = br.readLine();
			System.out.println("Enter City : ");
			String city = br.readLine();
			System.out.println("Enter State : ");
			String state = br.readLine();
			System.out.println("Enter PinCode");
			Long pincode = Long.parseLong(br.readLine());
			
			
			UserDetails userDetails = new UserDetails();
			
			userDetails.setId(id);
			userDetails.setFirstName(fname);
			userDetails.setLastName(lname);
			userDetails.setUserName(username);
			userDetails.setPassword(password);
			userDetails.setBirthDate(date);
			userDetails.setMobileNum(mobNum);
			userDetails.setEmailId(email);
			userDetails.setCity(city);
			userDetails.setState(state);
			userDetails.setPinCode(pincode);
			

			return userDetails;
			
		}
		
		public static LoginUser loginUser() throws IOException {
			
			System.out.println("Enter Username : ");
			String username = br.readLine();
			System.out.println("Enter Password : ");
			String password= br.readLine();
			
			LoginUser login= new LoginUser();
			
			login.setUsername(username);
			login.setPassword(password);
			
			return login;
		}
		
		public static LoginAdmin loginAdmin() throws IOException {
			System.out.println("Enter Username :");
			String username = br.readLine();
			System.out.println("Enter Password : ");
			String password= br.readLine();
			System.out.println("Enter Secret Key : ");
			String sKey=br.readLine();
			
			LoginAdmin admin = new LoginAdmin();
			
			admin.setUsername(username);
			admin.setPassword(password);
			admin.setSecretKey(sKey);
			
			return admin;
			

		}
		
		public static BankDetails bankDetails() throws IOException, ClassNotFoundException, SQLException{
			
			System.out.println("\t\t\t\t Enter your bank details\n\n\n");
			System.out.println("Enter Bank ID : ");
			String bid=br.readLine();
			System.out.println("Enter Bank Name : ");
			String name=br.readLine();
			System.out.println("Enter Account Number");
			String accNum=br.readLine();
			System.out.println("Enter IFSC Code : ");
			String ifsc=br.readLine();
			System.out.println("Enter Bank Account Type(Saving  Account, Current  Account,Salary Account)");
			String type = br.readLine();
			System.out.println("Enter NetBanking Username : ");
			String uname=br.readLine();
			System.out.println("Enter Net Banking Password :");
			String password=br.readLine();
			System.out.println("Enter User Id : ");
			String id=br.readLine();
			
			BankDetails bank = new BankDetails();
			
			bank.setId(bid);
			bank.setBankName(name);
			bank.setAccNumber(accNum);
			bank.setIfscCode(ifsc);
			bank.setBankType(type);
			bank.setNetBankId(uname);
			bank.setPassword(password);
			bank.setUserId(id);
					
			return bank;
			
			
			
		}
		
		public static EducationData educationDetails() throws IOException, ParseException {
			
			System.out.println("\t\t\t Enter your Education Details\n\n\n");
			System.out.println("Enter ID : ");
			String eid=br.readLine();
			System.out.println("Enter Education Type(10th,12th,B-Tech,M-Tech or Any )");
			String type=br.readLine();
			System.out.println("Enter University or Board Name : ");
			String board=br.readLine();
			System.out.println("Enter Registration Number : ");
			String regNum=br.readLine();
			System.out.println("Enter Marks Obtained(CGPA or %) : ");
			int marks=Integer.parseInt(br.readLine());
			System.out.println("Enter year of passing(format: yyyy-mm-dd) :");
			String date=br.readLine();
			LocalDate year = LocalDate.parse(date);
		//	Date year=new SimpleDateFormat("dd-mm-yyyy").parse(date);
			System.out.println("Enter User Id :");
			String uid=br.readLine();
			
			EducationData education = new EducationData();
			
			education.setId(eid);
			education.setEduType(type);
			education.setUni_Board(board);
			education.setRegistNum(regNum);
			education.setMarks(marks);
			education.setYear(year);
			education.setUserId(uid);
			
			
			return education;
			
			
		}
		
		public static GovernmentData governmentData() throws IOException, ParseException {
			
			System.out.println("\t\t\t Enter the Governemnt Details\n\n\n");
			System.out.println("Enter ID : ");
			String gid=br.readLine();
			System.out.println("Enter ID_Type(Aadhar card, Pan Card, License,Passport)");
			String type=br.readLine();
			System.out.println("Enter Card Number : ");
			String cardNum=br.readLine();
			System.out.println("Enter Father Name :");
			String fname=br.readLine();
			System.out.println("Enter Validity(format: yyyy-mm-dd) : ");
			String date = br.readLine();
			LocalDate validity = LocalDate.parse(date);
		//	Date validity=new SimpleDateFormat("dd-mm-yyyy").parse(date);
			System.out.println("Enter the Issuer Organization : ");
			String issuer=br.readLine();
			System.out.println("Enter User ID : ");
			String uid=br.readLine();
			
			GovernmentData govtData=new GovernmentData();
			govtData.setId(gid);
			govtData.setIdType(type);
			govtData.setCardNumber(cardNum);
			govtData.setFatherName(fname);
			govtData.setValidity(validity);
			govtData.setIssuer(issuer);
			govtData.setUserId(uid);
			
			
			return govtData;
			
			
		}
		
		
		public static OnlineAccounts onlineAccount() throws IOException {
			
			System.out.println("\t\t\t Enter your Social media as well as Email Account Details\n\n\n");
			System.out.println("Enter ID : ");
			String id = br.readLine();
			System.out.println("Enter Account Type(Gmail,Yahoo,Twitter,Facebook,Instagram or Any)");
			String type=br.readLine();
			System.out.println("Enter Username : ");
			String uname=br.readLine();
			System.out.println("Enter Password : ");
			String password=br.readLine();
			System.out.println("Enter User ID : ");
			String uid=br.readLine();
			
			OnlineAccounts accounts = new OnlineAccounts();
			accounts.setId(id);
			accounts.setAccType(type);
			accounts.setUserName(uname);
			accounts.setPassword(password);
			accounts.setUserId(uid);
			
			return accounts;
		}
		
		
		public static Others others() throws IOException {
			System.out.println("\t\t\t Enter Other Details like images or any other data\n\n\n");
			System.out.println("Enter ID : ");
			String id = br.readLine();
			System.out.println("Enter what type of data you need to store : ");
			String type= br.readLine();
			System.out.println("Enter Name : ");
			String name = br.readLine();
			System.out.println("Enter Description of the data :");
			String description = br.readLine();
			System.out.println("Enter User ID :");
			String uid = br.readLine();
			
			Others othersData = new Others();
			othersData.setId(id);
			othersData.setDataType(type);
			othersData.setName(name);
			othersData.setDescription(description);
			othersData.setUserId(uid);
			
			return othersData;

		}
		
		public static UserInsurance insurance() throws IOException {
			System.out.println("\t\t\tEnter your Insurance details here\n\n\n");
			System.out.println("Enter ID : ");
			String id = br.readLine();
			System.out.println("Enter Insurance Type(Helth,life,Vehicle or any )");
			String type = br.readLine();
			System.out.println("Enter Insurance Number : ");
			String insNum= br.readLine();
			System.out.println("Enter Start Date(format: yyyy-mm-dd) : ");
			String startdate= br.readLine();
			LocalDate start = LocalDate.parse(startdate);
			System.out.println("Enter End Date (format: yyyy-mm-dd) : ");
			String enddate = br.readLine();
			LocalDate end = LocalDate.parse(enddate);
			System.out.println("Enter User ID : ");
			String uid=br.readLine();
		
			UserInsurance userInsurance = new UserInsurance();
			userInsurance.setId(id);
			userInsurance.setType(type);
			userInsurance.setNumber(insNum);
			userInsurance.setStart(start);
			userInsurance.setEnd(end);
			userInsurance.setUserId(uid);
			
			return userInsurance;		
				
			
		}
		
		
	

	
}
