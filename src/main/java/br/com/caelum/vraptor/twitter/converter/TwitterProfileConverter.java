package br.com.caelum.vraptor.twitter.converter;

import br.com.caelum.vraptor.twitter.models.TwitterProfile;

public interface TwitterProfileConverter {

	TwitterProfile fromJSONProfile(String profile);
	
}
