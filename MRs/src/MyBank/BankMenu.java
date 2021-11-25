package MyBank;

public class BankMenu
{
    private Bank bank = new Bank();

    // Kör igenom applikation

    public void test()
    {
        System.out.println("Välkommen till Banken MR.s\n");

        // Skriver ut bankinfo
        printBank();

        // Skapar testkunder...
        addCustomer("Brian shaw", 8202267620L, true );
        addCustomer("Arnold schwarzenegger",   8202267620L, false);
        addCustomer("Sylvester stallone", 6911258876L, true );
        addCustomer("King jones", 7505121231L, true );

        // Skriver ut en lista med kunder
        printBank();

        // Byt namn på kund
        changeName("Kim Kardashian", 8202267620L, true);

        // Byt namn på kund som inte finns...
        changeName("Jean dean", 9905221898L, false);

        // Ssriver ut kund med konton
        printCustomer(8202267620L);

        // Skapa konton
        addAccount(8202267620L);	// 1001
        addAccount(6911258876L);	// 1002
        addAccount(8202267620L);	// 1003
        addAccount(7505121231L); // 1004

        // SKriver ut kunderna inklusive konton
        printCustomer(8202267620L);
        printCustomer(6911258876L);
        printCustomer(7505121231L);

        // Sätter in 700 kr på konto 1002 (ska ej gå pga fel kontoägare)
        deposit(8202267620L, 1002, 700, true);

        // Sätter in 500 kr på konto 1001
        deposit(8202267620L, 1001, 500, true);

        // Ta ut 500 kr på konto 1001
        withdraw(8202267620L, 1001, 500, true);

        // Ta ut 1 kr på konto 1001 (ska ej gå)
        withdraw(8202267620L, 1001, 1, true);

        // Sätter in 1000 kr på konto 1001
        deposit(8202267620L, 1001, 1000, true);

        // Skriver ut kunderna inklusive konton
        printCustomer(8202267620L);
        printCustomer(6911258876L);
        printCustomer(7505121231L);

        // Skriv ut kontoinformation
        printAccount(8202267620L, 1001);
        printAccount(8202267620L, 1002);	// Går ej pga fel kontoägare

        // Avslutar konto
        closeAccount(1001);

        printBank();

        // Sätter in 5000 kr på konto 1003
        deposit(8202267620L, 1003, 5000, true);

        // Sätter in 5000 kr på konto 1003
        deposit(8202267620L, 1003, 5000, true);
        printBank();

        addAccount(7505121231L); // Skapar konto 1005

        printCustomer(8202267620L);
        printCustomer(6911258876L);
        printCustomer(7505121231L);


        // Sätter in 1000 kr på konto 1005
        deposit(7505121231L, 1005, 1000, true);

        // Tar ut 100 kr tre gånger på konto 1005
        withdraw(7505121231L, 1005, 100, true);
        withdraw(7505121231L, 1005, 100, true);
        withdraw(7505121231L, 1005, 100, true);

        printBank();

        // Skriv ut kontoinformation
        printCustomer(7505121231L);

        // Tar bort kund
        removeCustomer(7505121231L);

        printBank();
        printAccount(6911258876L, 1003);

        // Insättningen går inte pga fel kontoägare
        deposit(6911258876L, 1003, 900, true);

        // Sätter in 900 kr på konto 1002
        deposit(6911258876L, 1002, 900, true);

        printCustomer(8202267620L);
        printCustomer(6911258876L);
        printCustomer(7505121231L);

        // Tar ut 900 kr från konto 1002
        withdraw(6911258876L, 1002, 900, true);

        // Tar bort kund
        removeCustomer(6911258876L);
        printBank();

        // Tar bort kund
        removeCustomer(8202267620L);
        printBank();
    }

    /**
     * Hjälpmetod för att skriva ut kundlistan
     */
    private void printBank()
    {
        System.out.println("\n BANKEN-MR.s");
        System.out.println(bank.infoBank());
    }

    /**
     * Hjälpmetod för att skriva ut en kund
     * pNr - Personnummer
     */
    private void printCustomer(long pNr)
    {
        System.out.println("\n UTSKRIFT AV KUND\t" + pNr);
        System.out.println(bank.infoCustomer(pNr));
    }

