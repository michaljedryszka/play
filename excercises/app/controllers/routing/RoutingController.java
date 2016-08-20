package controllers.routing;

import play.mvc.Controller;
import play.mvc.Result;

public class RoutingController extends Controller{
	
	public Result pathParam(String pathParam){
		return ok("PathParam: " + pathParam);
	}

	public Result queryParam(String queryParam){
		return ok("QueryParam: " + queryParam);
	}
	
	public Result queryParamDefault(String queryParam){
		return ok("QueryParamDefault: " + queryParam);
	}

	public Result queryParamOptional(String queryParam){
		return ok("QueryParamOptional: " + queryParam);
	}

}
