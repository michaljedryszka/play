package controllers;

import javax.inject.Inject;

import auth.DBAuthService;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class LoginController extends Controller{
	
    private FormFactory formFactory;
	private DBAuthService dbVerificationService;
	
    @Inject
    public LoginController(FormFactory formFactory, DBAuthService dbVerificationService) {
        this.formFactory = formFactory;
        this.dbVerificationService = dbVerificationService;
    }
	
	
    public Result login() {
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        if(userForm.hasErrors()) {
            return badRequest(views.html.login.render(userForm));
        }
        User user = userForm.get();
        if(dbVerificationService.verify(user)){
        	dbVerificationService.authenticate(user, session());
        }
        return redirect(routes.HomeController.index());
    }

    public Result showlogin() {
    	dbVerificationService.logout(session());
        Form<User> userForm = formFactory.form(User.class);
        return ok(views.html.login.render(userForm));
    }
}
