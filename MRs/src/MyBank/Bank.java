package MyBank;
// Beskrivning: (Innehåller en lista med alla inlagda kunder.
//Klassen ska innehålla ett antal publika metoder som hanterar kunder och dess konton.)
import java.util.ArrayList;


//public class Bank extends Account{
public class Bank {

    //Deklarerar arraylistan som ska innehålla kunder
    public ArrayList<Customer> customers;

    //konstruktor som instansierar arraylistan
    public Bank() {
        super();
        customers = new ArrayList<>();
    }

//Beskrivning: (Returnerar en sträng med alla bankens kunder)
//Inparametrar: (pNr och namn)
//Returvärde: (Returnerar en sträng med alla bankens kunder)

    public String infoBank() {
        String info = "";
        for (Customer customer : customers) info += customer.getCustomer() + "\n";
        return info;
    }


    // Beskrivning: (Skapar ny kund med pNr och name)
    // Inparametrar: (Kund ska endast skapas om inte pNr finns.)
    // Returvärde: (True om det lyckats annars false)

    public boolean addCustomer(String name, long pNr) {
        for (Customer customer : customers) {
            if (pNr == customer.pNr) return false;
        }
        customers.add(new Customer(name, pNr));
        return true;
    }

    // Beskrivning: (Returnerar sträng med presentation av vald kund(pNr+namn och eventuella konton))
    // Inparametrar: (pNr)
    // Returvärde: (pNr+namn och eventuella konton)

    public String infoCustomer(long pNr) {
        for (Customer customer : customers) {
            if (customer.getpNr() == pNr) {
                String info = customer.getCustomer();
                for (Account account : customer.accounts) {
                    info += account.getAccount() + "\n";
                }
                return info;
            }
        }
        return "Ingen kund med det personnummret.";
    }

    // Beskrivning: (Tar bort kund med personnummer pNr ur banken, alla kundens eventuella konton tas
    //också bort och resultatet returneras. Strängen som returneras ska ha innehålla
    //information om vilka konton som togs bort, saldot som kunden får tillbaka)
    // Inparametrar: (pNr)
    // Returvärde: (info om borttagen kunds konto)

    public String removeCustomer(long pNr) {
        for (Customer customer : customers) {
            if (customer.getpNr() == pNr) {
                String info = customer.getCustomer();
                customers.remove(customer);
                int total = 0;
                for (Account account : customer.accounts) {
                    info += account.getAccount() + "\n";
                    total += account.balance;
                }
                return "Kund borttagen: " + info + "\n Saldo total: " + total;
            }
        }
        return null;
    }

    // Beskrivning: (Skapar ett konto till kund med personnummer pNr)
    // Inparametrar: (pNr)
    // Returvärde: (returnerar kontonumret som det
    //skapade kontot fick alternativt returneras –1 om inget konto skapades)

    public int addAccount(long pNr) {
        for (Customer customer : customers) {
            if (customer.getpNr() == pNr) {
                Account newaccount = new Account();
                customer.accounts.add(newaccount);
                return newaccount.accountid;
            }
        }
        return -1;
    }
    // Beskrivning: (Byter namn på kund med rätt personnummer pNr till nytt name)
    // Inparametrar: (pNr)
    // Returvärde: (returnerar true om namnet ändrades annars returnerar false)

    public boolean changeCustomerName(String name, long pNr) {
        for (Customer customer : customers)
            //ifsats för att kolla om customers pnr är lika som det sökta
            if (customer.getpNr() == pNr) {
                customer.setName(name);
                return true;
            }
        return false;
    }

//Beskrivning: (Gör en insättning på konto med kontonnummer accountId som tillhör kunden pNr)
//Inparametrar: (long pNr,int accountid,double amount)
//Returvärde: (returnerar true om det gick bra annars false)

    public boolean deposit(long pNr, int accountId, double amount) {
        for (Customer customer : customers) {
            if (customer.pNr == pNr) {
                for (Account account : customer.accounts) {
                    if (account.accountid == accountId) {
                        account.balance += amount;
                        return true;
                    }
                }
            }
        }
        return false;
    }

//Beskrivning: (Gör ett uttag på konto med kontonnummer accountId som tillhör kunden pNr)
//Inparametrar: (long pNr,int accountId,int amount)
//Returvärde: (returnerar true om det gick bra annars false)

    public boolean withdraw(long pNr, int accountId, int amount) {
        for (Customer customer : customers) {
            if (customer.pNr == pNr) {
                for (Account account : customer.accounts) {
                    if (account.accountid == accountId) {
                        if (account.balance >= amount) {
                            account.balance -= amount;
                            return true;
                        } else return false;
                    }
                }
            }
        }
        return false;
    }
//Beskrivning: (Returnerar en String som innehåller presentation av kontot med kontonnummer
//accountId som tillhör kunden pNr (kontonummer, saldo, kontotyp)
//Inparametrar: (long pNr,int accountId)
//Returvärde: (Returnerar en String som innehåller presentation av kontot med kontonnummer
//accountId som tillhör kunden pNr (kontonummer, saldo, kontotyp)

// Beskrivning: (Stänger ett konto med kontonnummer accountId som tillhör kunden pNr,
// Inparametrar: (long pNr ,int accountId)
// Returvärde: (presentation av kontots saldo)

    public String closeAccount(long pNr, int accountId) {
        for (Customer customer : customers) {
            if (customer.pNr == pNr) {
                for (Account account : customer.accounts) {
                    if (account.accountid == accountId) {
                        String info = account.getAccount();
                        customer.accounts.remove(account);
                        return "Kontot avslutat." + info;
                    }
                }
            }
        }
        return "Kontot existerar inte.";
    }
}
