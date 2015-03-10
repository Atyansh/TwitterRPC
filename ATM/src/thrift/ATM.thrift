
namespace java edu.ucsd.cse124
namespace py cse124

typedef i32 AccountNumber
typedef i32 LoginToken

// The account doesn't exist
exception NoSuchAccountException {
}

// The pin number is incorrect for this account
exception InvalidPinException {
}

// The login token provided doesn't exist
exception InvalidSessionException {
}

service ATM {
    void ping(),

    LoginToken login(1:AccountNumber acct_num, 2:i16 pin_num)
        throws (1:NoSuchAccountException acctx, 2:InvalidPinException pinx),

    bool isLoginValid(1:LoginToken token),

    i64 getBalance(1:LoginToken token) throws (1:InvalidSessionException sessx),

    void deposit(1:LoginToken token, 2:i64 amount)
        throws (1:InvalidSessionException sessx),

    void logout(1:LoginToken token) throws (1:InvalidSessionException sessx),
}
