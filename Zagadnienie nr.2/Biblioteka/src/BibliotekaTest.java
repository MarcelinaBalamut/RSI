import java.util.ArrayList;
import java.util.Scanner;


public class BibliotekaTest
{


    public static void main(String[] args)
    {
        Ksiazka[] ksiazki =new Ksiazka[6];
        ksiazki[0]=new Ksiazka();
        ksiazki[1]=new Ksiazka("Zofia Nałkowksa", "Granica", false, 100);
        ksiazki[2]=new Ksiazka("WisławaSzymborska", "Wiersze", true,40);
        ksiazki[3]=new Ksiazka("Ewa Nowak", "Zdrowie i uroda", true,120);
        ksiazki[4]=new Ksiazka("Adam Mickiewicz ", "Dziady", true,50);
        ksiazki[5]=new Ksiazka("Bolesław Prus", "Lalka", true,300);


        System.out.println();
        for(int i=0; i<ksiazki.length; i++)
        {

            System.out.println(ksiazki[i]);
        }


        ArrayList<Klient> klienci=new ArrayList<Klient>();

        for(Klient x:klienci)
        {
            x=new Klient();
            klienci.add(x);
        }
        Klient klient=new Klient();
        System.out.println("Wybierz co chcesz zrobic: ");
        System.out.println("Wybierz 1 aby wypozyczyc ksiazke ");
        System.out.println("Wybierz 2 aby zwrocic ksiazke  ");
        System.out.println("Wybierz 3 aby zarezerwowac ksiazke ");
        Scanner input= new Scanner(System.in);
        while(input.hasNextInt())
        {
            int x=input.nextInt();

            switch (x)
            {

                case 1:
                    System.out.println("Wybierz id ksiazki ");
                    int id=input.nextInt();
                    klient.wypozycz(ksiazki[id]);
                    break;
                case 2:
                    System.out.println("Wybierz id ksiazki ");
                    int id1=input.nextInt();
                    klient.zwroc(ksiazki[id1]);
                    break;
                case 3:
                    System.out.println("Wybierz id ksiazki ");
                    int id2=input.nextInt();
                    klient.rezerwuj(ksiazki[id2]);
                    System.out.println("KOD:  ");
                    ksiazki[id2].generujKod();
                    break;
                default:
                    System.out.println("Zly klawisz");
                    break;
            }
        }

    }

}