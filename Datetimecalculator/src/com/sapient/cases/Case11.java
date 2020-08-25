package com.sapient.cases;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
<<<<<<< HEAD
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
=======
import java.io.IOException;
import java.io.ObjectInputStream;
>>>>>>> 94b3e95e78be5e29ec44b54d530724a6d3fda07f
import java.util.List;

import com.sapient.ClassForSerialisation;
import com.sapient.ResourceLock;

public class Case11 extends Thread implements basicvariables {

	static ResourceLock lock;int myvalue=10;
<<<<<<< HEAD
	File f=new File("History.txt");
=======
>>>>>>> 94b3e95e78be5e29ec44b54d530724a6d3fda07f
	public Case11(ResourceLock lock) {
		super();
		this.lock = lock;
	}
	@Override
	public void run() 
	{
		synchronized(lock)
		{
<<<<<<< HEAD
			while(lock.flag!=11) {try {
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
		
		try {
<<<<<<< HEAD
			
			synchronized(lock)
			{
				while(lock.flag1!=11)
				{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Reading history of calculations from my Array list");
			for(var temp=object.size()-1;temp>=0&& temp>=object.size()-101;temp--)
			{
				System.out.println(object.get(temp));
			}
			ReadwriteFile(f,object);
			lock.flag1=0;
			lock.notifyAll();
			}
			
=======
			ReadFile(f,object);
>>>>>>> 94b3e95e78be5e29ec44b54d530724a6d3fda07f
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}
<<<<<<< HEAD
	
	public void ReadwriteFile(File f,List<ClassForSerialisation> object) throws IOException, ClassNotFoundException
	{
		System.out.println("Writing history to history.txt file");

		FileOutputStream fos=new FileOutputStream(f);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(object);
		
		System.out.println("Reading history from history.txt file");
		FileInputStream fis=new FileInputStream(f);
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		List<ClassForSerialisation> object1=(List<ClassForSerialisation>)ois.readObject();
		System.out.println(object1);
	}
		
	
	
	
	}
	

=======
	private static void ReadFile(File f,List<ClassForSerialisation> mylist) throws IOException, ClassNotFoundException, EOFException
	{
		FileInputStream fis=new FileInputStream(f);
		ObjectInputStream ois=new ObjectInputStream(fis);
		synchronized(lock)
		{
			while(lock.flag1!=11)
			{
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		for(int i=mylist.size()-1;i>=mylist.size()-101 &&i>=0 ;i--)
		{
			System.out.println("fasafsaf");
			ClassForSerialisation temp=(ClassForSerialisation) ois.readObject();
			System.out.println(temp);
		}
		lock.flag1=0;
		lock.notifyAll();
		}
		
		
	}
	
}
>>>>>>> 94b3e95e78be5e29ec44b54d530724a6d3fda07f
