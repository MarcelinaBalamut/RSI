import java.util.Random;

public class Ksiazka
{
    private String autor;
    private String tytul;
    private int id;
    private int liczbaStron;
    private boolean status;
    private static int idglobal;
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
    public Ksiazka(String autor, String tytul, boolean status, int strony)
    {
        this.autor=autor;
        this.tytul=tytul;
        this.status=status;
        liczbaStron=strony;
        id=idglobal;
        idglobal++;

    }
    public String toString()
    {
        return "Id: "+id+", Tytul: "+tytul+", Autor: "+autor;
    }
    public Ksiazka()
    {
        this("Jakn Kochanowski", "Wiersze", true, 30);
    }

    static
    {
        idglobal=0;
    }

    public void generujKod() {
        Random r = new Random();
        int[][] tab = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {

                tab[i][j] = r.nextInt(10);
            }
            for (int k = 0; k < 1; k++) {
                for (int j = 0; j < 2; j++) {

                    System.out.print(tab[i][j]);

                }
                System.out.println();
            }


        }
    }

}
