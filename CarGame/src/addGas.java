/**
 *
 * @author Nil
 */
public class addGas implements Runnable
	{
	Thread a;
	private final car raceCar;
	private final double count;
	private final long DELAY = 1;
	public addGas(car aRacecar, double aCount)

		{
		raceCar= aRacecar;
		count = aCount;
		}
		
        @Override
	public void run()
		{
			try{
				for (int i = 1;i<=count;i++)
				{

					
					System.out.println(raceCar.addGas());
					Thread.sleep(DELAY);
				}
			}
			catch(InterruptedException exception){}
		}



}