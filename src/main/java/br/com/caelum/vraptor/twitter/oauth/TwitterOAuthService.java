package br.com.caelum.vraptor.twitter.oauth;

import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

public interface TwitterOAuthService{

	String getLoginUrl();
	Token generateAccessToken(String oauthToken, String oauthVerifier);
	OAuthService getOAuthService();
}
