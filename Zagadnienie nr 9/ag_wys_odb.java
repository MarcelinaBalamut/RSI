import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Random;

public class ag_wys_odb extends Agent {

    Random rand;
    protected void setup() {

        addBehaviour(new CyclicBehaviour(this) {
        public void action() {
            rand = new Random();
            int stan = rand.nextInt(2);
            System.out.println(stan);
            if (stan == 0 ) {
            	
                ACLMessage message = new ACLMessage(ACLMessage.CFP);
                message.addReceiver(new AID("Ala", AID.ISLOCALNAME));
                message.setOntology("presence");
                message.setContent("wysylam CFP");
                send(message);
            }else{
                ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
                message.addReceiver(new AID("Ala", AID.ISLOCALNAME));
                message.setOntology("presence");
                message.setContent("wysylam REQUEST");
                send(message);
            }
           
                    ACLMessage m = myAgent.receive();
                    if (m != null) {
                        System.out.println("message "+m.getContent());
                        if (m.getPerformative() == ACLMessage.INFORM){
                            myAgent.doDelete();
                        }
                    }else {
                        block();
                    }
        }
        });
    }
}