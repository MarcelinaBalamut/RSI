
import jade.core.*;

import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.domain.*;
import jade.domain.JADEAgentManagement.*;
import jade.content.onto.basic.*;

public class Request2AMSAgent extends Agent {

  public void setup() {

    getContentManager().registerLanguage(new jade.content.lang.sl.SLCodec(0));

    getContentManager().registerOntology(JADEManagementOntology.getInstance());

    CreateAgent agent = new CreateAgent();

    agent.setAgentName("john");

    agent.setClassName("jade.core.Agent");

    agent.setContainer(new ContainerID("Main-Container", null));

    Action action = new Action(getAMS(), agent);

    ACLMessage req = new ACLMessage(ACLMessage.REQUEST);
    req.addReceiver(getAMS());


    req.setOntology(JADEManagementOntology.getInstance().getName());

    req.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);

    req.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
    try
    {
      getContentManager().fillContent(req, action);
      addBehaviour(new AchieveREInitiator(this, req) {

        protected void handleInform(ACLMessage inform) {
          System.out.println("Agent  created");
        }

        protected void handleFailure(ACLMessage failure) {
          System.out.println("Error creating" + failure);
        }
      } );
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }


    addBehaviour(new WakerBehaviour(this, 2000)
    {
      protected void onWake() {

    	WhereIsAgentAction whereAgent = new WhereIsAgentAction();
        whereAgent.setAgentIdentifier(new AID("john", AID.ISLOCALNAME));

        Action action = new Action(getAMS(), whereAgent);
        ACLMessage req = new ACLMessage(ACLMessage.REQUEST);
        req.addReceiver(getAMS());

        req.setOntology(JADEManagementOntology.getInstance().getName());

        req.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);

        req.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);

        try { 
          getContentManager().fillContent(req, action);
          addBehaviour(new AchieveREInitiator(myAgent, req) {
            protected void handleInform(ACLMessage inform) {
              try {
                Result result = (Result)myAgent.getContentManager().extractContent(inform);
                ContainerID container = (ContainerID) result.getValue();
                System.out.println("john is in "+container);
              }
              catch (Exception e) {
            	System.out.println("john was killed");
              }
            }
          });
        }
        catch (Exception e) {
        	System.out.println("john was killed");
        }
      }
    });
  }
  protected void takeDown() {
	    ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
	    msg.addReceiver(getAMS());
	    msg.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);

        msg.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);

	    msg.setOntology(JADEManagementOntology.getInstance().getName());
	    try {
	    	getContentManager().fillContent(msg,new Action(getAID(), new ShutdownPlatform()));
	    	send(msg);
	    }
	    catch (Exception e) {
	    e.printStackTrace();
	    }
  } 
}