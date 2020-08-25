package com.sapient.cases;

import java.io.IOException;
import java.time.LocalDate;

import com.sapient.ClassForSerialisation;
import com.sapient.ResourceLock;
import com.sapient.Scan;

public class Case9 extends Thread implements basicvariables {
	ResourceLock lock;int myvalue=9;
	ClassForSerialisation temp2=new ClassForSerialisation();
	public Case9(ResourceLock lock) {
		super();
		this.lock = lock;
	}
	@Override
	public void run()
	{
		LocalDate l;
		
		
		synchronized(lock)
		{
<<<<<<< HEAD
			while(lock.flag!=9)
=======
			while(lock.flag!=0)
>>>>>>> 94b3e95e78be5e29ec44b54d530724a6d3fda07f
			{	try 
					{
						lock.wait();
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}
			System.out.println("Enter date to get day of the date in format yyyy-mm-dd");
			Scan.scanner.nextLine();
			String st=Scan.scanner.nextLine();
			 l=LocalDate.parse(st);
<<<<<<< HEAD
				lock.flag=0;
=======
				lock.flag=1;
>>>>>>> 94b3e95e78be5e29ec44b54d530724a6d3fda07f
			lock.notifyAll();
		
		}
		temp2.n=((l.getDayOfYear())/7)+1;
		Synchronistaion_in_ouput(lock, "Week number is", temp2, myvalue);

	}
}
