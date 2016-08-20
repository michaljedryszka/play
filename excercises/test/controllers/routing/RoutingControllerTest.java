package controllers.routing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.contentAsString;

import org.junit.Test;

import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Result;
import play.test.WithApplication;

public class RoutingControllerTest extends WithApplication{

	  @Override
	  protected Application provideApplication() {
	    return new GuiceApplicationBuilder()
//	      .configure("play.http.router", "javaguide.tests.Routes")
	      .build();
	  }
	  
	  //activator// testOnly controllers.routing.RoutingControllerTest
	  @Test
	  public void testIndex() {
	    Result result = new RoutingController().pathParam("pathParam");
	    assertEquals(OK, result.status());
	    //assertEquals("text/html", result.contentType().get());
	    //assertEquals("utf-8", result.charset().get());
	    System.out.println(contentAsString(result));
	    assertTrue(contentAsString(result).contains("pathParam"));
	    result.session();
	  }	  
}
