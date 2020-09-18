package dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.LoginUser;
import utility.ConnectionManager;

public class LoginUserDAO {

	public boolean validate(LoginUser loginUser) throws SQLException, ClassNotFoundException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs= st.executeQuery("SELECT * FROM USER_DETAILS");
		
		while(rs.next())
		{
			if(loginUser.getUsername().equals(rs.getString("USERNAME")))
			{
				if(loginUser.getPassword().equals(rs.getString("PASSWORD"))) {
					con.getConnection().close();
					return true;

				}
			}
		}
		con.getConnection().close();
		return false;
	}

}
