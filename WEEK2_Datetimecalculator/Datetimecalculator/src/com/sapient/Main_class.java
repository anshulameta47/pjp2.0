package com.sapient;

import java.io.IOException;
import com.sapient.cases.Case1;
import com.sapient.cases.Case10;
import com.sapient.cases.Case11;
import com.sapient.cases.Case2;
import com.sapient.cases.Case3;
import com.sapient.cases.Case4;
import com.sapient.cases.Case5;
import com.sapient.cases.Case6;
import com.sapient.cases.Case7;
import com.sapient.cases.Case8;
import com.sapient.cases.Case9;



public class Main_class {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		
		ResourceLock lock = new ResourceLock();
		
		
		int n=-1;
		System.out.println("Enter 1 to show today's date");
		System.out.println("Enter 2 to show current time");
		System.out.println("Enter 3 to add days in today's date");
		System.out.println("Enter 4 to add months in Today's Date");
		System.out.println("Enter 5 to add years in Today's Date");
		System.out.println("Enter 6 to add weeks in Today's Date");
		System.out.println("Enter 7 to add two dates" );
		System.out.println("Enter 8 to get day of week for any date");
		System.out.println("Enter 9 to get week number of any Date");
		System.out.println("Enter 10 for Natural Language Processing");
		System.out.println("Enter 11 to get history of operations");
		
		
		
		
		
		
		do
		{
		/*Synchronising Input with All Cases*/
			synchronized (lock)
			{
				/*flag for input's lock and flag1 for output's lock*/
				
				while((lock.flag!=0 || lock.flag1!=0) && n!=0)
					{lock.wait();}
				
				System.out.println("Enter operation number");
				n=Scan.scanner.nextInt();
			
				if(n==0)
					break;
				
				lock.flag=n;            /* Transfering flag lock to case no. n*/
				lock.flag1=n;           /* Transfering flag1 lock to case no n*/
				lock.notifyAll();
			
			}
		 
			
		switch (n) {
		case 0:
		{
			System.exit(0);
			break;
		}
		
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
		
		case 7:
		{
			Case7 case7=new Case7(lock);
			case7.start();
	
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