    /**
     * Hjälpmetod för att skriva ut information om ett konto
     * pNr - Personnummer
     * accountId - Kontonummer
     */
    private void printAccount(long pNr, int accountId)
    {
        System.out.println("\n UTSKRIFT AV KONTO\t" + pNr + "\t" + accountId);
        System.out.println();
    }

    /**
     * Hjälpmetod som skapar upp en kund samt skriver ut om testet blev godkänt
     * name - Kundens namn (för och efternamn)
     * pNr - Kundens personnummer
     * check - skicka in true om det borde fungera eller false om det inte borde gå skapa kund
     */
    private void addCustomer(String name, long pNr, boolean check)
    {
        System.out.println(" SKAPA KUND\t" + pNr + "\t" + name);
        if(bank.addCustomer(name, pNr) == check)
            System.out.println("\t- OK!");
        else
            System.out.println("\t- FEL!");
    }

    /**
     * Hjälpmetod som byter namn på en kund samt skriver ut om testet blev godkänt
     * name - Kundens namn (för och efternamn)
     * pNr - Kundens personnummer
     * check - skicka in true om det borde fungera eller false om det inte borde gå skapa kund
     */
    private void changeName(String name, long pNr, boolean check)
    {
        System.out.println(" ÄNDRA NAMN\t" + pNr + "\t" + name);
        if(bank.changeCustomerName(name, pNr) == check)
            System.out.println("\t- OK!");
        else
            System.out.println("\t- FEL!");
    }


    /**
     * Hjälpmetod som skapar upp ett konto samt skriver ut OK! om kontot skapades eller FEL! om kontot inte skapades
     * Konto kan bara skapas om man kunden existerar
     * pNr - kontoägaren
     */
    private void addAccount(long pNr)
    {
        int id = bank.addAccount(pNr);
        System.out.println(" SKAPA KONTO\t" + pNr + "\t" + id);
        if(id == -1)
            System.out.println("\t- FEL!");
        else
            System.out.println("\t- OK!");
    }


    /**
     * Hjälpmetod som sätter in pengar på konto samt skriver ut om testet blev godkänt
     * Ska bara gå göra om man skickar in personnummer och kontonummer som hör ihop
     * pNr - kontoägaren
     * accountId - kontonummret
     * amount - belopp
     * check - skicka in true om det borde fungera eller false om det inte borde gå sätta in pengar
     */
    private void deposit(long pNr, int accountId, int amount, boolean check)
    {
        System.out.println(" INSÄTTNING\t" + pNr + "\t" + accountId + "\t" + amount + " kr");
        if(bank.deposit(pNr, accountId, amount) == check)
            System.out.println("\t- OK!");
        else
            System.out.println("\t- FEL!");
    }

    /**
     * Hjälpmetod som tar ut pengar från konto samt skriver ut om testet blev godkänt
     * Ska bara gå göra om man skickar in personnummer och kontonummer som hör ihop samt om belopp finns
     * pNr - kontoägaren
     * accountId - kontonummret
     * amount - belopp
     * check - skicka in true om det borde fungera eller false om det inte borde gå sätta in pengar
     */
    private void withdraw(long pNr, int accountId, int amount, boolean check)
    {
        System.out.println(" UTTAG\t" + pNr + "\t" + accountId + "\t-" + amount + " kr");
        if(bank.withdraw(pNr, accountId, amount) == check)
            System.out.println("\t- OK!");
        else
            System.out.println("\t- FEL!");
    }

    /**
     * Hjälpmetod som stänger ett konto samt skriver ut information inklusive ränta man får
     * Ska bara gå göra om man skickar in personnummer och kontonummer som hör ihop
     * pNr - kundägaren
     * accountId - kontonummret
     */
    private void closeAccount(int accountId)
    {
        System.out.println(" AVSLUTA KONTO\t" + (long) 8202267620L + "\t" + accountId);
        System.out.println(bank.closeAccount(8202267620L, accountId));
    }

    /**
     * Hjälpmetod som tar bort en kund inklusive konton från banken
     * pNr - kund
     */
    private void removeCustomer(long pNr)
    {
        System.out.println("TA BORT KUND (+ KONTON)\t" + pNr);
        System.out.println(bank.removeCustomer(pNr));
    }

    /**
     * Skapar en instans av BankMenu-klassen och kör igång menyn
     * args argument används inte
     */
    public static void main(String[] args)
    {

        BankMenu bankMenu = new BankMenu();
        bankMenu.test();
    }
}