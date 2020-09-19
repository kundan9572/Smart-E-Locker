package dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import model.EducationData;
import utility.ConnectionManager;

public class EducationDataDAO {

	static ConnectionManager con = new ConnectionManager();

	public static void insert(EducationData educationdata) throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		
		String sql="INSERT INTO EDUCATION_DATA(EID,EDU_TYPE,UNIVERSITY_BOARD,REGISTRATION_NUM,MARKS_OBTAINED,YEAR_OF_PASSING,USER_ID) VALUES (?,?,?,?,?,?,?)";

		PreparedStatement st = con.getConnection().prepareStatement(sql);
		
		st.setString(1, educationdata.getId());
		st.setString(2, educationdata.getEduType());
		st.setString(3, educationdata.getUni_Board());
		st.setString(4, educationdata.getRegistNum());
		st.setInt(5, educationdata.getMarks());
		st.setDate(6, Date.valueOf(educationdata.getYear()));
		st.setString(7, educationdata.getUserId());
		
		st.executeUpdate();
		System.out.println("Data Successfully Inserted .");
		con.getConnection().close();


	}

	public void display() throws ClassNotFoundException, SQLException, IOException {
		boolean flag = false;
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM EDUCATION_DATA");
		System.out.println("***************************************************************************************************************************************************************************************************************************************************************************************");
		System.out.println("Education ID\t\tEducation Type\t\tUniversity/Board\t\tRegistration Number\t\tMarks Obtained\t\tDate Of passing\t\tUser ID");
		while(rs.next())
		{
			System.out.println(rs.getString("EID") +"\t\t\t" + rs.getString("EDU_TYPE") + "\t\t\t" + rs.getString("UNIVERSITY_BOARD") +"\t\t\t\t" 
		+ rs.getString("REGISTRATION_NUM") + "\t\t\t\t" + rs.getInt("MARKS_OBTAINED")+ "%"+ "\t\t"+ rs.getDate("YEAR_OF_PASSING") + "\t\t" + rs.getString("USER_ID") );
		
			flag = true;
		}
		System.out.println("*******************************************************************************************************************************************************************************************************************************************************************************************");
		
		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User ID does not exist . ");
		con.getConnection().close();
	}

	
	
	public void delete(String id) throws ClassNotFoundException, SQLException, IOException {
		
		
		ConnectionManager con = new ConnectionManager();
		String sql = "DELETE FROM  EDUCATION_DATA WHERE EID = ?";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, id);
		int x = st.executeUpdate();
		 
		 if(x>0) {
			 System.out.println("One Education details Successfully Deleted");
		 }
		 else {
			 System.out.println("Error Occured");
		 }

			con.getConnection().close();

	}

	public void updateeduType(String id, String type) throws ClassNotFoundException, SQLException, IOException {
			
		String sql = "UPDATE EDUCATION_DATA SET EDU_TYPE= ? WHERE EID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, type);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Education Type  Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();

	}

	public void updateBoard(String id, String board) throws ClassNotFoundException, SQLException, IOException {
		String sql = "UPDATE EDUCATION_DATA SET UNIVERSITY_BOARD= ? WHERE EID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, board);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Education Board or University  Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();

	}

	public void updteRegistrationNumber(String id, String regNum) throws SQLException, ClassNotFoundException, IOException {
		
		String sql = "UPDATE EDUCATION_DATA SET REGISTRATION_NUM= ? WHERE EID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setString(1, regNum);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Registration Number  Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();

	}

	public void updateMarks(String id, int marks) throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "UPDATE EDUCATION_DATA SET MARKS_OBTAINED= ? WHERE EID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setInt(1, marks);
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("Marks Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();

	}

	public void updateYearOfPassing(String id, LocalDate date) throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "UPDATE EDUCATION_DATA SET YEAR_OF_PASSING= ? WHERE EID = ? ";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setDate(1, Date.valueOf(date));
		st.setString(2, id);
		int x = st.executeUpdate();
		
		if(x>0) {
			 System.out.println("YEAR_OF_PASSING Successfully Updated");
		 }
		 else {
			 System.out.println("Error Occured");
		 }
		con.getConnection().close();

	}

	public void userEducation() throws ClassNotFoundException, SQLException, IOException {
		boolean flag = false;
		Statement st = con.getConnection().createStatement();
		String sql = "SELECT * FROM USER_DETAILS INNER JOIN EDUCATION_DATA ON USER_DETAILS.ID = EDUCATION_DATA.USER_ID";
		ResultSet rs=st.executeQuery(sql);
		System.out.println("***************************************************************************************************************************************************************************************************************************************88**************************************************************************************************************************************************************************************************************");

		while(rs.next())
		{
			System.out.println(rs.getString("ID") + "\t" + rs.getString("FNAME") + "\t" + rs.getString("LNAME") + "\t" + rs.getString("USERNAME")
			+"\t"+rs.getString("PASSWORD") + "\t" + rs.getDate("DATE_OF_BIRTH") + "\t" + rs.getLong("MOBILE_NUM") + "\t" + rs.getString("EMAIL_ID")
			+"\t\t\t" + rs.getString("CITY")+ "\t\t\t" + rs.getString("STATE") + "\t\t\t" + rs.getLong("PIN_CODE") 
			+ rs.getString("EID") +"\t\t\t" + rs.getString("EDU_TYPE") + "\t\t\t" + rs.getString("UNIVERSITY_BOARD") +"\t\t\t" 
			+ rs.getString("REGISTRATION_NUM") + "\t\t\t" + rs.getInt("MARKS_OBTAINED")+ "%"+ "\t\t\t"+ rs.getDate("YEAR_OF_PASSING") + "\t\t\t" + rs.getString("USER_ID") );
			
			flag = true;
		}
		
		System.out.println("**************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************");
		
		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User ID does not exist . ");
		con.getConnection().close();
	}

	public void countEduIDDetails() throws ClassNotFoundException, SQLException, IOException {
		
		Statement st = con.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT COUNT(EID) FROM EDUCATION_DATA");
		while(rs.next())
		{
			int count = rs.getInt(1);
			System.out.println("\n********************************************************************************\n");
			System.out.println("The total number of Data  are :" + count);
			System.out.println("\n********************************************************************************\n");

		}
		con.getConnection().close();

	}

	public void displayUserEducation(String uid) throws ClassNotFoundException, SQLException, IOException {
		boolean flag = false;
		Statement st = con.getConnection().createStatement();
		String sql = "SELECT * FROM EDUCATION_DATA WHERE USER_ID = '" + uid + "'";
	//	String sql = "SELECT ID FROM USER_DETAILS";
		ResultSet rs = st.executeQuery(sql);
		System.out.println("***************************************************************************************************************************************************************************************************************************************************************************************");
		System.out.println("Education ID\t\tEducation Type\t\tUniversity/Board\t\tRegistration Number\t\tMarks Obtained\t\tDate Of passing\t\tUser ID");
		while(rs.next())
		{
			System.out.println(rs.getString("EID") +"\t\t\t" + rs.getString("EDU_TYPE") + "\t\t\t" + rs.getString("UNIVERSITY_BOARD") +"\t\t\t\t" 
		+ rs.getString("REGISTRATION_NUM") + "\t\t\t\t" + rs.getInt("MARKS_OBTAINED")+ "%"+ "\t\t"+ rs.getDate("YEAR_OF_PASSING") + "\t\t" + rs.getString("USER_ID") );
		
			flag = true;
		}
		System.out.println("*******************************************************************************************************************************************************************************************************************************************************************************************");
		if(flag == true) {
			System.out.println("Successfully Fetched data");
		}
		else
			System.out.println("User does not have any data or user does not exist .");
		con.getConnection().close();	
	}
	
}
