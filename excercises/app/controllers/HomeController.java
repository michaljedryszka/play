package controllers;

import javax.inject.Inject;

import com.google.inject.name.Named;

import play.mvc.Controller;
import play.mvc.Result;
import services.CarService;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController extends Controller {
//	@Inject
//	@Named("fiat")
//	private CarService fiatService;
	
//	@Inject
//	@Named("volvo")
//	private CarService volvoService;
	
	@Inject
	public HomeController(@Named("opel") CarService carService,  @Named("opel") CarService carService2){//@Named("volvo")CarService volvoService, @Named("fiat")CarService fiatService){
		System.out.println("------------------------------------------------");
		System.out.println(carService == carService2);
		carService.makeNoise();
//		volvoService.makeNoise();
//		fiatService.makeNoise();
	}

	/**
	 * An action that renders an HTML page with a welcome message. The
	 * configuration in the <code>routes</code> file means that this method will
	 * be called when the application receives a <code>GET</code> request with a
	 * path of <code>/</code>.
	 */
	public Result index() {
		StringBuilder sb = new StringBuilder();
		sb.append("<br/><a href=\"/routing/pathparam/randomPathParam\"> /routing/pathparam/randomPathParam </a>");
		sb.append("<br/><a href=\"/routing/queryparam?queryParam=someQueryParam\"> /routing/queryparam?queryParam=someQueryParam </a>");
		sb.append("<br/><a href=\"/routing/queryparamfixed\"> /routing/queryparamfixed </a>");
		sb.append("<br/><a href=\"/routing/queryparamdefault\"> /routing/queryparamdefault </a>");
		sb.append("<br/><a href=\"/routing/queryparamdefault?queryParam=notDefault\"> /routing/queryparamdefault?queryParam=notDefault </a>");
		sb.append("<br/><a href=\"/routing/queryparamoptional\"> /routing/queryparamoptional </a>");
		sb.append(
				"<br/><a href=\"/routing/queryparamoptional?queryParam=notOptional\"> /routing/queryparamoptional?queryParam=notOptional </a>");
		return ok(sb.toString()).withHeader(CONTENT_TYPE, "text/html");
	}
}
