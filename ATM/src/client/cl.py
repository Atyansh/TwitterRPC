#!/usr/bin/env python

import sys

sys.path.append('gen-py')

from cse124 import ATM
from cse124.ttypes import *

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

try:
  transport = TSocket.TSocket('localhost', 9090)

  # Buffering is critical. Raw sockets are very slow
  transport = TTransport.TBufferedTransport(transport)

  # Wrap in a protocol
  protocol = TBinaryProtocol.TBinaryProtocol(transport)

  # Create a client to use the protocol encoder
  client = ATM.Client(protocol)

  # Connect!
  transport.open()

  client.ping()
  print 'ping()'

  tok = client.login(1234, 1111)
  print 'got token: %d' % (tok)

  isvalid = client.isLoginValid(tok)
  print 'is a valid token valid? %r' % isvalid

  isvalid = client.isLoginValid(tok + 1)
  print 'is an invalid token valid? %r' % isvalid

  bal = client.getBalance(tok)
  print 'current balance: %d' % bal

  client.deposit(tok, 10000)
  print 'deposited $100'

  bal = client.getBalance(tok)
  print 'current balance: %d' % bal

  client.deposit(tok, 5000)
  print 'deposited $50'

  bal = client.getBalance(tok)
  print 'current balance: %d' % bal

  client.logout(tok)
  print 'logout()'

  # Close!
  transport.close()

except Thrift.TException, tx:
  print '%s' % (tx.message)
