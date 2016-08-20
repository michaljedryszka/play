package controllers.plainform;

import javax.inject.Inject;

import formmodels.User;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class FormController extends Controller{
	
	private FormFactory formFactory;
	
	@Inject
	public FormController(FormFactory formFactory){
		this.formFactory = formFactory;
	}
	
	public Result index(){
		return ok(form("/plainform/post")).withHeader(CONTENT_TYPE, "text/html");
	}
	
	public Result post(){
		DynamicForm form = formFactory.form().bindFromRequest();
		if(form.get("password") == null || form.get("password").isEmpty()){
			return badRequest("Password jest wymagane");
		}
		return ok("Przeslano wartosci: name="+form.get("name"));
	}
	
	public Result bind(){
		return ok(form("/plainform/bindpost")).withHeader(CONTENT_TYPE, "text/html");
	}
	
	public Result bindpost(){
		Form<User> form = formFactory.form(User.class).bindFromRequest();
		User user = form.get();
		if(user.getPassword() == null || user.getPassword().isEmpty()){
			return badRequest("Password jest wymagane");
		}
		
		return ok("Przeslano wartosci: name="+user.getName());
	}
	

	private String form(String action){
		StringBuilder sb = new StringBuilder();
		sb.append("<form action=\"");
		sb.append(action);
		sb.append("\" method=\"post\">");
		sb.append("<br/>Name: <input name=\"name\" type=\"text\"/>");
		sb.append("<br/>Password: <input name=\"password\" type=\"password\"/>");
		sb.append("<br/><input value=\"przeslij\" type=\"submit\"/>");
		sb.append("</form>");
		return sb.toString();
	}
}
