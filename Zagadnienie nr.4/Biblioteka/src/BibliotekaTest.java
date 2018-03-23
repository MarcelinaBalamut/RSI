import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.MyException;
import Obsluga.*;
import Personel.*;


public class BibliotekaTest
{


    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        int n=20;
        Ksiazka[] ksiazki =new Ksiazka[n];
        ksiazki[0]=new Ksiazka();
        ksiazki[1]=new Ksiazka("Zofia Nałkowksa", "Granica", false, true, Ksiazka.Okladka.MIEKKA);
        ksiazki[2]=new Ksiazka("WisławaSzymborska", "Wiersze", true,false, Ksiazka.Okladka.TWARDA);
        ksiazki[3]=new Ksiazka("Ewa Nowak", "Zdrowie i uroda", true,false, Ksiazka.Okladka.MIEKKA);
        ksiazki[4]=new Ksiazka("Adam Mickiewicz ", "Dziady", true,false, Ksiazka.Okladka.TWARDA);
        ksiazki[5]=new Ksiazka("Bolesław Prus", "Lalka", true,true, Ksiazka.Okladka.MIEKKA);




        ArrayList<Klient> klienci=new ArrayList<Klient>();

        for(Klient x:klienci)
        {
            x=new Klient();
            klienci.add(x);
        }
        Klient klient=new Klient();
        Bibliotekarz bibliotekarz= new Bibliotekarz(0, 8);
        Kierownik kierownik= new Kierownik(1, 7.5);



                System.out.println("Lista dostepnych ksiazek");
                System.out.println();
                for (int i = 0; i < ksiazki.length; i++) {
                    if (ksiazki[i] == null) {
                        System.out.print("");
                    } else

                        System.out.println(ksiazki[i]);
                }
                System.out.println();
                System.out.println("Wybierz co chcesz zrobic: ");
                System.out.println("Wybierz 1 aby wypozyczyc ksiazke jako klient");
                System.out.println("Wybierz 2 aby zwrocic ksiazke jako klient ");
                System.out.println("Wybierz 3 aby zarezerwowac ksiazke jako klient");
                System.out.println("Wybierz 4 aby zamowic ksiazke jako pracownik");
                System.out.println("Wybierz 5 aby obliczyc wyplaty");
                System.out.println("Wybierz q aby wyjsc");

                while (input.hasNextInt()) {
                    int x = input.nextInt();

                    switch (x) {

                        case 1:
                            System.out.println("Wybierz id ksiazki ");
                            int id = input.nextInt();
                            klient.wypozycz(ksiazki[id]);
                            break;


                        case 2:
                            System.out.println("Wybierz id ksiazki ");

                            try {
                                int id1 = input.nextInt();
                                klient.zwroc(ksiazki[id1]);
                            }
                            catch(InputMismatchException ex){
                                System.err.println("Zly format danych");
                                continue;
                            }
                            catch (Exception e){
                                System.err.println("Wybrano zla ksiazke. Ta ksiazka znajduje sie w bibliotece.");
                                continue;

                            }
                            finally {



                                        System.out.println();
                                        System.out.println("Wybierz co chcesz zrobic: ");
                                        System.out.println("Wybierz 1 aby wypozyczyc ksiazke jako klient");
                                        System.out.println("Wybierz 2 aby zwrocic ksiazke jako klient ");
                                        System.out.println("Wybierz 3 aby zarezerwowac ksiazke jako klient");
                                        System.out.println("Wybierz 4 aby zamowic ksiazke jako pracownik");
                                        System.out.println("Wybierz 5 aby obliczyc wyplaty");
                                        System.out.println("Wybierz q aby wyjsc");
                                    }






                            break;
                        case 3:
                            try {
                                System.out.println("Wybierz id ksiazki ");
                                int id2 = input.nextInt();
                                klient.rezerwuj(ksiazki[id2]);
                            }
                            catch (MyException w){

                            }
                            break;
                        case 4:
                            Ksiazka k = kierownik.zlozZamownienie(bibliotekarz.podajDane(),kierownik.podajDane());


                            for (int i = 0; i < ksiazki.length; i++) {
                                if (ksiazki[i] == null){
                                    ksiazki[i] = k;
                                    break;
                                }



                            }System.out.println("Ksiazka zostala zakupiona");

                            System.out.println("Lista dostepnych ksiazek");
                            System.out.println();
                            for (int i = 0; i < ksiazki.length; i++) {
                                if (ksiazki[i] == null) {
                                    System.out.print("");
                                } else

                                    System.out.println(ksiazki[i]);
                            }
                                break;
                        case 5:
                            System.out.println("Wyplata dla bibliotekarza wynosi: "+bibliotekarz.wyplacWyplate());

                            System.out.println("Wyplata dla kierownika wynosi: "+kierownik.wyplacWyplate());

                            break;
                        default:
                            System.out.println("Zly klawisz");
                            break;

                }
            }



        }
    }

