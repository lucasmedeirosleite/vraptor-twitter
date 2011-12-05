package br.com.caelum.vraptor.twitter.configuration;

import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class DefaultTwitterConfig implements TwitterConfig {
	
	private static final String TWITTER_ACCESS_TOKEN = "twitter.access_token";
	private static final String TWITTER_ACCESS_SECRET = "twitter.access_token_secret";
	private static final String TWITTER_CONSUMER_KEY = "twitter.consumer_key";
	private static final String TWITTER_CONSUMER_SECRET = "twitter.consumer_secret";
	private static final String TWITTER_CALLBACK_URL = "twitter.callback_url";
	
	private Environment enviroment;
	
	public DefaultTwitterConfig(Environment environment) {
		this.enviroment = environment;
	}

	@Override
	public String getAccessToken() {
		return enviroment.get(TWITTER_ACCESS_TOKEN);
	}

	@Override
	public String getAccessTokenSecret() {
		return enviroment.get(TWITTER_ACCESS_SECRET);
	}

	@Override
	public String getConsumerKey() {
		return enviroment.get(TWITTER_CONSUMER_KEY);
	}

	@Override
	public String getConsumerSecret() {
		return enviroment.get(TWITTER_CONSUMER_SECRET);
	}

	@Override
	public String getCallbackUrl() {
		return enviroment.get(TWITTER_CALLBACK_URL);
	}

}
