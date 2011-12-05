package br.com.caelum.vraptor.twitter.models;

import org.scribe.model.Token;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class AccessTokenHolder {

	private Token accessToken;

	public Token getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(Token accessToken) {
		this.accessToken = accessToken;
	}
	
}
