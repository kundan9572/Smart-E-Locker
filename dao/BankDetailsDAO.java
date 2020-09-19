package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.BankDetails;
import utility.ConnectionManager;

public class BankDetailsDAO {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ConnectionManager con = new ConnectionManager();

	public void insert(BankDetails bankDetails) throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		
		String sql = "INSERT INTO BANK_DETAILS(BID,BANK_NAME,ACCOUNT_NUMBER,IFSC_CODE,BANK_TYPE,NET_BANKING_ID,PASSWORD,USER_ID) VALUES(?,?,?,?,?,?,?,?)";
		
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		
		st.setString(1,bankDetails.getId());
		st.setString(2,bankDetails.getBankName());
		st.setString(3, bankDetails.getAccNumber());
		st.setString(4,bankDetails.getIfscCode());
		st.setString(5, bankDetails.getBankType());
		st.setString(6, bankDetails.getNetBankId());
		st.setString(7, bankDetails.getPassword());
		st.setString(8, bankDetails.getUserId());
		
		st.executeUpdate();
		System.out.println("Data Successfully Inserted .");
		con.getConnection().close();
		
	}

	public void display() throws ClassNotFoundException, SQLException, IOException {
		
		boolean flag = false;
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs= st.executeQuery("SELECT * FROM BANK_DETAILS");
		System.out.println("**************************************************************************************************************************************************************************");
		System.out.println("Bank Id\t\tBank Name\t\t\tAccount Number\t\tIFSC Code\t\tBank Type\tNetBanking Username\tPassword\t\tUserId\n");
	
		while(rs.next())
		{
			System.out.println(rs.getString("BID")+"\t\t"+ rs.getString("BANK_NAME")+ "\t\t" + rs.getString("ACCOUNT_NUMBER")+"\t\t" + rs.getString("IFSC_CODE") 
			+ "\t\t" + rs.getString("BANK_TYPE") + "\t\t" + rs.getString("NET_BANKING_ID")+ "\t\t" + rs.getString("PASSWORD") + "\t\t" + rs.getString("USER_ID"));
		
		flag = true;
		}
		System.out.println();
		System.out.println("***************************************************************************************************************************************************************************");
		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User ID does not exist . ");
		con.getConnection().close();

	}

	public void delete(String id) throws ClassNotFoundException, SQLException, IOException {
		
	
		ConnectionManager con = new ConnectionManager();
		String sql = "DELETE FROM  BANK_DETAILS WHERE BID = ?";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, id);
		int x = st.executeUpdate();
		 
		 if(x>0) {
			 System.out.println("One BanK details Successfully Deleted");
		 }
		 else {
			 System.out.println("Error Occured");
		 }

			con.getConnection().close();

	}

	public void userBank() throws SQLException, ClassNotFoundException, IOException {
		boolean flag = false;
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		String sql ="SELECT * FROM USER_DETAILS INNER JOIN BANK_DETAILS ON USER_DETAILS.ID = BANK_DETAILS.USER_ID";
		ResultSet rs= st.executeQuery(sql);
		System.out.println("*******************************************************************************************************************************************************************************************************************************************************************************************************************************************");
		while(rs.next())
		{
			
			System.out.println(rs.getString("ID") + "\t" + rs.getString("FNAME") + "\t" + rs.getString("LNAME") + "\t" + rs.getString("USERNAME")
			+"\t"+rs.getString("PASSWORD") + "\t" + rs.getDate("DATE_OF_BIRTH") + "\t" + rs.getLong("MOBILE_NUM") + "\t" + rs.getString("EMAIL_ID")
			+"\t" + rs.getString("CITY")+ "\t" + rs.getString("STATE") + "\t" + rs.getLong("PIN_CODE") + "\t" +
			rs.getString("BID")+"\t"+ rs.getString("BANK_NAME")+ "\t" + rs.getString("ACCOUNT_NUMBER")+"\t" + rs.getString("IFSC_CODE") 
			+ "\t" + rs.getString("BANK_TYPE") + "\t" + rs.getString("NET_BANKING_ID")+ "\t" + rs.getString("PASSWORD") + "\t" + rs.getString("USER_ID")
			
			);	
			flag = true;
		}
		System.out.println("*********************************************************************************************************************************************************************************************************************************************************************************************************************************************");
		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User ID does not exist . ");
		con.getConnection().close();

	}

	public void updateBankType(String id, String type) throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		String sql = "UPDATE BANK_DETAILS SET BANK_TYPE= ? WHERE BID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, type);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Bank Type Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }

		con.getConnection().close();

	}

	public void updateNetBankingId(String id, String netBankId) throws ClassNotFoundException, SQLException, IOException {
		ConnectionManager con = new ConnectionManager();
		String sql = "UPDATE BANK_DETAILS SET NET_BANKING_ID= ? WHERE BID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, netBankId);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Net Banking ID  Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();

	}

	public void updatePassword(String id, String password) throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "UPDATE BANK_DETAILS SET PASSWORD= ? WHERE BID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, password);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Password  Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();

	}

	public void countBankID() throws ClassNotFoundException, SQLException, IOException {
		Statement st = con.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT COUNT(BID) FROM BANK_DETAILS");
		while(rs.next())
		{
			int count = rs.getInt(1);
			System.out.println("\n************************************************************************************\n");
			System.out.println("The total number of Bank Id are :" + count);
			System.out.println("\n************************************************************************************\n");

		}
		con.getConnection().close();

		
	}

	public void displayUserBank(String uid) throws ClassNotFoundException, SQLException, IOException {
		
		boolean flag= false;
		Statement st = con.getConnection().createStatement();
		String sql = "SELECT * FROM BANK_DETAILS WHERE USER_ID = '" + uid + "'";
	//	String sql = "SELECT * FROM BANK_DETAILS";
		ResultSet rs = st.executeQuery(sql);
		System.out.println("**************************************************************************************************************************************************************************");
		System.out.println("Bank Id\t\tBank Name\t\t\tAccount Number\t\tIFSC Code\t\tBank Type\tNetBanking Username\tPassword\t\tUserId\n");
		while(rs.next()) {
									
			System.out.println(rs.getString("BID")+"\t\t"+ rs.getString("BANK_NAME")+ "\t\t" + rs.getString("ACCOUNT_NUMBER")+"\t\t" + rs.getString("IFSC_CODE") 
			+ "\t\t" + rs.getString("BANK_TYPE") + "\t\t" + rs.getString("NET_BANKING_ID")+ "\t\t" + rs.getString("PASSWORD") + "\t\t" + rs.getString("USER_ID"));
				flag = true;
			}
		if(flag == true) {
			System.out.println("Successfully fetched data");
		}
		else
			System.out.println("User does not have any data or user does not exist .");
		System.out.println("**************************************************************************************************************************************************************************");

		
	}
	
	    
}
