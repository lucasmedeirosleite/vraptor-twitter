package br.com.caelum.vraptor.twitter;

import br.com.caelum.vraptor.twitter.models.Tweet;
import br.com.caelum.vraptor.twitter.models.TwitterProfile;

public interface Twitter {
	
	String getLoginUrl();
	TwitterProfile getUserProfile();
	void tweet(Tweet tweet);
	
}
