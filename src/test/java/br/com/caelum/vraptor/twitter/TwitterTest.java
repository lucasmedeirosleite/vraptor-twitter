package br.com.caelum.vraptor.twitter;

import javax.servlet.http.HttpServletRequest;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.twitter.models.AccessTokenHolder;
import br.com.caelum.vraptor.twitter.oauth.TwitterOAuthService;
import br.com.caelum.vraptor.twitter.operations.UserOperations;


public class TwitterTest {

	private Twitter provider;
	private TwitterOAuthService service;
	private HttpServletRequest request;
	private UserOperations userOperations;
	
	@Before
	public void setUp(){
		service = Mockito.mock(TwitterOAuthService.class);
		request = Mockito.mock(HttpServletRequest.class);
		userOperations = Mockito.mock(UserOperations.class);
		provider = new DefaultTwitter(request, service, userOperations, new AccessTokenHolder());
	}
	
	@Test
	public void should_give_a_twitter_login_url(){
		Mockito.when(service.getLoginUrl()).thenReturn("https://api.twitter.com/oauth/authorize?oauth_token=thuu sCYmjrRQTikZ0ohHWHenBxsL6zA5e281HeLxR8");
		Assert.assertNotNull(provider.getLoginUrl());
		Assert.assertTrue(provider.getLoginUrl().startsWith("https://api.twitter.com/oauth/authorize"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void should_not_give_login_url(){
		Mockito.when(service.getLoginUrl()).thenThrow(new IllegalArgumentException("Exception during the creation of a login url"));
		provider.getLoginUrl();
	}
	
	@Test(expected = IllegalStateException.class)
	public void should_not_give_user_profile_when_not_in_callback_context(){
		Mockito.when(request.getParameter("oauth_token")).thenReturn(null);
		Mockito.when(request.getParameter("oauth_verifier")).thenReturn(null);
		provider.getUserProfile();
	}
	
}
