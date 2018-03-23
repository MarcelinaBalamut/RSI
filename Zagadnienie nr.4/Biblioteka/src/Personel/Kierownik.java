package Personel;



import Obsluga.Ksiazka;
import Obsluga.Ksiazka.*; // import klasy



import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Kierownik extends Pracownik implements Obsluga.Wyplac { // klasa innego pakietu bez importu



    public Kierownik(int id, double godzinyPracy){

        super(id,godzinyPracy);

    }

    public Ksiazka zlozZamownienie(String[] tab, String[]tab1) throws Exceptions.MyException{ // bez importu



        Okladka okladka= Okladka.TWARDA;

         if(Arrays.binarySearch(tab1, "tak")==1){
            okladka= Okladka.TWARDA;

        }
        else
            okladka=Okladka.MIEKKA;





        boolean streszczenie=true;

        if(Arrays.binarySearch(tab1, "tak")==0){
            streszczenie=true;
        }
        else streszczenie=false;


        Ksiazka ksiazka=new Ksiazka(tab[0],tab[1],true, streszczenie,okladka);
         System.out.println("Kod dla nowej ksiazki: ");

              generujKod();


        return ksiazka;

    }

    public String[] podajDane(){
        System.out.println("Podaj reszte danych do zamowienia");
        Scanner input=new Scanner(System.in);
        System.out.println("Podaj rodzaj okladki: tak-twarda, inny klawisz-miekka");
        String okladka=input.nextLine();
        System.out.println("Jesli chcesz zamowic ksiazke wraz ze streszczeniem wpisz tak, jesli nie dowolny klawisz");
        String streszczenie=input.nextLine();
        String[] dane= new String[2];
        dane[0]=streszczenie;
        dane[1]=okladka;
        return dane;

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
    public double wyplacWyplate(){
        return 18*20*godzinyPracy;
    }
}
