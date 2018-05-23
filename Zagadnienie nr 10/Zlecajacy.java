import java.util.Random;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Zlecajacy extends Agent{
	    Zlecajacy Agent;
		Random generator;
		Integer number;
		
	protected void setup() {
		super.setup();		
		
		Agent = this;
		generator = new Random();
		number = null;
		
		addBehaviour(new OneShotBehaviour(this) {
			public void action() {
				System.out.println("zlecajacy losuje liczbe");
			    number = (int)(Math.round(generator.nextDouble()*100));
			    System.out.println("\t"+number);
			}
		});
		FSMBehaviour fsm = new FSMBehaviour(this) {
			public int onEnd() {
				Agent.doDelete();
				return super.onEnd();
			}
		};
		addBehaviour(new TickerBehaviour(this, 2000) {
		      protected void onTick() {
		    	  System.out.println("zlecajacy sprawdza usugi");
		    	  
		          DFAgentDescription desc = new DFAgentDescription();
		          ServiceDescription service = new ServiceDescription();
		          service.setType( "POTEGA" );
		          desc.addServices(service);
		          
		          SearchConstraints sea = new SearchConstraints();
		          sea.setMaxResults(new Long(-1));
		          try
		          {
		              DFAgentDescription[] result = DFService.search(myAgent, desc, sea);
		              System.out.println("Ilosc wyszukanych uslug: " + result.length);
		              if(result.length>0) {
		            	  send(result[0].getName());
		            	  recieve(this);
		              }
		          }
		          catch (FIPAException fe) { System.out.println("problem podczas wyszukania uslugi"); }
		      }
		   });
	}
	private void send(AID aid) {
		  ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
    	  msg.addReceiver(aid);
    	  msg.setContent(Integer.toString(number));
    	  send(msg);
    	  System.out.println(" REQUEST");
	}
	private void recieve(Behaviour b) {
		 MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
			ACLMessage msg1 = blockingReceive(mt);
			if(msg1!= null) {
				if(msg1.getPerformative() == ACLMessage.INFORM){
					System.out.println("zlecajacy odebral wiadomosc INFORM");					
					System.out.println( "\t" + msg1.getContent());
					this.doDelete();
				}
			}
			else {
				b.block();
			}
	}
	protected void takeDown() {
		System.out.println("zlecaj¹cy konczy dzialanie");
	}
}