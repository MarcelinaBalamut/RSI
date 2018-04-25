import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;


public class Klasa2 extends Agent {
	
	protected void setup() {
	    System.out.println("Agent "+getLocalName()+" startuj�");
	   

	    
	    addBehaviour(new OneShotBehaviour(this) {
	        public void action() {
	          System.out.println("wykonuje");
	        } 
	      });
	  
	    
	    doDelete();
	  } 

	protected void takeDown(){
		System.out.println("Agent "+getLocalName()+" zaraz si� usun�");
	}


}
