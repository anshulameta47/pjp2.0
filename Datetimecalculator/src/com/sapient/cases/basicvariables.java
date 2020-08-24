package com.sapient.cases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.sapient.ClassForSerialisation;
import com.sapient.ResourceLock;

public interface basicvariables {
	LocalDate localDate =LocalDate.now();
	LocalTime localTime=LocalTime.now();
	List<ClassForSerialisation> object=new ArrayList<ClassForSerialisation>();
	 File f=new File("Myhistory.txt");

	public static void writeFile(ClassForSerialisation temp2) throws IOException
	{
	FileOutputStream fos=new FileOutputStream(f);
	ObjectOutputStream oos=new ObjectOutputStream(fos);
	
	object.add(temp2);
	System.out.println(object);
	oos.writeObject(object.get(object.size()-1));
	}
	
	public default void Synchronistaion_in_ouput(ResourceLock lock,String s,ClassForSerialisation temp2,int Thread_number) 
	{
	
		try
		{
			synchronized(lock)
			{
				while(lock.flag1!=Thread_number) 
				{
					try
					{
						lock.wait();
					} 
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				if(Thread_number==2)
					s+=temp2.p;
				else if(Thread_number==8)
					s+=temp2.dayofweek;
				else if(Thread_number==9)
				s+=temp2.n;
				
				else
					s+=temp2.l;
				System.out.println(s);
				
				
				basicvariables.writeFile(temp2);
				lock.flag1=0;
				lock.notifyAll();
			}
		} 
		catch (IOException e) 
		{
	
			e.printStackTrace();
		}
	}
	
	

	
	
}
