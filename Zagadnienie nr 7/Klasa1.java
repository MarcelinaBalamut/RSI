import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;


public class Klasa1 extends Agent {
	protected void setup() {
	    System.out.println("Agent "+getLocalName()+" startuj�");
	    

	    doDelete();
	  } 

	protected void takeDown(){
		System.out.println("Agent "+getLocalName()+" zaraz si� usun�");
	}


}
