package dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import model.GovernmentData;
import utility.ConnectionManager;

public class GovernmentDataDAO {
	
	static ConnectionManager con = new ConnectionManager();


	public void insert(GovernmentData govtData) throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		
		String sql = "INSERT INTO GOVERMENT_DATA(GID,ID_TYPE,CARD_NUMBER,FATHER_NAME,VALIDITY,ISSUER,USER_ID) VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement  st = con.getConnection().prepareStatement(sql);
		
		st.setString(1, govtData.getId());
		st.setString(2, govtData.getIdType());
		st.setString(3, govtData.getCardNumber());
		st.setString(4, govtData.getFatherName());
		st.setDate(5, Date.valueOf(govtData.getValidity()));
		st.setString(6, govtData.getIssuer());
		st.setString(7, govtData.getUserId());
		
		st.executeUpdate();
		System.out.println("Data successfully Inserted");
		con.getConnection().close();
	}

	public void display() throws ClassNotFoundException, SQLException, IOException {
		boolean flag = false;
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		ResultSet rs= st.executeQuery("SELECT * FROM GOVERMENT_DATA");
		System.out.println("******************************************************************************************************************************************************************************************************************");
		System.out.println("Government ID\t\tID Type\t\t\t\tCard Number\t\t\tFather Name\t\t\tValidity\t\t\tIssuer Organization\t\t\tUser ID");
		while(rs.next())
		{
			System.out.println(rs.getString("GID") + "\t\t\t" + rs.getString("ID_TYPE") + "\t\t\t" + rs.getString("CARD_NUMBER") + "\t\t\t" + rs.getString("FATHER_NAME")
			 + "\t\t\t" + rs.getDate("VALIDITY") + "\t\t\t" + rs.getString("ISSUER") + "\t\t\t" + rs.getString("USER_ID"));
		
			flag = true;
		}
		System.out.println("******************************************************************************************************************************************************************************************************************");
		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User ID does not exist . ");
		con.getConnection().close();

	}

	public void delete(String id) throws ClassNotFoundException, SQLException, IOException {
			
		ConnectionManager con = new ConnectionManager();
		String sql = "DELETE FROM  GOVERMENT_DATA WHERE GID = ?";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, id);
		int x = st.executeUpdate();
		 
		 if(x>0) {
			 System.out.println("One Government details Successfully Deleted");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
			con.getConnection().close();

	}

	public void updateGovtIDType(String id, String type) throws ClassNotFoundException, SQLException, IOException {
			
		String sql = "UPDATE GOVERMENT_DATA SET ID_TYPE= ? WHERE GID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, type);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Government ID Type  Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();

	}

	public void updateCardNumber(String id, String cardNum) throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "UPDATE GOVERMENT_DATA SET CARD_NUMBER= ? WHERE GID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, cardNum);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Card Number  Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();

	}

	public void updateValidity(String id, LocalDate date) throws SQLException, ClassNotFoundException, IOException {
			
		String sql = "UPDATE GOVERMENT_DATA SET VALIDITY= ? WHERE GID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setDate(1, Date.valueOf(date));
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Validity  Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();

	}

	public void updateIssuerName(String id, String issuer) throws SQLException, ClassNotFoundException, IOException {
		String sql = "UPDATE GOVERMENT_DATA SET ISSUER= ? WHERE GID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, issuer);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Issuer Organization  Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();
	}

	public void userGovernment() throws ClassNotFoundException, SQLException, IOException {
		boolean flag = false;
		
		Statement st = con.getConnection().createStatement();
		String sql = "SELECT * FROM USER_DETAILS INNER JOIN GOVERMENT_DATA ON USER_DETAILS.ID = GOVERMENT_DATA.USER_ID";
		ResultSet rs = st.executeQuery(sql);
		System.out.println("***************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n\n");
		while(rs.next())
		{
			System.out.println(rs.getString("ID") + "\t\t" + rs.getString("FNAME") + "\t\t" + rs.getString("LNAME") + "\t\t" + rs.getString("USERNAME")
			+"\t\t"+rs.getString("PASSWORD") + "\t\t" + rs.getDate("DATE_OF_BIRTH") + "\t\t" + rs.getLong("MOBILE_NUM") + "\t\t" + rs.getString("EMAIL_ID")
			+"\t\t" + rs.getString("CITY")+ "\t\t\t" + rs.getString("STATE") + "\t\t\t" + rs.getLong("PIN_CODE") +
			rs.getString("GID") + "\t\t\t" + rs.getString("ID_TYPE") + "\t\t\t" + rs.getString("CARD_NUMBER") + "\t\t\t" + rs.getString("FATHER_NAME")
			 + "\t\t\t" + rs.getDate("VALIDITY") + "\t\t\t" + rs.getString("ISSUER") + "\t\t\t" + rs.getString("USER_ID"));
		
			flag = true;
		}
		System.out.println("*****************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n\n");

		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User ID does not exist . ");
		con.getConnection().close();
	}

	public void countGovtData() throws ClassNotFoundException, SQLException, IOException {
		Statement st = con.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT COUNT(GID) FROM GOVERMENT_DATA");
		while(rs.next())
		{
			int count = rs.getInt(1);
			System.out.println("\n*************************************************************************************\n");
			System.out.println("The total Government data inserted  are :" + count);
			System.out.println("\n*************************************************************************************\n");

		}
		con.getConnection().close();

	}

	public void displayUserGovt(String uid) throws ClassNotFoundException, SQLException, IOException {
		
		boolean flag = false;
		Statement st = con.getConnection().createStatement();
		String sql = "SELECT * FROM GOVERMENT_DATA WHERE USER_ID = '" + uid + "'";
	//	String sql = "SELECT ID FROM USER_DETAILS";
		ResultSet rs = st.executeQuery(sql);
		System.out.println("******************************************************************************************************************************************************************************************************************");
		System.out.println("Government ID\t\tID Type\t\t\t\tCard Number\t\t\tFather Name\t\t\tValidity\t\t\tIssuer Organization\t\t\tUser ID");
		while(rs.next())
		{
			System.out.println(rs.getString("GID") + "\t\t\t" + rs.getString("ID_TYPE") + "\t\t\t" + rs.getString("CARD_NUMBER") + "\t\t\t" + rs.getString("FATHER_NAME")
			 + "\t\t\t" + rs.getDate("VALIDITY") + "\t\t\t" + rs.getString("ISSUER") + "\t\t\t" + rs.getString("USER_ID"));
		
			flag = true;
		}
		System.out.println("******************************************************************************************************************************************************************************************************************");
		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User does not have any data or user does not exist . ");
		con.getConnection().close();
	}

}
