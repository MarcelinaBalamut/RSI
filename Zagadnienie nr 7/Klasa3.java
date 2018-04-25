import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class Klasa3 extends Agent {

	protected void setup() {
	    System.out.println("Agent "+getLocalName()+" startujê");
 
	    addBehaviour(new OneShotBehaviour(this) {
	        public void action() {
	          System.out.println("wykonuje");
	        } 
	      });
	    addBehaviour(new CyclicBehaviour(this) {
	        public void action() {
	          System.out.println("wykonuje cyklicznie");
	        } 
	      });
	  } 
}
