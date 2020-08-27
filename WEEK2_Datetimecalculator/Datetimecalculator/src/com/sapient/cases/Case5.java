package com.sapient.cases;

import java.io.IOException;

import com.sapient.ClassForSerialisation;
import com.sapient.ResourceLock;
import com.sapient.Scan;

public class Case5 extends Thread implements basicvariables {

	ResourceLock lock;
	int myvalue=5;
	
	public Case5(ResourceLock lock) 
	{
		super();
		this.lock = lock;
	}
	/*To add n years to today's date*/
	@Override
	public void run()
	{
		int d;
		ClassForSerialisation temp2=new ClassForSerialisation();
		
		synchronized(lock)
		{
			while(lock.flag!=5)
			{	try 
					{
						lock.wait();
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}
			System.out.println("Enter no. of Years to add in today's date");
			
			d=Scan.scanner.nextInt();
			lock.flag=0;
			lock.notifyAll();
		
		}
		temp2.l=localDate.plusYears(d);
		
		Synchronistaion_in_ouput(lock, "Resultant date is", temp2, myvalue);

	}	
}
