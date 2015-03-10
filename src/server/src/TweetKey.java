package edu.ucsd.cse124;

public class TweetKey implements Comparable<TweetKey> {
  private long tweetId;
  private long posted;

  public TweetKey(long tweetId, long posted) {
    this.tweetId = tweetId;
    this.posted = posted;
  }

  @Override
  public int compareTo(TweetKey t) {
    if(posted > t.posted) {
      return -1;
    }
    else if(posted < t.posted) {
      return 1;
    }
    else if(tweetId < t.tweetId) {
      return -1;
    }
    else if(tweetId > t.tweetId) {
      return 1;
    }

    return 0;
  }

  @Override
  public boolean equals(Object o) {
    if(!(o instanceof TweetKey)) {
      return false;
    }

    return tweetId == (((TweetKey) o).tweetId);
  }

  @Override
  public int hashCode() {
    return (int)(tweetId^(tweetId>>>32));
  }
}
