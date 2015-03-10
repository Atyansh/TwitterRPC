package edu.ucsd.cse124;

import org.apache.thrift.TException;

import edu.ucsd.cse124.NoSuchAccountException;
import edu.ucsd.cse124.InvalidPinException;
import edu.ucsd.cse124.InvalidSessionException;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class ATMHandler implements ATM.Iface {
    protected Map<Integer,Account> accounts;
    protected Map<Integer,Account> loggedIn;
    protected Random rnd;

    public ATMHandler(Map<Integer,Account> accounts) {
        this.accounts = accounts;
        this.loggedIn = new HashMap<Integer,Account>();
        this.rnd = new Random();
    }

    @Override
    public void ping() {
    }

    @Override
    public int login(int acct_num, short pin_num)
        throws NoSuchAccountException, InvalidPinException,
               InvalidSessionException, TException
    {
        System.out.println("login");

        // make sure the account exists
        if (!accounts.containsKey(acct_num)) {
            throw new NoSuchAccountException();
        }

        Account acct = accounts.get(acct_num);
        assert (acct != null);

        // check the pin number
        if (pin_num != acct.pin_number) {
            throw new InvalidPinException();
        }

        // generate a LoginToken associated with this account
        int loginToken = rnd.nextInt(Integer.MAX_VALUE);

        // associate the token with the account
        loggedIn.put(loginToken, acct);

        return loginToken;
    }

    @Override
    public boolean isLoginValid(int token) throws TException
    {
        System.out.println("isLoginValid");

        return loggedIn.containsKey(token);
    }

    @Override
    public long getBalance(int token) throws InvalidSessionException, TException
    {
        System.out.println("getbalance");

        if (!loggedIn.containsKey(token)) {
            throw new InvalidSessionException();
        }

        Account acct = loggedIn.get(token);
        return acct.balance_in_cents;
    }

    @Override
    public void deposit(int token, long amt) throws
        InvalidSessionException, TException
    {
        System.out.println("deposit");

        if (!loggedIn.containsKey(token)) {
            throw new InvalidSessionException();
        }

        Account acct = loggedIn.get(token);
        acct.balance_in_cents += amt;
    }

    @Override
    public void logout(int token) throws InvalidSessionException, TException
    {
        System.out.println("logout");
    }
}
