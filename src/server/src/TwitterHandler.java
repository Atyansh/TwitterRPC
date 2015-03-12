package edu.ucsd.cse124;

import java.util.List;
import java.util.Map;

import java.util.LinkedList;
import java.util.HashMap;

public class TwitterHandler implements Twitter.Iface {

  private final int MAX_TWEET_LENGTH = 140;

  private static long tweetCount = 0;

  private Map<String,User> users;
  private Map<TweetKey,Tweet> tweets;

  public TwitterHandler() {
    users = new HashMap<>();
    tweets = new HashMap<>();
  }

  @Override
  public void ping() {
    System.out.println("ping()");
  }

  @Override
  public synchronized void createUser(String handle) throws AlreadyExistsException {
    if(users.containsKey(handle)) {
      throw new AlreadyExistsException(handle);
    }
    users.put(handle, new User(handle));
  }

  @Override
  public synchronized void subscribe(String handle, String theirhandle)
                        throws NoSuchUserException {
    User subscriber = users.get(handle);
    User subscribee = users.get(theirhandle);

    if(subscriber == null) {
      throw new NoSuchUserException(handle);
    }
    if(subscribee == null) {
      throw new NoSuchUserException(theirhandle);
    }

    subscriber.addSubscription(subscribee);
  }

  @Override
  public synchronized void unsubscribe(String handle, String theirhandle)
                          throws NoSuchUserException {
    User subscriber = users.get(handle);
    User subscribee = users.get(theirhandle);

    if(subscriber == null) {
      throw new NoSuchUserException(handle);
    }
    if(subscribee == null) {
      throw new NoSuchUserException(theirhandle);
    }

    subscriber.removeSubscription(subscribee);
  }

  @Override
  public synchronized void post(String handle, String tweetString)
                   throws NoSuchUserException, TweetTooLongException {
    User user = users.get(handle);

    if(user == null) {
      throw new NoSuchUserException(handle);
    }

    if(tweetString.length() > MAX_TWEET_LENGTH) {
      throw new TweetTooLongException();
    }
    
    Tweet tweet = new Tweet();

    tweet.handle = handle;
    tweet.tweetId = tweetCount++;
    tweet.posted = System.currentTimeMillis()/1000;
    tweet.numStars = 0;
    tweet.tweetString = tweetString;

    TweetKey tKey = new TweetKey(tweet.tweetId, tweet.posted);

    tweets.put(tKey, tweet);
    user.tweet(tKey);
  }

  @Override
  public synchronized List<Tweet> readTweetsByUser(String handle, int howmany)
                                      throws NoSuchUserException {
    User user = users.get(handle);

    if(user == null) {
      throw new NoSuchUserException(handle);
    }

    if(howmany <= 0) {
      return new LinkedList<Tweet>();
    }

    return user.readTweetsByUser(howmany, tweets);
  }

  @Override
  public synchronized List<Tweet> readTweetsBySubscription(String handle, int howmany)
                                              throws NoSuchUserException {
    User user = users.get(handle);

    if(user == null) {
      throw new NoSuchUserException(handle);
    }

    if(howmany <= 0) {
      return new LinkedList<Tweet>();
    }

    return user.readTweetsBySubscription(howmany, tweets);
  }

  @Override
  public synchronized void star(String handle, long tweetId) throws NoSuchUserException,
                                                       NoSuchTweetException {
    User user = users.get(handle);
    
    TweetKey tKey = new TweetKey(tweetId, 0);

    Tweet tweet = tweets.get(tKey);

    if(user == null) {
      throw new NoSuchUserException(handle);
    }
    if(tweet == null) {
      throw new NoSuchTweetException();
    }

    if(user.star(tKey)) {
      tweet.numStars++;
    }
  }
}
