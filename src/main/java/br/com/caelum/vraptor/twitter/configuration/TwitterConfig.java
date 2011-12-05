package br.com.caelum.vraptor.twitter.configuration;

public interface TwitterConfig {

	String getAccessToken();

	String getAccessTokenSecret();

	String getConsumerKey();

	String getConsumerSecret();
	
	String getCallbackUrl();

}