package edu.ucsd.cse124;

import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;

import java.util.HashMap;
import java.util.Map;

public class ATMServer {

 protected static Map<Integer,Account> sampleAccounts() {
    Map<Integer,Account> accounts = new HashMap<Integer,Account>();

    // account number: 1234, pin code 1111
    accounts.put(1234, new Account(1234, (short)1111));
    accounts.put(4567, new Account(4567, (short)4444));
    accounts.put(7890, new Account(7890, (short)7777));

    return accounts;
 }

 public static void StartsimpleServer(ATM.Processor<ATMHandler> processor) {
  try {
   TServerTransport serverTransport = new TServerSocket(9090);
   TServer server = new TSimpleServer(
     new Args(serverTransport).processor(processor));

   // Use this for a multithreaded server
   // TServer server = new TThreadPoolServer(new
   // TThreadPoolServer.Args(serverTransport).processor(processor));

   System.out.println("Starting the simple server...");
   server.serve();
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
 
 public static void main(String[] args) {
    ATMHandler handler = new ATMHandler(sampleAccounts());
    StartsimpleServer(new ATM.Processor<ATMHandler>(handler));
 }

}
