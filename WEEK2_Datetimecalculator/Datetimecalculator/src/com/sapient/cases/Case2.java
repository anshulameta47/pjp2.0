package com.sapient.cases;

import java.io.IOException;

import com.sapient.ClassForSerialisation;
import com.sapient.ResourceLock;

public class Case2 extends Thread implements basicvariables {

		ResourceLock lock;
		int myvalue=2;
		
		public Case2(ResourceLock lock)
		{
			super();
			this.lock = lock;
		}
		
		/*To show current time*/
		@Override
		public void run()
		{
			ClassForSerialisation temp2=new ClassForSerialisation();
			
			synchronized(lock)
			{
				while(lock.flag!=2) {try {
					lock.wait();
				} catch (InterruptedException e) {
			
					e.printStackTrace();
				}}
				lock.flag=0;
				lock.notifyAll();
			}
			
			temp2.p=localTime;
			
			Synchronistaion_in_ouput(lock, "Current time is", temp2, myvalue);

			
		}
}
