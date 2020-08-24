package com.sapient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

import com.sapient.cases.Case1;
import com.sapient.cases.Case10;
import com.sapient.cases.Case11;
import com.sapient.cases.Case2;
import com.sapient.cases.Case3;
import com.sapient.cases.Case4;
import com.sapient.cases.Case5;
import com.sapient.cases.Case6;
import com.sapient.cases.Case8;
import com.sapient.cases.Case9;

import java.util.List;



public class Main_class {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		
		ResourceLock lock = new ResourceLock();
		lock.flag=1;
		lock.flag1=0;
		LocalDate localDate= LocalDate.of(2010,Month.JANUARY,14);
		LocalTime localTime= LocalTime.now();
		
		int n=-1;
		do
		{
		synchronized (lock) {
			while(lock.flag!=1 || lock.flag1!=0)
				{lock.wait();}
			System.out.println("Enter blah blah blah");

			n=Scan.scanner.nextInt();
		lock.flag=0;
		lock.flag1=n;
		lock.notifyAll();
		}
		 
			
		ClassForSerialisation temp2=new ClassForSerialisation();
		switch (n) {
		case 1:
				{
					Case1 case1=new Case1(lock);
					case1.start();
					break;
				}
		case 2:
		{
			Case2 case2=new Case2(lock);
			case2.start();
	
			break;
		}
		case 3:
		{
			Case3 case3=new Case3(lock);
			case3.start();
	
			break;
		}
		
		case 4:
		{
			Case4 case4=new Case4(lock);
			case4.start();
	
			break;
		}
		case 5:
		{
			Case5 case5=new Case5(lock);
			case5.start();
	
			break;
		}
		case 6:
		{
			Case6 case6=new Case6(lock);
			case6.start();
	
			break;
		}
		
		case 8:
		{
			Case8 case8=new Case8(lock);
			case8.start();
	
			break;
		}
		case 9:
		{
			Case9 case9=new Case9(lock);
			case9.start();
	
			break;
		}
		case 10:
		{
			Case10 case10=new Case10(lock);
			case10.start();
			break;
		}
		case 11:
		{
			Case11 case11=new Case11(lock);
			case11.start();
			break;
		}
		
		
		}
	
		}
		while(n!=0);
	
	}
	
		
	
	

}
