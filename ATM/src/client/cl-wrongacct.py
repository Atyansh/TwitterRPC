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

  print 'log in with wrong account number'
  tok = client.login(1212, 1111)

  isvalid = client.isLoginValid(tok)
  print 'is a valid token valid? %r' % isvalid

  # Close!
  transport.close()

except NoSuchAccountException:
    print '>>> bad account number'

except InvalidPinException:
    print '>>> bad pin number'

except Thrift.TException, tx:
     print '%s' % (tx.message)
