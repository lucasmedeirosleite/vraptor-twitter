package br.com.caelum.vraptor.twitter.oauth;

import javax.annotation.PostConstruct;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.twitter.configuration.TwitterConfig;
import br.com.caelum.vraptor.twitter.converter.TwitterProfileConverter;

@Component
@ApplicationScoped
public class DefaultTwitterOAuthService implements TwitterOAuthService{
	
	private final TwitterConfig configuration;
	private OAuthService service;
	
	public DefaultTwitterOAuthService(TwitterConfig configuration, TwitterProfileConverter converter){
		this.configuration = configuration;
	}
	
	@PostConstruct
	public void init(){
		service =  new ServiceBuilder().provider(TwitterApi.class)
				  .apiKey(configuration.getConsumerKey())
				  .apiSecret(configuration.getConsumerSecret())
				  .callback(configuration.getCallbackUrl())
				  .build();
	}
	
	@Override
	public String getLoginUrl() {
		return service.getAuthorizationUrl(service.getRequestToken());
	}

	@Override
	public OAuthService getOAuthService() {
		return this.service;
	}

	@Override
	public Token generateAccessToken(String oauthToken, String oauthVerifier){
		Verifier verifier = new Verifier(oauthVerifier);
		Token token = new Token(oauthToken, configuration.getConsumerSecret());
		return service.getAccessToken(token, verifier);
	}

}
