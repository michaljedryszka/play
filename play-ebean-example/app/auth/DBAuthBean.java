package auth;

import com.google.inject.Singleton;

import models.User;
import play.mvc.Http.Session;

@Singleton
public class DBAuthBean implements DBAuthService{
	
	@Override
	public boolean verify(User user) {
		return User.find.where().idEq(user.email).eq("password", user.password).findList().size() == 1;
	}

	@Override
	public void authenticate(User user, Session session) {
		session.put("authenticated", user.email);
	}

	@Override
	public void logout(Session session) {
		session.remove("authenticated");
	}

	@Override
	public boolean isAuthenticated(Session session) {
		return session.containsKey("authenticated");
	}

}
