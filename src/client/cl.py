#!/usr/bin/env python

import sys

from time import sleep

sys.path.append('gen-py')

from cse124 import Twitter
from cse124.ttypes import *

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

failures = 0

def failed():
  global failures
  print "Something went wrong, test failed, quitting now"
  failures += 1

transport = TSocket.TSocket('localhost', 12345)

# Buffering is critical. Raw sockets are very slow
transport = TTransport.TBufferedTransport(transport)

# Wrap in a protocol
protocol = TBinaryProtocol.TBinaryProtocol(transport)

# Create a client to use the protocol encoder
client = Twitter.Client(protocol)

# Connect!
transport.open()

try:
  print "\nCreating Users"
  client.createUser('bob')
  print "Created bob successfully"
  client.createUser('alice')
  print "Created alice successfully"
  client.createUser('oscar')
  print "Created oscar successfully\n"

  print "Creating duplicate bob, should get exception"
  client.createUser('bob')

  failed()
except Thrift.TException, tx:
  print '%s' % (tx)


try:
  print "\nTrying subscribing"
  client.subscribe('alice', 'bob')
  print "alice subscribed to bob successfully"
  client.subscribe('alice', 'oscar')
  print "alice subscribed to oscar successfully\n"

  print "Trying to subscribe to fakeuser, should get exception"
  client.subscribe('alice', 'fakeuser')
  failed()
except Thrift.TException, tx:
  print '%s' % (tx)

try:
  print "\nTrying to subscribe by fakeuser to alice, should get exception"
  client.subscribe('fakeuser', 'alice')
  failed()
except Thrift.TException, tx:
  print '%s' % (tx)


try:
  print "\nPosting some tweets"
  client.post('bob', 'bob1')
  print 'bob tweeted "bob1" successfully'
  sleep(2)
  client.post('bob', 'bob2')
  print 'bob tweeted "bob2" successfully'
  sleep(2)
  client.post('oscar', 'oscar1')
  print 'oscar tweeted "oscar1" successfully'
  sleep(2)
  client.post('bob', 'bob3')
  print 'bob tweeted "bob3" successfully'
  sleep(2)
  client.post('oscar', 'oscar2')
  print 'oscar tweeted "oscar2" successfully\n'
  sleep(2)

  print "Trying to tweet for fakeuser, should get exception"
  client.post('fakeuser', 'fake1')
  failed()
except Thrift.TException, tx:
  print '%s' % (tx)


try:
  print "\nTrying to post a really long tweet, should get exception"
  client.post('bob', 'This tweet is way too long. It has to throw a TweetTooLongException, or the implementation on the server side would have to be incorrect and we would lose points')
  failed()
except Thrift.TException, tx:
  print '%s' % (tx)


try:
  print "\nTrying to read tweets by user, without limits"
  bob_tweets = client.readTweetsByUser('bob',100)
  if len(bob_tweets) != 3:
    failed()
  elif (bob_tweets[0].tweetString != 'bob3' or
        bob_tweets[1].tweetString != 'bob2' or
        bob_tweets[2].tweetString != 'bob1'):
    failed()
  print "Verified by reading bob's tweets"

  print "\nTrying to read tweets by user, with limits"
  oscar_tweets = client.readTweetsByUser('oscar',1)
  if len(oscar_tweets) != 1:
    failed()
  elif oscar_tweets[0].tweetString != 'oscar2':
    failed()
  print "Verified by reading oscar's tweets"

  print "\nTrying to read fakeuser's tweets by user, should get exception"
  fake_tweets = client.readTweetsByUser('fakeuser', 100)
  failed()
except Thrift.TException, tx:
  print '%s' % (tx)


try:
  print "\nTrying to read tweets by subscription, without limits"
  sub_tweets = client.readTweetsBySubscription('alice',100)
  if len(sub_tweets) != 5:
    failed()
  elif (sub_tweets[0].tweetString != 'oscar2' or
        sub_tweets[1].tweetString != 'bob3' or
        sub_tweets[2].tweetString != 'oscar1' or
        sub_tweets[3].tweetString != 'bob2' or
        sub_tweets[4].tweetString != 'bob1'):
    failed()
  print "Verified by reading alice's subscriptions"

  print "\nTrying to read tweets by subscriptions, with limits"
  sub_tweets = client.readTweetsBySubscription('alice',2)
  if len(sub_tweets) != 2:
    failed()
  elif (sub_tweets[0].tweetString != 'oscar2' or
        sub_tweets[1].tweetString != 'bob3'):
    failed()
  print "Verified by reading alice's subscriptions"

  print "\nTrying to read fakeuser's tweets by subscription, should get exception"
  fake_tweets = client.readTweetsBySubscription('fakeuser', 100)
  failed()
except Thrift.TException, tx:
  print '%s' % (tx)


try:
  print "\nTrying to unsubscribe"
  client.unsubscribe('alice','oscar')
  print "alice should have unsubscribed from oscar, verifying now"

  print "\nTrying to read tweets by subscription, without limits"
  sub_tweets = client.readTweetsBySubscription('alice',100)
  if len(sub_tweets) != 3:
    failed()
  elif (sub_tweets[0].tweetString != 'bob3' or
        sub_tweets[1].tweetString != 'bob2' or
        sub_tweets[2].tweetString != 'bob1'):
    failed()
  print "Verified by reading alice's subscriptions"

  print "Trying to unsubscribe from fakeuser, should get exception"
  client.unsubscribe('alice', 'fakeuser')
  failed()
except Thrift.TException, tx:
  print '%s' % (tx)

try:
  print "\nTrying to unsubscribe by fakeuser from alice, should get exception"
  client.unsubscribe('fakeuser', 'alice')
  failed()
except Thrift.TException, tx:
  print '%s' % (tx)


try:
  print "\nTesting tweet star"
  tweet = client.readTweetsByUser('oscar', 1)[0]

  if tweet.numStars != 0:
    failed()

  print "Verified initial number of stars is 0"

  client.star('bob', tweet.tweetId)

  tweet = client.readTweetsByUser('oscar', 1)[0]

  if tweet.numStars != 1:
    failed()

  client.star('alice', tweet.tweetId)
  
  tweet = client.readTweetsByUser('oscar', 1)[0]

  if tweet.numStars != 2:
    failed()

  client.star('oscar', tweet.tweetId)

  tweet = client.readTweetsByUser('oscar', 1)[0]

  if tweet.numStars != 3:
    failed()

  print "Verified numStars changes on starring. Starring self's tweets also verified"

  client.star('oscar', tweet.tweetId)

  tweet = client.readTweetsByUser('oscar', 1)[0]

  if tweet.numStars != 3:
    failed()

  client.star('bob', tweet.tweetId)

  tweet = client.readTweetsByUser('oscar', 1)[0]

  if tweet.numStars != 3:
    failed()

  print "Verified numStars doesn't change if user has already starred it"

  print "\nTrying to star from fakeuser, should get exception"
  client.star('fakeuser', tweet.tweetId)
  failed()
except Thrift.TException, tx:
  print '%s' % (tx)

try:
  print "\nTrying to star a non-existent tweet, should get exception"
  client.star('alice', 10)
  failed()
except Thrift.TException, tx:
  print '%s' % (tx)


print "\n\nAll tests completed"
print "Number of failures: " + str(failures)

# Close!
transport.close()
