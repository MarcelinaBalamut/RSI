package Personel;

import Exceptions.MyException; // import klasy z innego pakietu

import java.util.Scanner;


public class Bibliotekarz extends Pracownik implements Obsluga.Wyplac { // korzystanie z klasy innego pakietu bez importu

    public Bibliotekarz(int id, double godzinyPracy){

        super(id,godzinyPracy);


    }

    public void informuj(Kierownik k){

        try {
            k.zlozZamownienie( podajDane(), k.podajDane());
        } catch (MyException e) {
            e.printStackTrace();
        }


    }
    public String[] podajDane(){

        Scanner input=new Scanner(System.in);
        String tytul, autor;


            System.out.println("Podaj tytul");
            tytul = input.nextLine();
            System.out.println("Podaj autora");
            autor = input.nextLine();
            String[] dane = {tytul, autor};
            return dane;




    }


    public double wyplacWyplate(){
        return 14*20*godzinyPracy;

    }
}
