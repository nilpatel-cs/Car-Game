
/**
 *
 * @author Nil
 */
public class carGame {
	public static void main(String[] args){
		car raceCar = new car(); // creates an instance of car
		final int rep = 100;
		
	
	
		//creates a thread for each method and afterwards starts said thread, sets each to reference the instance of car just made and repeat 100 times
                
		drive d = new drive(raceCar,rep);
		Thread dt = new Thread(d);
		addGas a = new addGas(raceCar,rep);
		Thread at = new Thread(a);
		getGas g = new getGas(raceCar,rep);
		Thread gt = new Thread(g);

		at.start();
		gt.start();
		dt.start();
	
		
	}
}

