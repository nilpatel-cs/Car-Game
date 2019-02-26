/**
 *
 * @author Nil
 */
public class carThreadRunner 
{

	public static void main(String[] args)
	{
		car testCar = new car();
		final int threads = 100;
		
		for (int i = 1; i <= threads; i++)
		{
			drive d = new drive(testCar, threads);
			addGas ag = new addGas(testCar, threads);
			getGas gg = new getGas(testCar, threads);
			Thread td = new Thread(d);
			Thread tag = new Thread(ag);
			Thread tgg = new Thread(gg);
			
			
			td.start();
			tag.start();
			tgg.start();
			
		}
	}

}
