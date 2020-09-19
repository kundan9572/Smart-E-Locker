package dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import model.LoginUser;
import model.UserDetails;
import service.AdminPage;
import utility.ConnectionManager;

public class UserDetailsDAO {
	
	static ConnectionManager con = new ConnectionManager();

	public static void insert(UserDetails details) throws ClassNotFoundException, SQLException, IOException {
		
		String name =details.getId();
		String fname =details.getFirstName();
		String lname = details.getLastName();
		String uname =details.getUserName();
		String password = details.getPassword();
		LocalDate date =details.getBirthDate();
		Long mobNum = details.getMobileNum();
		String email =details.getEmailId();
		String city = details.getCity();
		String state = details.getState();
		Long pincode =details.getPinCode();
		
		ConnectionManager con = new ConnectionManager();
		
		String sql= "INSERT INTO USER_DETAILS(ID,FNAME,LNAME,USERNAME,PASSWORD,DATE_OF_BIRTH,MOBILE_NUM,EMAIL_ID,CITY,STATE,PIN_CODE) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement st = con.getConnection().prepareStatement(sql);

		
		st.setString(1,name);
		st.setString(2, fname);
		st.setString(3, lname);
		st.setString(4, uname);
		st.setString(5, password);
		st.setDate(6, Date.valueOf(date));
		st.setLong(7, mobNum);
		st.setString(8,email);
		st.setString(9, city);
		st.setString(10, state);
		st.setLong(11, pincode);
		
		st.executeUpdate();
		System.out.println("Data Successfully Inserted !");
		con.getConnection().close();
	}

	public void display() throws SQLException, ClassNotFoundException, IOException {
		boolean flag = false;
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs= st.executeQuery("SELECT * FROM USER_DETAILS");
		System.out.println("*****************************************************************************************************************************************************************************************************************************************************************************");
		System.out.println("User ID\t\tFirst Name\tLast Name\tUsername\t\tPassword\t\tDate Of Birth\t\tMobile Number\t\tEmail ID\t\t\tCity\t\t\tState\t\t\tPincoden\n");
		while(rs.next())
		{
			
			System.out.println(rs.getString("ID") + "\t\t" + rs.getString("FNAME") + "\t\t" + rs.getString("LNAME") + "\t\t" + rs.getString("USERNAME")
			+"\t\t"+rs.getString("PASSWORD") + "\t\t" + rs.getDate("DATE_OF_BIRTH") + "\t\t" + rs.getLong("MOBILE_NUM") + "\t\t" + rs.getString("EMAIL_ID")
			+"\t\t" + rs.getString("CITY")+ "\t\t\t" + rs.getString("STATE") + "\t\t\t" + rs.getLong("PIN_CODE"));	
		
			flag = true;
		}
		
		System.out.println("**************************************************************************************************************************************************************************************************************************************************************************************");
		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User ID does not exist . ");
		con.getConnection().close();
	}

	
	public void updatePassword(String id, String password) throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
	//	String sql = "UPDATE USER_DETAILS SET PASSWORD= ? WHERE ID = ?";
		String sql = " UPDATE USER_DETAILS SET PASSWORD='" + password + "'WHERE ID ='" + id +"'";
		
		PreparedStatement st = con.getConnection().prepareStatement(sql);
	//	st.setString(5, password);
		
