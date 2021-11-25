package MyBank;

import java.util.ArrayList;

// Beskrivning: (Hanterar följande information: kundens namn, personnummer.
//Man kan till exempel kunna ändra kundens namn samt presentera kunden (personnummer,
//för- och efternamn samt kundens konton). Dessutom kan man kunna hantera konton)
//Klassen Customer
//public class Customer extends Account{
public class Customer{
    public ArrayList<Account>accounts;
    //variabler för att hålla namn och persnr
    String name;
    long pNr;

    //konstruktor som ska hämta upp namn och personnr
    public Customer(String name,long pNr){
        this.name=name;
        this.pNr=pNr;
        this.accounts=new ArrayList<>();
    }


    //Beskrivning: (getmetod för att hämta namn på kund)
//Inparametrar: (name)
//Returvärde: (name)

    public String getName(){
        return name;
    }
//Beskrivning: (getmetod för att hämta personnr=pNr på kund)
//Inparametrar: (pNr)
//Returvärde: (pNr)

    public long getpNr(){
        return pNr;
    }
    //Beskrivning: (Setmetod för namn)
//Inparametrar: (name)
//Returvärde: (name)

    public void setName(String Name){
        name=Name;
    }
    //Beskrivning: (Getmetod för namn och personnr)
//Inparametrar: (name pnr)
//Returvärde: (name pnr)

    public String getCustomer(){
        return "Name:"+getName()+"Personalnumber:"+getpNr();

    }
    //Beskrivning: (Metod för att göra om objektet till en sträng)
    // Inparametrar: (namn och pnr)
    //Returvärde: (kundinformationen omgjort till sträng)

    @Override
    public String toString(){
        return ""+getCustomer()+"";

    }
}
