import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;

public class Klasa4 extends Agent {
	protected void setup() {
	    System.out.println("Agent "+getLocalName()+" startujê");
	    
	    addBehaviour(new TreeStepBehaviour());
	  } 

	class TreeStepBehaviour extends Behaviour{
		private int step=0;
		public void action(){
			
			switch(step){
			
			case 0:
				System.out.println(" pierwszy krok");
			step++;
			break;
			
			case 1:
				System.out.println(" drugi krok");
				step++;
				break;
				
			case 2:
				System.out.println(" trzeci krok");
				removeBehaviour(this);
				step++;
				break;
			}
		}
		public boolean done (){
			return step ==3;
	}}
}



