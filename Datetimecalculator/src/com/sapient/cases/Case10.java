package com.sapient.cases;

import java.io.IOException;
import java.time.LocalDate;

import com.sapient.ClassForSerialisation;
import com.sapient.LanguageTranslatorInEnglish;
import com.sapient.ResourceLock;
import com.sapient.Scan;

public class Case10 extends Thread implements basicvariables {
	ResourceLock lock;int myvalue=10;
	public Case10(ResourceLock lock) {
		super();
		this.lock = lock;
	}
	ClassForSerialisation temp2=new ClassForSerialisation();
	@Override
	public void run()
	{
		LanguageTranslatorInEnglish temp3=new LanguageTranslatorInEnglish();
		
		
		String s;
	
		synchronized(lock)
		{
			while(lock.flag!=0)
			{	try 
					{
						lock.wait();
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}
			System.out.println("Enter string to parse");
			Scan.scanner.nextLine();
			 s=Scan.scanner.nextLine();
			lock.flag=1;
			lock.notifyAll();
		
		}
		temp2.l=temp3.Translate(s);
		Synchronistaion_in_ouput(lock, "Resultant date is", temp2, myvalue);

	}
}
