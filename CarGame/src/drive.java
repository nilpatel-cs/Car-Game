
/**
 *
 * @author Nil
 */
public class drive implements Runnable 
{
	private final car raceCar;
	private final double count;
	private final long DELAY = 1;
	

	public drive(car aRacecar, double aCount)
	{
		raceCar= aRacecar;//gets car to reference from parameter
		count = aCount;
	}
        @Override
	public void run()
		{
			try{
				for (int i = 1;i<=count;i++)
				{
					System.out.println(raceCar.drive());
					Thread.sleep(DELAY);
				}
			}
			catch(InterruptedException exception){}
		}



}