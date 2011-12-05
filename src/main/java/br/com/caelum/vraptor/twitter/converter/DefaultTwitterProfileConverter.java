package br.com.caelum.vraptor.twitter.converter;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.twitter.models.TwitterProfile;

@Component
@ApplicationScoped
public class DefaultTwitterProfileConverter implements TwitterProfileConverter{

	@Override
	public TwitterProfile fromJSONProfile(String profile) {
		JSONObject object = (JSONObject) JSONValue.parse(profile); 
		return new TwitterProfile(object.get("id_str").toString(), 
								  object.get("screen_name").toString(), 
								  object.get("name").toString(), 
								  object.get("profile_image_url").toString(), 
								  new Long(object.get("followers_count").toString()),
								  new Long(object.get("friends_count").toString()),
								  new Long(object.get("statuses_count").toString()));
	}
}
