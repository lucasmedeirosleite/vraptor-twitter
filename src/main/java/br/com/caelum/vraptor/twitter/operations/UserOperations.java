package br.com.caelum.vraptor.twitter.operations;

import br.com.caelum.vraptor.twitter.models.Tweet;
import br.com.caelum.vraptor.twitter.models.TwitterProfile;

public interface UserOperations {

	TwitterProfile getUserProfile();
	void tweet(Tweet tweet);
	
}
