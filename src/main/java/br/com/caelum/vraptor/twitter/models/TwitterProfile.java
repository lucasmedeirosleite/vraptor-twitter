package br.com.caelum.vraptor.twitter.models;

public class TwitterProfile {

	private String fullName;
	private String id;
	private String imageUrl;
	private Long numberOfFollowers;
	private Long numberOfFriends;
	private Long numberOfTweets;
	private String screenName;
	
	public TwitterProfile(String id, String screenName, String fullName, String imageUrl, Long numberOfFollowers, Long numberOfFriends, Long numberOfTweets) {
		super();
		this.id = id;
		this.screenName = screenName;
		this.fullName = fullName;
		this.imageUrl = imageUrl;
		this.numberOfFollowers = numberOfFollowers;
		this.numberOfFriends = numberOfFriends;
		this.numberOfTweets = numberOfTweets;
	}

	public String getFullName() {
		return fullName;
	}

	public String getId() {
		return id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Long getNumberOfFollowers() {
		return numberOfFollowers;
	}

	public Long getNumberOfFriends() {
		return numberOfFriends;
	}

	public Long getNumberOfTweets() {
		return numberOfTweets;
	}

	public String getScreenName() {
		return screenName;
	}
	
}
