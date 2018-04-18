import jade.core.Agent;


public class HelloAgent2 extends Agent {

	int counter;
	 protected void setup() {
		 Object[] args =getArguments();
		  counter= Integer.parseInt(args[0].toString());
		  for(int i=0; i<counter; i++){
			  System.out.println("Hello World! My name is "+getLocalName() + " Argument: "+i);
		  }
		  	this.main(null);
		  
		  } 
	 public static void main(String[] args){
		 System.out.println( "Line in main function");
	 }

}
