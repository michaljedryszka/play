package controllers.twirl;

import javax.inject.Inject;

import formmodels.twirl.UserLoginForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class LoginController extends Controller{
	
	private FormFactory formFactory;
	
	@Inject
	public LoginController(FormFactory formFactory){
		this.formFactory = formFactory;
	}
		
	public Result index(){
		Form<UserLoginForm> form = formFactory.form(UserLoginForm.class);
		return ok(views.html.twirl.form.login.render(form));
	}
	
	public Result login(){
		Form<UserLoginForm> form = formFactory.form(UserLoginForm.class).bindFromRequest();
		if(form.hasErrors()){
			return badRequest(views.html.twirl.form.login.render(form));
		}
		return redirect(controllers.twirl.routes.UserController.index());
	}
}
