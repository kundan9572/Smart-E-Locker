package dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import model.UserInsurance;
import utility.ConnectionManager;

public class UserInsuranceDAO {
	
	 static ConnectionManager con = new ConnectionManager();

	public void insert(UserInsurance insu) throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		
		String sql = "INSERT INTO USER_INSURANCE(ID,INSURANCE_TYPE,INSURANCE_NUMBER,START_DATE,END_DATE,USER_ID) VALUES (?,?,?,?,?,?)";
		
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		
		st.setString(1,insu.getId());
		st.setString(2, insu.getType());
		st.setString(3, insu.getNumber());
		st.setDate(4, Date.valueOf(insu.getStart()));
		st.setDate(5, Date.valueOf(insu.getEnd()));
		st.setString(6, insu.getUserId());
		
		st.executeUpdate();
		System.out.println("Data is successfully Inserted .");
		con.getConnection().close();
	}

	public void delete(String id) throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		String sql = "DELETE FROM  USER_INSURANCE WHERE ID = ?";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, id);
		int x = st.executeUpdate();
		 
		 if(x>0) {
			 System.out.println("One Insurance details Successfully Deleted");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
			con.getConnection().close();
	}

	public void display() throws SQLException, ClassNotFoundException, IOException {
			boolean flag = false;
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs= st.executeQuery("SELECT * FROM USER_INSURANCE");
		System.out.println("*****************************************************************************************************************************************************************************************************************");
		System.out.println("Insurance ID\t\tInsurance Type\t\tInsurance Number\t\tInsurance Start Date\t\tInsurance End Date\t\t User Id");
		while(rs.next())
		{
			System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) +"\t\t\t"+ rs.getDate(4) + "\t\t\t" + rs.getDate(5)
			+ "\t\t\t" + rs.getString(6));
		
		flag = true;
		}
		System.out.println("******************************************************************************************************************************************************************************************************************************");
		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User ID does not exist . ");
		con.getConnection().close();
	}

	public void updateInsuranceType(String id, String type) throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "UPDATE USER_INSURANCE SET INSURANCE_TYPE= ? WHERE ID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, type);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Insurance Type  Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();
	}

	public void updateInsuranceNumber(String id, String number) throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "UPDATE USER_INSURANCE SET INSURANCE_NUMBER= ? WHERE ID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, number);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Insurance Number  Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();
	}

	public void updateStartDate(String id, LocalDate sdate) throws SQLException, ClassNotFoundException, IOException {
		
		String sql = "UPDATE USER_INSURANCE SET START_DATE= ? WHERE ID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setDate(1, Date.valueOf(sdate));
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println(" Start Date  has Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();
	}

	public void updateEndDate(String id, LocalDate edate) throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "UPDATE USER_INSURANCE SET END_DATE= ? WHERE ID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setDate(1, Date.valueOf(edate));
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println(" End Date  has Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();
	}

	public boolean validateInsuranceID(String id) throws ClassNotFoundException, SQLException, IOException {
		boolean result = false;
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs= st.executeQuery("SELECT ID FROM USER_INSURANCE");
		
		while(rs.next())
		{
			if(id.equals(rs.getNString("ID")))
			{	
				result = true;
			
			}
	
		}
		return result;
	}

	public void displayInsurance(String uid) throws ClassNotFoundException, SQLException, IOException {
		boolean flag = false;
		Statement st = con.getConnection().createStatement();
		String sql = "SELECT * FROM USER_INSURANCE WHERE USER_ID = '" + uid + "'";
	//	String sql = "SELECT ID FROM USER_DETAILS";
		ResultSet rs = st.executeQuery(sql);
		System.out.println("*****************************************************************************************************************************************************************************************************************");
		System.out.println("Insurance ID\t\tInsurance Type\t\tInsurance Number\t\tInsurance Start Date\t\tInsurance End Date\t\t User Id");
		while(rs.next())
		{
			System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) +"\t\t\t"+ rs.getDate(4) + "\t\t\t" + rs.getDate(5)
			+ "\t\t\t" + rs.getString(6));
		flag = true;
		}
		System.out.println("******************************************************************************************************************************************************************************************************************************");
		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User does not have any data or user does not exist . ");
		con.getConnection().close();
	}

	public void userInsurance() throws SQLException, ClassNotFoundException, IOException {
			
		boolean flag = false;
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		String sql ="SELECT * FROM USER_DETAILS INNER JOIN USER_INSURANCE ON USER_DETAILS.ID = USER_INSURANCE.USER_ID";
		ResultSet rs= st.executeQuery(sql);
		System.out.println("***************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************");
		System.out.println("\t\t\t\t User and Insurance Details");
		System.out.println("\t\t__________________________________________________\n");
		while(rs.next())
		{
			System.out.println(rs.getString("ID") + "\t\t" + rs.getString("FNAME") + "\t\t" + rs.getString("LNAME") + "\t\t" + rs.getString("USERNAME")
			+"\t\t"+rs.getString("PASSWORD") + "\t\t" + rs.getDate("DATE_OF_BIRTH") + "\t\t" + rs.getLong("MOBILE_NUM") + "\t\t" + rs.getString("EMAIL_ID")
			+"\t\t" + rs.getString("CITY")+ "\t\t\t" + rs.getString("STATE") + "\t\t\t" + rs.getLong("PIN_CODE") +
			rs.getString("ID") + "\t\t\t" + rs.getString("INSURANCE_TYPE") + "\t\t\t" + rs.getString("INSURANCE_NUMBER") +"\t\t\t"+ rs.getDate("START_DATE") + "\t\t\t" + rs.getDate("END_DATE")
			+ "\t\t\t" + rs.getString("USER_ID"));
		
		flag = true;
		}
		System.out.println("*********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************");

		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User does not have any data or user does not exist . ");
		
		con.getConnection().close();
	}

}
