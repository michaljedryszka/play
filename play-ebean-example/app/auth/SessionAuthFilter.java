package auth;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

import javax.inject.Inject;
import javax.inject.Singleton;

import akka.stream.Materializer;
import controllers.routes;
import play.mvc.Filter;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;

@Singleton
public class SessionAuthFilter extends Filter {
	
	@Inject
	public SessionAuthFilter(Materializer arg0) {
		super(arg0);
	}

	@Override
	public CompletionStage<Result> apply(Function<RequestHeader, CompletionStage<Result>> next,
			RequestHeader requestHeader) {
		if (requestHeader._underlyingHeader().session().data().contains("authenticated")) {
			return next.apply(requestHeader);
		} else {
			if (requestHeader.uri().startsWith("/login") ||
				requestHeader.uri().startsWith("/assets")
					) {
				return next.apply(requestHeader);
			}else{
				return CompletableFuture.supplyAsync(() -> {
					return new Result(303,
							Collections.singletonMap("Location", routes.LoginController.showlogin().url()));
				});
			}
		}
	}
}
