package controllers.twirl;

import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.OK;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import play.Application;
import play.data.FormFactory;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http.RequestBuilder;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

import org.mockito.Mockito;

public class LoginControllerTest extends WithApplication {

	@Override
	protected Application provideApplication() {
		return new GuiceApplicationBuilder().build();
	}
	
	private FormFactory formFactory;

//	@Test
	public void testLoginContext() {
		Map<String, String> parameters = new HashMap<String, String>();
		RequestBuilder fakeRequest = Helpers.fakeRequest().bodyForm(parameters);
		// Helpers.route(controllers.twirl.routes.LoginController.login(),
		// fakeRequest);
		Result result = Helpers.invokeWithContext(fakeRequest, () -> new LoginController(formFactory).login());
		assertEquals(OK, result.status());
	}

//	@Test
	public void testLoginRoute() {
		Result result = Helpers.route(new RequestBuilder().method("post").uri("/twirl/login"));
		assertEquals(OK, result.status());
	}

}
