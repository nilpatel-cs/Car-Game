
/**
 *
 * @author Nil
 */
public class getGas implements Runnable
	{

	private final car raceCar;
	private final double count;
	private final long DELAY = 1;
	public getGas(car aRacecar, double aCount) 
		{
		raceCar= aRacecar;//gets car to reference from parameters
		count = aCount;
	}
        @Override
	public void run()
		{
			try{
				for (int i = 1;i<=count;i++)
				{
					System.out.println(raceCar.getGas());
					Thread.sleep(DELAY);
				}
			}
			catch(InterruptedException exception){}
		}



}