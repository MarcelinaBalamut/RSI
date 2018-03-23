package Obsluga;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Wypozyczenie
{

    private  int idKlienta;

    private long idKsiazki;
    private GregorianCalendar dataZwrotu;

    public static double cena=10.50;


    public GregorianCalendar getDataZwrotu()
    {
        return dataZwrotu;
    }
    public int getIdKlienta()
    {

        return idKlienta;
    }
    public void setIdKlienta( int idKlienta)
    {
        this.idKlienta=idKlienta;
    }
    public void wydaj(long idKsiazki)
    {

        dataZwrotu=new GregorianCalendar();
        System.out.println("Klient o numerze id: "+ idKlienta);
        System.out.println("Wypozyczasz ksiazke dnia: ");
        GregorianCalendar dzis=new GregorianCalendar();
        System.out.printf("%tc",dzis);

        dataZwrotu=dzis;
        dataZwrotu.add(Calendar.DAY_OF_YEAR, 30);
        System.out.println();
        System.out.println("Data zwrotu: ");
        System.out.printf("%tc",dataZwrotu);
    }

    public void sprawdzDate(){

        GregorianCalendar dzis=new GregorianCalendar();
        if(dzis.after(dataZwrotu))
        {
            System.out.println("Naliczono opłate za nieterminowy zwrot w wysokosci: "+cena+" zl");
        }
    }




}
