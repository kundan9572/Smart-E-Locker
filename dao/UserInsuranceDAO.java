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

	}

	public void display() throws SQLException, ClassNotFoundException, IOException {
			
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs= st.executeQuery("SELECT * FROM USER_INSURANCE");
		System.out.println("**************************************************************************************************************************************************************");
		System.out.println("Insurance ID\t\tInsurance Type\t\tInsurance Number\t\tInsurance Start Date\t\tInsurance End Date\t\t User Id");
		while(rs.next())
		{
			System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) +"\t\t\t"+ rs.getDate(4) + "\t\t\t" + rs.getDate(5)
			+ "\t\t\t" + rs.getString(6));
		}
		System.out.println("**************************************************************************************************************************************************************");

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

	}

}
