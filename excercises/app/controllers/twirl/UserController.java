package controllers.twirl;

import javax.inject.Inject;

import formmodels.twirl.UserForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class UserController extends Controller {

	private FormFactory formFactory;

	@Inject
	public UserController(FormFactory formFactory) {
		this.formFactory = formFactory;
	}

	public Result index() {
		Form<UserForm> userForm = formFactory.form(UserForm.class);
		UserForm defaultUser = new UserForm();
		defaultUser.setName("default name");
		defaultUser.setEmail("changeMe!");
		userForm = userForm.fill(defaultUser);
		return ok(views.html.twirl.form.user.render(userForm));
	}

	public Result save() {
		Form<UserForm> userForm = formFactory.form(UserForm.class).bindFromRequest();
		if (!userForm.hasErrors()) {
			UserForm userFormModel = userForm.bindFromRequest().get();
		}
		return ok(views.html.twirl.form.user.render(userForm));
	}
	
	public Result indexb3() {
		Form<UserForm> userForm = formFactory.form(UserForm.class);
		UserForm defaultUser = new UserForm();
		defaultUser.setName("default name");
		defaultUser.setEmail("changeMe!");
		userForm = userForm.fill(defaultUser);
		return ok(views.html.twirl.form.userb3.render(userForm));
	}

	public Result saveb3() {
		Form<UserForm> userForm = formFactory.form(UserForm.class).bindFromRequest();
		if (!userForm.hasErrors()) {
			UserForm userFormModel = userForm.bindFromRequest().get();
		}
		return ok(views.html.twirl.form.userb3.render(userForm));
	}
	

}
