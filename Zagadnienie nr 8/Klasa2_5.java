import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.Agent;

public class Klasa2_5 extends Agent{
	protected void setup() {
		
		ParallelBehaviour cyclic = new ParallelBehaviour();
		cyclic.addSubBehaviour( new CyclicBehaviour()
		{
			public void action() {
				System.out.println( "Cyclic 1" );
			}
		});
		
		cyclic.addSubBehaviour( new CyclicBehaviour()
		{
			public void action() {
				System.out.println( "Cyclic 2" );
			}
		});
		
		addBehaviour(cyclic);
	}
}