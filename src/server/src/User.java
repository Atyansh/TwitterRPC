package edu.ucsd.cse124;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;

import java.util.HashSet;
import java.util.LinkedList;

public class User {
  private String handle;

  private Set<User> subscribed;

  private List<TweetKey> tweets;

  private Set<TweetKey> starred;

  public User(String handle) {
    this.handle = handle;
    
    subscribed = new HashSet<>();
    tweets = new LinkedList<>();
  }

  public String getHandle() {
    return handle;
  }

  public void addSubscription(User user) {
    subscribed.add(user);
  }

  public void removeSubscription(User user) {
    subscribed.remove(user);
  }

  public void tweet(TweetKey tKey) {
    tweets.add(tKey);
  }

  public List<Tweet> readTweetsByUser(int count, Map<TweetKey, Tweet> map) {
    List<TweetKey> allTweets = new LinkedList<>(tweets);

    Collections.sort(allTweets);

    List<Tweet> list = new LinkedList<>();

    Iterator<TweetKey> it = allTweets.iterator();

    while(it.hasNext() && count > 0) {
      list.add(map.get(it.next()));
      count--;
    }

    return list;
  }

  public List<Tweet> readTweetsBySubscription(int count, Map<TweetKey, Tweet> map) {
    List<TweetKey> allTweets = new LinkedList<>();

    for(User user : subscribed) {
      allTweets.addAll(user.tweets);
    }

    Collections.sort(allTweets);

    List<Tweet> list = new LinkedList<>();

    Iterator<TweetKey> it = allTweets.iterator();

    while(it.hasNext() && count > 0) {
      list.add(map.get(it.next()));
      count--;
    }

    return list;
  }

  public boolean star(TweetKey tKey) {
    return starred.add(tKey);
  }

  @Override
  public boolean equals(Object o) {
    if(!(o instanceof User)) {
      return false;
    }

    return handle.equals(((User)o).getHandle());
  }

  @Override
  public int hashCode() {
    return handle.hashCode();
  }
}