		int rowUpdated = st.executeUpdate();
		if(rowUpdated > 0) {
			System.out.println("Row Updated Successfully !");
		}
		else
			System.out.println("Update Failed ! \nCheck all the details carefully .");
		con.getConnection().close();
		
	}

	public void updateMobile(String id, Long mobile) throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		String sql = " UPDATE USER_DETAILS SET MOBILE_NUM='" + mobile + "'WHERE ID ='" + id +"'";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		int rowUpdated = st.executeUpdate();
		if(rowUpdated > 0) {
			System.out.println("Row Updated Successfully !");
		}
		else
			System.out.println("Update Failed ! \nCheck all the details carefully .");

		con.getConnection().close();
	}

	public void updateEmail(String id, String email) throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		String sql = " UPDATE USER_DETAILS SET EMAIL_ID='" + email + "'WHERE ID ='" + id +"'";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		int rowUpdated = st.executeUpdate();
		if(rowUpdated > 0) {
			System.out.println("Row Updated Successfully !");
		}
		else
			System.out.println("Update Failed ! \nCheck all the details carefully .");

		con.getConnection().close();
	}

	public void updateCity(String id, String city) throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		String sql = " UPDATE USER_DETAILS SET CITY='" + city + "'WHERE ID ='" + id +"'";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		int rowUpdated = st.executeUpdate();
		if(rowUpdated > 0) {
			System.out.println("Row Updated Successfully !");
		}
		else
			System.out.println("Update Failed ! \nCheck all the details carefully .");
		con.getConnection().close();
	}

	public void updateState(String id, String state) throws ClassNotFoundException, SQLException, IOException {
		ConnectionManager con = new ConnectionManager();
		String sql = " UPDATE USER_DETAILS SET STATE='" + state + "'WHERE ID ='" + id +"'";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		int rowUpdated = st.executeUpdate();
		if(rowUpdated > 0) {
			System.out.println("Row Updated Successfully !");
		}
		else
			System.out.println("Update Failed ! \nCheck all the details carefully .");
		con.getConnection().close();
	}

	public void updatePinCode(String id, Long pincode) throws ClassNotFoundException, SQLException, IOException {
		ConnectionManager con = new ConnectionManager();
		String sql = " UPDATE USER_DETAILS SET PIN_CODE='" + pincode + "'WHERE ID ='" + id +"'";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		int rowUpdated = st.executeUpdate();
		if(rowUpdated > 0) {
			System.out.println("Row Updated Successfully !");
		}
		else
			System.out.println("Update Failed ! \nCheck all the details carefully .");
		con.getConnection().close();
	}

	public void updateAddress(String id, String ncity, String nstate, Long npin) throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		String sql = " UPDATE USER_DETAILS SET CITY=? , STATE = ? ,PIN_CODE = ? WHERE ID = ?";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setNString(1, ncity);
		st.setString(2, nstate);
		st.setLong(3, npin);
		st.setString(4, id);
		int rowUpdated = st.executeUpdate();
		if(rowUpdated > 0) {
			System.out.println("Row Updated Successfully !");
		}
		else
			System.out.println("Update Failed ! \nCheck all the details carefully .");
		con.getConnection().close();
	}

	public void delete(String id) throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		String sql = "DELETE FROM  USER_DETAILS WHERE ID = ?";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, id);
		int x = st.executeUpdate();
		 
		 if(x>0) {
			 System.out.println("One User details Successfully Deleted");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
			con.getConnection().close();
	}
	
	public boolean validateUserId(String id) throws SQLException, ClassNotFoundException, IOException
	{
		
		
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs= st.executeQuery("SELECT ID FROM USER_DETAILS");
		
		while(rs.next())
		{
			if(id.equals(rs.getNString("ID")))
			{	
				con.getConnection().close();
				return true;
			
			}
	
		}
		con.getConnection().close();
		return false;
	}

	public boolean validateUsername(String username) throws ClassNotFoundException, SQLException, IOException {
		
		Statement st = con.getConnection().createStatement();
		boolean result = false;
		
		ResultSet rs= st.executeQuery("SELECT USERNAME FROM USER_DETAILS");
		
		while(rs.next())
		{
			if(username.equals(rs.getNString("USERNAME")))
			{	
				con.getConnection().close();
				result = true;
			
			}
	
		}
	//	con.getConnection().close();
		return result;
	}

	public void countUser() throws ClassNotFoundException, SQLException, IOException {
		Statement st = con.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT COUNT(ID) FROM USER_DETAILS");
		while(rs.next())
		{
			int count = rs.getInt(1);
			System.out.println("\n****************************************************************************************************\n");
			System.out.println("The total number of user are :" + count);
			System.out.println("\n****************************************************************************************************\n");

		}
		con.getConnection().close();	
	}

	public void showUserDetails(String id) throws ClassNotFoundException, SQLException, IOException {
		boolean flag = false;
		Statement st = con.getConnection().createStatement();
		String sql = "SELECT * FROM USER_DETAILS WHERE ID = '"+ id + "'" ;
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			if(id.equals(rs.getString("USERNAME"))) {
				
				System.out.println(rs.getString("ID") + "\t\t" + rs.getString("FNAME") + "\t\t" + rs.getString("LNAME") + "\t\t" + rs.getString("USERNAME")
				+"\t\t"+rs.getString("PASSWORD") + "\t\t" + rs.getDate("DATE_OF_BIRTH") + "\t\t" + rs.getLong("MOBILE_NUM") + "\t\t" + rs.getString("EMAIL_ID")
				+"\t\t" + rs.getString("CITY")+ "\t\t\t" + rs.getString("STATE") + "\t\t\t" + rs.getLong("PIN_CODE"));	
			
			flag = true;
			}
			if(flag == true) {
				System.out.println("Successfully Fetched data");
			}
			else
				System.out.println("User ID does not exist . ");
			con.getConnection().close();
		}
	}

	public void showUser(String userId) throws ClassNotFoundException, SQLException, IOException, NumberFormatException, ParseException {
		boolean flag = false;
	//	String uname = userId.getUsername();
		Statement st = con.getConnection().createStatement();
		String sql = "SELECT * FROM USER_DETAILS WHERE ID = '" + userId + "'";
	//	String sql = "SELECT ID FROM USER_DETAILS";
		ResultSet rs = st.executeQuery(sql);
		System.out.println("***********************************************************************************************************************************************************************************************************************************************************");
		while(rs.next()) {
				
			System.out.println(rs.getString("ID") + "\t\t" + rs.getString("FNAME") + "\t\t" + rs.getString("LNAME") + "\t\t" + rs.getString("USERNAME")
			+"\t\t"+rs.getString("PASSWORD") + "\t\t" + rs.getDate("DATE_OF_BIRTH") + "\t\t" + rs.getLong("MOBILE_NUM") + "\t\t" + rs.getString("EMAIL_ID")
			+"\t\t" + rs.getString("CITY")+ "\t\t\t" + rs.getString("STATE") + "\t\t\t" + rs.getLong("PIN_CODE"));	
			System.out.println("\n");
			
				flag = true;
			}
			System.out.println("********************************************************************************************************************************************************************************************************************************************************");
		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User does not have any data or user does not exist . ");
		con.getConnection().close();
	}
	

}
