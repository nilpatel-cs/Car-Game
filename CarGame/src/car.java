
/**
 *
 * @author Nil
 */
import java.util.concurrent.locks.*;
public class car
{  
   private double gasInTank= 0;
   private final Lock gasInTankLock;
   private final Condition noGas;
   private final Condition noTankRoom;

 
  public car()
   {
	  gasInTankLock= new ReentrantLock();
	  noGas = gasInTankLock.newCondition();
	  noTankRoom = gasInTankLock.newCondition();

   }
	  
   public String addGas() throws InterruptedException
   {  
	gasInTankLock.lock(); //locks gasInTank from other threads
	try
	{      //if the gas is more than 15 will wait before adding gas
		while(gasInTank>15)
		{noTankRoom.await();}
		// add gas in tank and signals that there is now gas in tank
	    gasInTank = gasInTank + 5;
		noGas.signalAll();//wakes up all waiting threads
		return "5 gallons added";
		}
	finally
	{
		gasInTankLock.unlock(); //unlocks gasInTank to other threads
	}
   }

   
   public String drive() throws InterruptedException   
   {   
	   gasInTankLock.lock();//locks gasInTank from other threads
		try
		{ 
			while(gasInTank<2)
			 {noGas.await();}//waits for gas to be added
			
		gasInTank = gasInTank - 2;
		noTankRoom.signalAll();//wakes up all waiting threads
            return "Drove 100 miles";
		}
		
		finally
		{
			gasInTankLock.unlock();//unlocks gasInTank to other threads
		}
       
   }

   
   public double getGas()
   {   gasInTankLock.lock();//locks gasInTank from other threads
	try{ 
      return gasInTank;}
	finally
	{
		gasInTankLock.unlock();//unlocks gasInTank to other threads
	}
   
   }
}

