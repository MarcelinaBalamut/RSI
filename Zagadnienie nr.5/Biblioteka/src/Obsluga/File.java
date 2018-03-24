package Obsluga;

import java.io.*;

public class File implements Serializable {
    private String name;

    public void read(String name) throws IOException { // wyjatek wejscia/wyjscia
        FileReader fileReader =new FileReader(name);
        BufferedReader bufferedReader = new BufferedReader(fileReader); // odczyt linijkami
        try {
            String polecane = bufferedReader.readLine(); 



            while (polecane != null) { // czyta dopoki nie napotka nulla
                System.out.println(polecane);
                polecane = bufferedReader.readLine();

            }
        } finally {
            bufferedReader.close(); //zamkniecie buffera

        }

    }

public void serialize(Klient k) throws NotSerializableException{ // serializacja

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("objects.ser"))) {
            outputStream.writeObject(k); //zapis
            outputStream.close();

        System.out.println("Pomyslna serializacja danych");

    }
    catch (Exception e) {
        e.printStackTrace();
    }

    try  {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("objects.ser")); // deserializacja
       Klient klient= (Klient)inputStream.readObject();        //odczyt
        inputStream.close();
        System.out.println("Pomyslna deserializacja danych");
        System.out.println(klient);  // forma wydruku dzieki toString



    } catch (Exception e) {
        e.printStackTrace();

    }

}

}
