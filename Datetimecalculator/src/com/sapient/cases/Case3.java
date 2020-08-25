package com.sapient.cases;

import java.io.IOException;

import com.sapient.ClassForSerialisation;
import com.sapient.ResourceLock;
import com.sapient.Scan;

public class Case3 extends Thread implements basicvariables {
	ResourceLock lock;int myvalue=3;
	ClassForSerialisation temp2=new ClassForSerialisation();
	
	 public Case3(ResourceLock lock)
	 {
		super();
		this.lock = lock;
	 }
	
	 
	 	@Override
		public void run()
		{
	 		int d;
			synchronized(lock)
			{
<<<<<<< HEAD
				while(lock.flag!=3)
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
				System.out.println("Enter no. of days to add in date");
				d=Scan.scanner.nextInt();
<<<<<<< HEAD
				lock.flag=0;
=======
				lock.flag=1;
>>>>>>> 94b3e95e78be5e29ec44b54d530724a6d3fda07f
				lock.notifyAll();
			
			}
			temp2.l=localDate.plusDays(d);
			
			Synchronistaion_in_ouput(lock, "Resultant date is", temp2, myvalue);
			
		}

}
