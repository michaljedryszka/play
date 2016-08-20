package controllers.twirl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static play.test.Helpers.contentAsString;

import java.util.Map;
import java.util.HashMap;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Module;

import play.Application;
import play.ApplicationLoader;
import play.Environment;
import play.inject.guice.GuiceApplicationBuilder;
import play.inject.guice.GuiceApplicationLoader;
import play.mvc.Http.RequestBuilder;
import play.mvc.Result;
import play.test.Helpers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FunctionalLoginControllerTest {
	
    @Inject
    Application application;

    @Before
    public void setup() {
        Module testModule = new AbstractModule() {
            @Override
            public void configure() {
                // Install custom test binding here
            }
        };

        GuiceApplicationBuilder builder = new GuiceApplicationLoader()
                .builder(new ApplicationLoader.Context(Environment.simple()))
                .overrides(testModule);
        Guice.createInjector(builder.applicationModule()).injectMembers(this);

        Helpers.start(application);
    }
    
    @After
    public void teardown() {
        Helpers.stop(application);
    }    
    
    @Test
    public void renderLoginPage() {
        Result result = Helpers.route(application, controllers.twirl.routes.LoginController.index());
        assertThat(result.status(), equalTo(Helpers.OK));
        assertTrue(contentAsString(result).contains("password"));
    }
    
    @Test
    public void submitLoginPage() {
    	Map<String, String> data = new HashMap();
    	data.put("name", "name");
    	data.put("password", "password");
    	Result result = Helpers.route(application, Helpers.fakeRequest().bodyForm(data).method("POST").uri(
    			controllers.twirl.routes.LoginController.login().url()));
        assertTrue(result.status() == Helpers.SEE_OTHER);
    }

}
