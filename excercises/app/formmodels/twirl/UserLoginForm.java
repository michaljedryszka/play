package formmodels.twirl;

import play.data.validation.Constraints.Required;

public class UserLoginForm {

	@Required
	private String name;
	
	@Required
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
