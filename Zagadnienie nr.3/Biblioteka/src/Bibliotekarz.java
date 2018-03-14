import java.util.Scanner;
import java.util.Random;

public class Bibliotekarz extends Pracownik implements Wyplac{

    Bibliotekarz(int id,double godzinyPracy){

        super(id,godzinyPracy);


    }

    public void informuj(Kierownik k){

        k.zlozZamownienie( podajDane(), k.podajDane());




    }
    public String[] podajDane(){

        Scanner input=new Scanner(System.in);
        System.out.println("Podaj tytul");
        String tytul=input.nextLine();
        System.out.println("Podaj autora");
        String autor=input.nextLine();
        String[] dane={tytul, autor};
        return dane;


    }


    public double wyplacWyplate(){
        return 14*20*godzinyPracy;

    }
}
