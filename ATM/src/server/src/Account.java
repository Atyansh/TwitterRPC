package edu.ucsd.cse124;

public class Account {

    public Account(int acct_num, short pin_num) {
        account_number = acct_num;
        pin_number = pin_num;
        balance_in_cents = 0;
    }

    public int account_number;
    public short pin_number;
    public long balance_in_cents;
}
