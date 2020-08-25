package com.sapient.cases;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.sapient.ClassForSerialisation;
import com.sapient.ResourceLock;

public class Case11 extends Thread implements basicvariables {

	static ResourceLock lock;int myvalue=10;
	File f=new File("History.txt");
	public Case11(ResourceLock lock) {
		super();
		this.lock = lock;
	}
	@Override
	public void run() 
	{
		synchronized(lock)
		{
			while(lock.flag!=11) {try {
				lock.wait();
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}}
		lock.flag=0;
		lock.notifyAll();
		}
		
		try {
			
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}
	
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
	

