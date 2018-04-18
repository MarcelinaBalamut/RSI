import jade.core.Agent;


public class HelloAgent1 extends Agent {

	int counter;
	 protected void setup() {
		  	
		  	
		  Object[] args =getArguments();
		  counter= Integer.parseInt(args[0].toString());
		  for(int i=0; i<counter; i++){
			  System.out.println("Hello World! My name is "+getLocalName() + " Argument: "+i);
		  }
		  	
		  } 

}
