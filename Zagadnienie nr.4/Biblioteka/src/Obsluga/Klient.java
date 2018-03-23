package Obsluga;

import Exceptions.MyException;

import java.util.GregorianCalendar;


public class Klient {
    private String imie;
    private String nazwisko;
    private int id;
    private char plec;
    private static int idglobal;


    public Klient(String imie, String nazwisko, char plec) {
        id = idglobal;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;

        idglobal++;

    }

    public Klient() {
        this("Jan", "Kowalski", 'm');
    }

    public int getId() {
        return id;
    }

    static {
        idglobal = 0;
    }

    public Wypozyczenie wypozycz(Ksiazka k) {

        k.wypozyczenie.setIdKlienta(id);
        if (k.getStatus() == false) {
            System.out.println("Ksiazka zostala juz wypozyczona");

        } else {
            k.setStatus(false);
            System.out.println("Wypozyczyles ksiazke o id: " + k.getId() + " i tytule " + k.getTytul());
            System.out.println("Twoje wypozyczenie: ");


            k.wypozyczenie.wydaj(k.getId());


        }
        System.out.println();
        System.out.println("Dostepnosc ksiazki " + k.getStatus());
        System.out.println();
        GregorianCalendar dzis = new GregorianCalendar();
        if (dzis.before(k.wypozyczenie.getDataZwrotu())) {
            k.setStatus(false);
        }

        return k.wypozyczenie;
    }

    public void zwroc(Ksiazka k) throws Exception {
        if (k.getStatus() == false) {
            k.setStatus(true);
            System.out.println("Ksiazka zostala zwrocona. Dostepnosc ksiazki " + k.getStatus());
            k.wypozyczenie.sprawdzDate();
        } else
            throw new Exception();
            //System.out.println("Ta ksiazka znajduje sie w bibliotece");


    }

    public void rezerwuj(Ksiazka k) throws MyException{
        if (k.getStatus() == false) {
            System.out.print("Zarezerwowano ksiazke");
        } else {

            throw new MyException(k);


        }


    }
}