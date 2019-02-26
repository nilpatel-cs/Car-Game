
/**
 *
 * @author Nil
 */
public class carGame {
	public static void main(String[] args){
		car raceCar = new car();
		final int rep = 100;
		
	for (int i=1; i<=100;i++)
	{
		
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
}

