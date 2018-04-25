import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;


public class Klasa1 extends Agent {
	protected void setup() {
	    System.out.println("Agent "+getLocalName()+" startujê");
	    

	    doDelete();
	  } 

	protected void takeDown(){
		System.out.println("Agent "+getLocalName()+" zaraz siê usunê");
	}


}
