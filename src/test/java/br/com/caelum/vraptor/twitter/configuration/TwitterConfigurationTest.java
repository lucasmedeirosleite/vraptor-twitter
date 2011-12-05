package br.com.caelum.vraptor.twitter.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.environment.Environment;

public class TwitterConfigurationTest {
	
	private TwitterConfig configuration;
	private Environment environment;
	
	@Before
	public void setUp(){
		environment = Mockito.mock(Environment.class);
		configuration = new DefaultTwitterConfig(environment);
	}
	
	@Test
	public void should_retrieve_access_token(){
		String accessToken = "wqdhjqwg12312ebdwdwdh23";
		Mockito.when(environment.get("twitter.access_token")).thenReturn(accessToken);
		assertEquals(accessToken, configuration.getAccessToken());
	}
	
	@Test
	public void should_return_null_when_access_token_is_not_defined(){
		Mockito.when(environment.get("twitter.access_token")).thenReturn(null);
		assertNull(configuration.getAccessToken());
	}
	
	@Test
	public void should_retrieve_access_token_secret(){
		String accessTokenSecret = "wqdhjqwg12312ebdwdwdh23";
		Mockito.when(environment.get("twitter.access_token_secret")).thenReturn(accessTokenSecret);
		assertEquals(accessTokenSecret, configuration.getAccessTokenSecret());
	}
	
	@Test
	public void should_return_null_when_access_token_secret_is_not_defined(){
		Mockito.when(environment.get("twitter.access_token_secret")).thenReturn(null);
		assertNull(configuration.getAccessTokenSecret());
	}
	
	@Test
	public void should_retrieve_consumer_key(){
		String consumerKey = "wqdhjqwg12312ebdwdwdh23";
		Mockito.when(environment.get("twitter.consumer_key")).thenReturn(consumerKey);
		assertEquals(consumerKey, configuration.getConsumerKey());
	}
	
	@Test
	public void should_return_null_when_consumer_key_is_not_defined(){
		Mockito.when(environment.get("twitter.consumer_key")).thenReturn(null);
		assertNull(configuration.getConsumerKey());
	}

	@Test
	public void should_retrieve_consumer_secret(){
		String consumerSecret = "wqdhjqwg12312ebdwdwdh23";
		Mockito.when(environment.get("twitter.consumer_secret")).thenReturn(consumerSecret);
		assertEquals(consumerSecret, configuration.getConsumerSecret());
	}
	
	@Test
	public void should_return_null_when_consumer_secret_is_not_defined(){
		Mockito.when(environment.get("twitter.consumer_secret")).thenReturn(null);
		assertNull(configuration.getConsumerSecret());
	}
	
	@Test
	public void should_retrieve_callback_url(){
		String callbackUrl = "localhost:8080";
		Mockito.when(environment.get("twitter.callback_url")).thenReturn(callbackUrl);
		assertEquals(callbackUrl, configuration.getCallbackUrl());
	}
	
	@Test
	public void should_return_null_when_callback_url_is_not_defined(){
		Mockito.when(environment.get("twitter.callback_url")).thenReturn(null);
		assertNull(configuration.getCallbackUrl());
	}
	
}
