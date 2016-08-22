package auth;

import com.google.inject.ImplementedBy;

import models.User;
import play.mvc.Http.Session;

@ImplementedBy(DBAuthBean.class)
public interface DBAuthService {
	
	boolean verify(User user);

	void authenticate(User user, Session session);
	
	boolean isAuthenticated(Session session);
	
	void logout(Session session);

}
