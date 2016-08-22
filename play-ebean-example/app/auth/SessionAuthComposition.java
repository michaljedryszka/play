package auth;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import controllers.routes;
import play.mvc.Action.Simple;
import play.mvc.Http;
import play.mvc.Result;

public class SessionAuthComposition extends Simple{
	
	private DBAuthService dbAuthService;
	
	@Inject
	public SessionAuthComposition(DBAuthService dbAuthService){
		this.dbAuthService = dbAuthService;
	}
	
	@Override
	public CompletionStage<Result> call(Http.Context ctx) {
		if(!(dbAuthService.isAuthenticated(ctx.session()))){
			if(!ctx._requestHeader().uri().equals(routes.LoginController.showlogin().url())){
				return CompletableFuture.supplyAsync(() -> this.delegate.redirect(routes.LoginController.showlogin()));
			}
		}
		return delegate.call(ctx);
	}

}
