package com.sapient.cases;

import java.io.IOException;
import java.time.LocalDate;

import com.sapient.ClassForSerialisation;
import com.sapient.ResourceLock;
import com.sapient.Scan;

public class Case8 extends Thread implements basicvariables {
	ResourceLock lock;int myvalue=8;
	public Case8(ResourceLock lock)
	{
		super();
		this.lock = lock;
	}
	ClassForSerialisation temp2=new ClassForSerialisation();
	@Override
	public void run()
	{
		LocalDate l;
		
		
		synchronized(lock)
		{
			while(lock.flag!=8)
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
				lock.flag=0;
			lock.notifyAll();
		
		}
		
		
		
		
		
		temp2.dayofweek=l.getDayOfWeek();
		Synchronistaion_in_ouput(lock, "Day of the date is", temp2, myvalue);

	}
}
