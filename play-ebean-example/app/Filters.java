import javax.inject.Inject;
import javax.inject.Singleton;

import auth.SessionAuthFilter;
import play.http.HttpFilters;
import play.mvc.EssentialFilter;

@Singleton
public class Filters implements HttpFilters {

	private final SessionAuthFilter sessionAuthFilter;

	@Inject
	public Filters(SessionAuthFilter sessionAuthFilter) {
		this.sessionAuthFilter = sessionAuthFilter;
	}

	@Override
	public EssentialFilter[] filters() {
		return new EssentialFilter[] { sessionAuthFilter };
		//return new EssentialFilter[] {};
	}

}
