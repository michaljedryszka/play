package auth;

import controllers.routes;
import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;

public class Secured extends Security.Authenticator {
	
    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("authenticated");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.LoginController.showlogin());
    }
}