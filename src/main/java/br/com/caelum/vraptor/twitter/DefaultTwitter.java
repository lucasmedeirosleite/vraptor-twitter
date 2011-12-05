package br.com.caelum.vraptor.twitter;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.twitter.models.AccessTokenHolder;
import br.com.caelum.vraptor.twitter.models.Tweet;
import br.com.caelum.vraptor.twitter.models.TwitterProfile;
import br.com.caelum.vraptor.twitter.oauth.TwitterOAuthService;
import br.com.caelum.vraptor.twitter.operations.UserOperations;

@Component
@RequestScoped
public class DefaultTwitter implements Twitter{

	private TwitterOAuthService service;
	private HttpServletRequest request;
	private UserOperations userOperations;
	private final AccessTokenHolder accessTokenHolder;
	
	public DefaultTwitter(HttpServletRequest request, TwitterOAuthService service, UserOperations userOperations, AccessTokenHolder accessTokenHolder){
		this.service = service;
		this.request = request;
		this.userOperations = userOperations;
		this.accessTokenHolder = accessTokenHolder;
	}
	
	@Override
	public String getLoginUrl() {
		return service.getLoginUrl();
	}

	@Override
	public TwitterProfile getUserProfile() {
		String oauthToken = request.getParameter("oauth_token");
		String oauthVerifier = request.getParameter("oauth_verifier");

		if(oauthToken == null || oauthVerifier == null){
			throw new IllegalStateException("You're not in callback context");
		}
		
		accessTokenHolder.setAccessToken(service.generateAccessToken(oauthToken, oauthVerifier));
		return userOperations.getUserProfile();
	}

	@Override
	public void tweet(Tweet tweet) {
		userOperations.tweet(tweet);
	}
	
}
