import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;


public class Klasa8 extends Agent {
	protected static TickerBehaviour a;

	protected void setup() {
	    System.out.println("Agent "+getLocalName()+" startujê");
	    
	    addBehaviour(new TickerBehaviour(this, 2000) {
		      protected void onTick() {
		        System.out.println("ma³y tick");
		      } 
		    });
	    addBehaviour(a=new TickerBehaviour(this, 5000) {
		      protected void onTick() {
		        System.out.println("du¿y tick");
		      }
		      
		    });
	    addBehaviour(new WakerBehaviour(this, 50000) {
		      protected void handleElapsedTimeout() {
		        System.out.println(" usuwanie du¿ego ticka");
		        removeBehaviour(a);
		      } 
		    });
	    addBehaviour(new WakerBehaviour(this, 100000) {
		      protected void handleElapsedTimeout() {
		        System.out.println(" usuwanie agenta");
		        myAgent.doDelete();
		      } 
		    });
	  } 
}
