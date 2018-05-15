import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ag_pl extends Agent {
	
    private MessageTemplate template = MessageTemplate.MatchLanguage("Poland");
    protected void setup() {

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
               

                ACLMessage msg = myAgent.receive(template);
                if (msg != null) {
                        System.out.println("message from agent : " + msg.getSender().getName());
                        System.out.println("content " + msg.getContent());
                }
                else {
                    block();
                }
            }
        } );
    }
}