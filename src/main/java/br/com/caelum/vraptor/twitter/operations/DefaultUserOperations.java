package br.com.caelum.vraptor.twitter.operations;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.twitter.converter.TwitterProfileConverter;
import br.com.caelum.vraptor.twitter.models.AccessTokenHolder;
import br.com.caelum.vraptor.twitter.models.Tweet;
import br.com.caelum.vraptor.twitter.models.TwitterProfile;
import br.com.caelum.vraptor.twitter.oauth.TwitterOAuthService;

@Component
public class DefaultUserOperations implements UserOperations {

	private static final String TWEET_URL = "https://api.twitter.com/1/statuses/update.json";
	private static final String AUTHORIZATION_URL = "http://api.twitter.com/1/account/verify_credentials.json";
	
	private TwitterOAuthService oauthService;
	private final AccessTokenHolder accessTokenHolder;
	private final TwitterProfileConverter converter;
	
	public DefaultUserOperations(TwitterOAuthService oauthService, AccessTokenHolder accessTokenHolder, TwitterProfileConverter converter){
		this.oauthService = oauthService;
		this.accessTokenHolder = accessTokenHolder;
		this.converter = converter;
	}
	
	@Override
	public void tweet(Tweet tweet) {
		ensureThatUserIsLogged();
		OAuthRequest request = new OAuthRequest(Verb.POST, TWEET_URL);
		request.addBodyParameter("status", tweet.getDescription());
		oauthService.getOAuthService().signRequest(accessTokenHolder.getAccessToken(), request);
		request.send();
	}

	@Override
	public TwitterProfile getUserProfile() {
		ensureThatUserIsLogged();
		OAuthRequest request = new OAuthRequest(Verb.GET, AUTHORIZATION_URL);
	    oauthService.getOAuthService().signRequest(accessTokenHolder.getAccessToken(), request);
	    Response response = request.send();
		return converter.fromJSONProfile(response.getBody());
	}
	
	private void ensureThatUserIsLogged(){
		if(accessTokenHolder == null || accessTokenHolder.getAccessToken() == null){
			throw new IllegalStateException("You're not logged in");
		}
	}

}
