package dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.LoginAdmin;
import utility.ConnectionManager;

public class LoginAdminDAO {

	public boolean validate(LoginAdmin admin) throws ClassNotFoundException, SQLException, IOException {
		
		
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs= st.executeQuery("SELECT * FROM USER_DETAILS");
		
		while(rs.next())
		{
			if(admin.getUsername().equals(rs.getString("USERNAME")))
			{
				if(admin.getSecretKey().equals("abcd123")) {
					{
						con.getConnection().close();
						return true;
					}
					
				}
			}
		}
		con.getConnection().close();
		return false;
		
	}

}
