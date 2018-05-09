import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.core.behaviours.ThreadedBehaviourFactory;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;

public class Klasa2_4 extends Agent{
	protected void setup() {
		
	    System.out.println("Agent "+getLocalName()+" startujê");
	
	    SequentialBehaviour treeStep = new SequentialBehaviour();
		
		treeStep.addSubBehaviour( new OneShotBehaviour()
		{
			public void action() {
				System.out.println( "pierwszy krok " );
			}
		});
		treeStep.addSubBehaviour( new OneShotBehaviour()
		{
			public void action() {
				System.out.println( "drugi krok " );
			}
		});
		treeStep.addSubBehaviour( new OneShotBehaviour()
		{
			public void action() {
				System.out.println( "trzeci krok" );
				removeBehaviour(this);
			}
		});
		addBehaviour( treeStep );
	}
}


