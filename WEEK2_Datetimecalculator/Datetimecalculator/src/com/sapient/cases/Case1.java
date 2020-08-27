package com.sapient.cases;

import java.io.IOException;

import com.sapient.ClassForSerialisation;
import com.sapient.ResourceLock;

public class Case1 extends Thread implements basicvariables  {
	ResourceLock lock;
	int myvalue=1;

	
	public Case1(ResourceLock lock) {
		super();
		this.lock = lock;
	}
	
	/*To show today's date*/
	@Override
	public void run()
	{
		
		ClassForSerialisation temp2=new ClassForSerialisation();
			
		synchronized(lock)
		{
			while(lock.flag!=1) {try {
				lock.wait();
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}}
			lock.flag=0;
			lock.notifyAll();
		}
	
		temp2.l=localDate;
		
		/* perform output and save object state to list*/
		Synchronistaion_in_ouput(lock, "Today's date is", temp2, myvalue);

		
	}


}
