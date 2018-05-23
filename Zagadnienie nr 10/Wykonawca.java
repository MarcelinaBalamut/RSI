import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Wykonawca extends Agent{
	DFAgentDescription desc;
	ServiceDescription service;
	protected void setup(){
		desc = new DFAgentDescription();
	    desc.setName( getAID() ); 
	    service  = new ServiceDescription();
	    service.setType( "POTEGA" );
	    service.setName( getLocalName() );
	    desc.addServices(service);
	    try {  DFService.register(this, desc ); 
	    }  catch (FIPAException e) { e.printStackTrace(); }
	    addBehaviour( new CyclicBehaviour(){
	    	MessageTemplate message = MessageTemplate.MatchPerformative( ACLMessage.REQUEST);
	    	public void action(){
	    		ACLMessage msg = blockingReceive(message);
	    		String message = msg.getContent();
				System.out.println( "Wysylam liczbe " + message);
				Double number = Double.parseDouble(message);
				if(number != null){
					System.out.println("Podana i sparsowana liczba: " + (number));
					number=number*number;
					AID sender = msg.getSender();
					System.out.println("Potega: " + Double.toString(number));
					ACLMessage response = new ACLMessage(ACLMessage.INFORM);
					response.addReceiver(sender);
					response.setContent(Double.toString(number));
					send(response);	}
			else{ block();}} });
}}
