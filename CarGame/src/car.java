
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
	gasInTankLock.lock();
	try
	{
		while(gasInTank>15)
		{noTankRoom.await();}
		
	    gasInTank = gasInTank + 5;
		noGas.signalAll();
		return "5 gallons added";
		
		
		}
	finally
	{
		gasInTankLock.unlock();
	}
   }

   
   public String drive() throws InterruptedException   
   {   
	   gasInTankLock.lock();
		try
		{ 
			while(gasInTank<2)
			 {noGas.await();}
			
		gasInTank = gasInTank - 2;
		noTankRoom.signalAll();
      	return "Drove 100 miles";
		}
		
		finally
		{
			gasInTankLock.unlock();
		}
       
   }

   
   public double getGas()
   {   gasInTankLock.lock();
	try{ 
      return gasInTank;}
	finally
	{
		gasInTankLock.unlock();
	}
   
   }
}

