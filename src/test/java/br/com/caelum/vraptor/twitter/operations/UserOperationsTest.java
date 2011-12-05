package br.com.caelum.vraptor.twitter.operations;

import org.junit.Test;

import br.com.caelum.vraptor.twitter.models.AccessTokenHolder;
import br.com.caelum.vraptor.twitter.models.Tweet;

public class UserOperationsTest {

	private UserOperations operations;
	
	@Test(expected = IllegalStateException.class)
	public void should_not_return_user_profile_when_not_logged_in(){
		operations = new DefaultUserOperations(null, new AccessTokenHolder(), null);
		operations.getUserProfile();
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void should_not_return_user_profile_when_not_logged_in_and_login_action_was_not_called(){
		operations = new DefaultUserOperations(null, null, null);
		operations.getUserProfile();
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void should_not_tweet_when_not_logged_in(){
		operations = new DefaultUserOperations(null, new AccessTokenHolder(), null);
		operations.tweet(new Tweet("a test"));
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void should_not_tweet_when_not_logged_in_and_login_action_was_not_called(){
		operations = new DefaultUserOperations(null, null, null);
		operations.tweet(new Tweet("another test"));
		
	}
	
}
