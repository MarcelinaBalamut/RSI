abstract public class Pracownik {

    private int id;
     double godzinyPracy;

    Pracownik(int id, double godzinyPracy){
        this.id=id;
        this.godzinyPracy=godzinyPracy;

    }
   abstract public String[] podajDane();

}
