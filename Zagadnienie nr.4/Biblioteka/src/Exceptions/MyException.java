package Exceptions;


import Obsluga.Ksiazka;

public class MyException extends Exception {


    public MyException(Ksiazka k){
        int id=k.getId();

        System.out.println("Ksiazka o id: "+ id+" jest dostepna, mozesz przejsc do wypozyczenia");

    }
}
