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
		
		try {
			ConnectionManager con = new ConnectionManager();
			
			String sql = "INSERT INTO ONLINE_ACCOUNTS(AID,ACC_TYPE,USERNAME,PASSWORD,USER_ID) VALUES(?,?,?,?,?)";
			
			PreparedStatement st = con.getConnection().prepareStatement(sql);
			
			st.setString(1, accounts.getId());
			st.setString(2, accounts.getAccType());
			st.setString(3, accounts.getUserName());
			st.setString(4, accounts.getPassword());
			st.setString(5, accounts.getUserId());
			
			st.executeUpdate();
			con.getConnection().close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void display() throws SQLException, ClassNotFoundException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs= st.executeQuery("SELECT * FROM ONLINE_ACCOUNTS");
		System.out.println("****************************************************************************************************************************************************");
		System.out.println("Account Id\t\tAccount Type\t\tUsername\t\t\tPassword\t\t\tUser Id");
		while(rs.next())
		{
			System.out.println(rs.getString("AID") + "\t\t\t" + rs.getString("ACC_TYPE") + "\t\t\t" + rs.getString("USERNAME") +"\t\t\t" 
					+ rs.getString("PASSWORD") + "\t\t\t" +rs.getString("USER_ID"));
		}
		System.out.println("****************************************************************************************************************************************************");

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
	}

}
