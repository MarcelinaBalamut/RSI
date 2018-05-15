import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
public class ag_odb extends Agent {
	protected void setup() {

		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				ACLMessage msg = myAgent.receive();
				if (msg != null) {
		
					ACLMessage reply = msg.createReply();
					if (msg.getPerformative() == ACLMessage.REQUEST) {
						System.out.println("Received REQUEST from "+msg.getSender().getName());
						System.out.println("Content : "+ msg.getContent());
						reply.setPerformative(ACLMessage.INFORM);
						reply.setContent("wykonalem");
					} else if(msg.getPerformative() == ACLMessage.CFP){
						System.out.println("Received CFP from "+msg.getSender().getName());
						System.out.println("Content : "+msg.getContent());
						reply.setPerformative(ACLMessage.REQUEST);
						reply.setContent("raz jeszcze");}
					else {
						reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
						reply.setContent("nie rozumiem");
					}
					myAgent.send(reply);
				}
				else {block();
				}}	} );	}}