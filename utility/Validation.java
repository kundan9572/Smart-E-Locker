package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	public boolean validateLastName(String lname) {
		
		boolean result = false;
		if(lname.matches("^[a-zA-Z]*$"))
		{
			result = true;
		}
		return result;
	}

	public boolean validatePassword(String password) {

		boolean result = false;
		if(password.matches("^[A-Z][a-zA-Z0-9@_]*$"))
		{
			result = true;
		}
		return result;
	}

	public boolean validateEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
			Pattern pat = Pattern.compile(emailRegex); 
			if (email == null) 
				return false; 
			return pat.matcher(email).matches(); 
	}
	
	

}
