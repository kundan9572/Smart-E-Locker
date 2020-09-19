package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.OnlineAccounts;
import utility.ConnectionManager;

public class OnlineAccountsDAO {
	
	static 	ConnectionManager con = new ConnectionManager();

	public void insert(OnlineAccounts accounts) throws ClassNotFoundException, SQLException, IOException {
		
			ConnectionManager con = new ConnectionManager();
			
			String sql = "INSERT INTO ONLINE_ACCOUNTS(AID,ACC_TYPE,USERNAME,PASSWORD,USER_ID) VALUES(?,?,?,?,?)";
			
			PreparedStatement st = con.getConnection().prepareStatement(sql);
			
			st.setString(1, accounts.getId());
			st.setString(2, accounts.getAccType());
			st.setString(3, accounts.getUserName());
			st.setString(4, accounts.getPassword());
			st.setString(5, accounts.getUserId());
			
			st.executeUpdate();
			System.out.println("Data is successfully Inserted .");
			con.getConnection().close();
		
	}

	public void display() throws SQLException, ClassNotFoundException, IOException {
		boolean flag = false;
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs= st.executeQuery("SELECT * FROM ONLINE_ACCOUNTS");
		System.out.println("****************************************************************************************************************************************************");
		System.out.println("Account Id\t\tAccount Type\t\tUsername\t\t\tPassword\t\t\tUser Id");
		while(rs.next())
		{
			System.out.println(rs.getString("AID") + "\t\t\t" + rs.getString("ACC_TYPE") + "\t\t\t" + rs.getString("USERNAME") +"\t\t\t" 
					+ rs.getString("PASSWORD") + "\t\t\t" +rs.getString("USER_ID"));
		
		flag = true;
		}
		System.out.println("****************************************************************************************************************************************************");
		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User ID does not exist . ");
		con.getConnection().close();

	}

	public void delete(String id) throws ClassNotFoundException, SQLException, IOException {
			
		ConnectionManager con = new ConnectionManager();
		String sql = "DELETE FROM  ONLINE_ACCOUNTS WHERE AID = ?";
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

	public void updateAccountType(String id, String type) throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "UPDATE ONLINE_ACCOUNTS SET ACC_TYPE= ? WHERE AID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, type);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Social Media Account Type  Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();

	}

	public void updateUsername(String id, String uname) throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "UPDATE ONLINE_ACCOUNTS SET USERNAME= ? WHERE AID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, uname);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Username  Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();

	}

	public void updatePassword(String id, String password) throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "UPDATE ONLINE_ACCOUNTS SET PASSWORD= ? WHERE AID = ? ";
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

	public void userOnlineAccounts() throws ClassNotFoundException, SQLException, IOException {
		boolean flag = false;
		Statement st = con.getConnection().createStatement();
		String sql = "SELECT * FROM USER_DETAILS INNER JOIN ONLINE_ACCOUNTS ON USER_DETAILS.ID = ONLINE_ACCOUNTS.USER_ID";
		ResultSet rs = st.executeQuery(sql);
		System.out.println("*************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n\n");
		while(rs.next())
		{
			System.out.println(rs.getString("ID") + "\t\t" + rs.getString("FNAME") + "\t\t" + rs.getString("LNAME") + "\t\t" + rs.getString("USERNAME")
			+"\t\t"+rs.getString("PASSWORD") + "\t\t" + rs.getDate("DATE_OF_BIRTH") + "\t\t" + rs.getLong("MOBILE_NUM") + "\t\t" + rs.getString("EMAIL_ID")
			+"\t\t" + rs.getString("CITY")+ "\t\t\t" + rs.getString("STATE") + "\t\t\t" + rs.getLong("PIN_CODE") +
			rs.getString("AID") + "\t\t\t" + rs.getString("ACC_TYPE") + "\t\t\t" + rs.getString("USERNAME") +"\t\t\t" 
			+ rs.getString("PASSWORD") + "\t\t\t" +rs.getString("USER_ID"));
		
			flag = true;
		}
		System.out.println("*********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n\n");

		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User ID does not exist . ");
		con.getConnection().close();
	}

	public void countID() throws ClassNotFoundException, SQLException, IOException {
		Statement st = con.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT COUNT(AID) FROM ONLINE_ACCOUNTS");
		while(rs.next())
		{
			int count = rs.getInt(1);
			System.out.println("\n*******************************************************************************\n");
			System.out.println("The total number of user are :" + count);
			System.out.println("\n*******************************************************************************\n");

		}
		con.getConnection().close();
	}

	public void displayUserAccounts(String uid) throws ClassNotFoundException, SQLException, IOException {
		boolean flag = false;
		Statement st = con.getConnection().createStatement();
		String sql = "SELECT * FROM ONLINE_ACCOUNTS WHERE USER_ID = '" + uid + "'";
	//	String sql = "SELECT ID FROM USER_DETAILS";
		ResultSet rs = st.executeQuery(sql);
		System.out.println("****************************************************************************************************************************************************");
		System.out.println("Account Id\t\tAccount Type\t\tUsername\t\t\tPassword\t\t\tUser Id");
		while(rs.next())
		{
			System.out.println(rs.getString("AID") + "\t\t\t" + rs.getString("ACC_TYPE") + "\t\t\t" + rs.getString("USERNAME") +"\t\t\t" 
					+ rs.getString("PASSWORD") + "\t\t\t" +rs.getString("USER_ID"));
		
		flag = true;
		}
		System.out.println("****************************************************************************************************************************************************");
		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User does not have any data or user does not exist . ");
		con.getConnection().close();
		
	}

}
