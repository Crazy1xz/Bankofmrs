package MyBank;

// Beskrivning:(hanterar följande information: saldo, kontotyp (Debitkonto) och kontonummer
//Man kan utföra transaktioner (insättning/uttag), hämta kontonummer,
//presentera (kontonummer, saldo, kontotyp,

public class Account{

    double balance;
    String accounttype="Debit";
    int accountid;
    static int accountcounter=1001;
    double amount;

    //konstruktor
    public Account(){
        this.accountid=getAccountId();
        this.balance= 0;
        this.accounttype = accounttype;
    }

    public double getBalance(){
        return balance;
    }

    public String getAccounttype(){
        return accounttype;
    }

    public int getAccountId(){
        accountid=accountcounter;
        accountcounter++;
        return accountid;
    }


    public String getAccount(){
        return accounttype+" Kontoid: "+accountid+" Saldo: "+balance;

    }

    @Override
    public String toString(){
        return "Kontotyp:"+getAccount()+"";
    }

    public double withdraw(double balance){
        if(balance>0){
            return balance-=amount;
        }
        return 0;

    }

    public double deposit(double balance){
        if(balance>0){
            return balance+=amount;
        }
        return 0;
    }
}