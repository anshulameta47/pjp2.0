package com.sapient.cases;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import com.sapient.ClassForSerialisation;
import com.sapient.ResourceLock;
import com.sapient.Scan;

public class Case7 extends Thread implements basicvariables {

	ResourceLock lock;int myvalue=7;
	ClassForSerialisation temp2=new ClassForSerialisation();
	
	 public Case7 (ResourceLock lock)
	 {
		super();
		this.lock = lock;
	 }
	
	 /*to add two dates*/
	 	@Override
		public void run()
		{
	 		int d;
			synchronized(lock)
			{
				while(lock.flag!=7)
				{	try 
						{
							lock.wait();
						}
					catch (InterruptedException e)
						{
							e.printStackTrace();
						}
				}
				System.out.println("Enter two  dates to add in format dd/mm/yyyy");

				Scan.scanner.nextLine();
					
				String str1=Scan.scanner.nextLine();
				System.out.println(str1);
				String str2=Scan.scanner.nextLine();
				System.out.println(str2);
				DateFormat formatter;
				Date date1,date2;
				formatter = new SimpleDateFormat("dd/MM/yyyy");
				try
				{
				date1 = (Date) formatter.parse(str1);
				date2=  (Date) formatter.parse(str2);
				Instant sumdate=new Date( date1.getTime()+ date2.getTime()).toInstant();
				ZoneId zone=ZoneId.systemDefault();
				LocalDate sum=LocalDate.ofInstant(sumdate, zone);
				temp2.l=sum;
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				lock.flag=0;
				lock.notifyAll();
			
			}
			
			Synchronistaion_in_ouput(lock, "Resultant date is", temp2, myvalue);
			
		}

}
