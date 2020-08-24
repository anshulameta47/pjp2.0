package com.sapient.cases;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.sapient.ClassForSerialisation;
import com.sapient.ResourceLock;

public class Case11 extends Thread implements basicvariables {

	static ResourceLock lock;int myvalue=10;
	public Case11(ResourceLock lock) {
		super();
		this.lock = lock;
	}
	@Override
	public void run() 
	{
		synchronized(lock)
		{
			while(lock.flag!=0) {try {
				lock.wait();
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}}
		lock.flag=1;
		lock.notifyAll();
		}
		
		try {
			ReadFile(f,object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}
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
