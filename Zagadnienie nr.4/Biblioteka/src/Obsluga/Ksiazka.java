package Obsluga;



public class Ksiazka
{
    public enum Okladka {
        TWARDA, MIEKKA;

    }
    private String autor;
    private String tytul;
    private int id;
    private boolean streszczenie;
    private boolean status;
    private static int idglobal;
    Okladka okladka;
    Wypozyczenie wypozyczenie=new Wypozyczenie();

    public int getId()
    {
        return id;
    }
    public boolean getStatus()
    {
        return status;
    }
    public String getTytul()
    {
        return tytul;
    }
    public void setStatus(boolean status)
    {
        this.status=status;
    }
    public Ksiazka(String autor, String tytul, boolean status, boolean streszczenie, Okladka okladka)
    {
        this.autor=autor;
        this.tytul=tytul;
        this.status=status;
        this.streszczenie=streszczenie;
        this.okladka=okladka;
        id=idglobal;
        idglobal++;

    }
    public String toString()
    {
        return "Id: "+id+", Tytul: "+tytul+", Autor: "+autor+" Rodzaj okladki: "+okladka+" Streszczenie "+streszczenie;
    }
    public Ksiazka()
    {
        this("Jakn Kochanowski", "Wiersze", true, true, Okladka.TWARDA);
    }

    static
    {
        idglobal=0;
    }

}
