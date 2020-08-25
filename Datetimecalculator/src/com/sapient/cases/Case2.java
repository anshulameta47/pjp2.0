package com.sapient.cases;

import java.io.IOException;

import com.sapient.ClassForSerialisation;
import com.sapient.ResourceLock;

public class Case2 extends Thread implements basicvariables {

		ResourceLock lock;int myvalue=2;
	 ClassForSerialisation temp2=new ClassForSerialisation();
		public Case2(ResourceLock lock)
		{
			super();
			this.lock = lock;
		}
		@Override
		public void run()
		{
			synchronized(lock)
			{
<<<<<<< HEAD
				while(lock.flag!=2) {try {
=======
				while(lock.flag!=0) {try {
>>>>>>> 94b3e95e78be5e29ec44b54d530724a6d3fda07f
					lock.wait();
				} catch (InterruptedException e) {
			
					e.printStackTrace();
				}}
<<<<<<< HEAD
			lock.flag=0;
=======
			lock.flag=1;
>>>>>>> 94b3e95e78be5e29ec44b54d530724a6d3fda07f
			lock.notifyAll();
			}
			
			temp2.p=localTime;
			Synchronistaion_in_ouput(lock, "Current time is", temp2, myvalue);

			
		}
}
