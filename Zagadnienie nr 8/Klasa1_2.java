import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;


public class Klasa1_2 extends Agent{
	
	private static final String A = "A";
	private static final String B = "B";
	private static final String C = "C";
	private static final String D = "D";
	private static final String E = "E";


	private static Agent anAgent;
	/**
	 * @param args
	 */
	protected void setup(){
		FSMBehaviour sampleFSM = new FSMBehaviour(this);
		
		sampleFSM.registerFirstState(new namePrint(), A); 
		
		sampleFSM.registerState(new Random(2), B);
		sampleFSM.registerState(new namePrint(), C);
		sampleFSM.registerState(new Random(2), D);
		sampleFSM.registerLastState(new namePrint(), E);
		
		sampleFSM.registerDefaultTransition(A,B);
		sampleFSM.registerTransition(B, C,1);
		sampleFSM.registerTransition(B, D,0);
		sampleFSM.registerDefaultTransition(C,D);
		sampleFSM.registerTransition(D, A,1);
		sampleFSM.registerTransition(D, E,0);
		
		addBehaviour(sampleFSM);
	}
	
class namePrint extends OneShotBehaviour{
		
		public void action(){
			System.out.println("Nazwa stanu: "+getBehaviourName())	;
		}
		
			
		}

class Random extends OneShotBehaviour{
	private int maxExitValue;
	private int exitValue;
	
	private Random(int max) {
		super();
		maxExitValue = max;
	}
	public void action(){
		System.out.println("Nazwa stanu: "+getBehaviourName())	;
		exitValue = (int) (Math.random() * maxExitValue);
		System.out.println("Exit value is "+exitValue);
		
	}
	public int onEnd() {
		return exitValue;
	}
	
		
	}
		
}
	


