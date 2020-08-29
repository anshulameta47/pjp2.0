package com.sapient.DateTimeCalculator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DateTimeSevice implements BasicVariables{

	
	public String showDate() 
	{
		ClassForSerialisation temp2=new ClassForSerialisation();
		int myvalue=1;
		
		temp2.l=localDate;
		
		/* perform output and save object state to list*/
		return Synchronistaion_in_ouput("Today's date is", temp2, myvalue);
	
		
	}

	public String CurrentTime() {
		ClassForSerialisation temp2=new ClassForSerialisation();
		int myvalue=2;
		
		temp2.p=localTime;
		
		/* perform output and save object state to list*/
		return Synchronistaion_in_ouput("Current time is", temp2, myvalue);
	
		
	}

	public String AddDaysToDate(int d) 
	{
		ClassForSerialisation temp2=new ClassForSerialisation();
		int myvalue=3;
		
		temp2.l=localDate.plusDays(d);
		
		return Synchronistaion_in_ouput( "Resultant date is", temp2, myvalue);
		
	}
	
	public String AddMonthsToDate(int d) 
	{
		ClassForSerialisation temp2=new ClassForSerialisation();
		int myvalue=4;
		
		
		temp2.l=localDate.plusMonths(d);
		
		return Synchronistaion_in_ouput("Resultant date is", temp2, myvalue);
			
	}

	public String AddYearsToDate(int d) 
	{
		
		ClassForSerialisation temp2=new ClassForSerialisation();
		int myvalue=5;
		
		temp2.l=localDate.plusYears(d);
		
		return Synchronistaion_in_ouput("Resultant date is", temp2, myvalue);

		
	}

	public String AddWeeksToDate(int d) 
	{
		ClassForSerialisation temp2=new ClassForSerialisation();
		int myvalue=6;
		
		temp2.l=localDate.plusWeeks(d);
		
		return Synchronistaion_in_ouput("Resultant date is", temp2, myvalue);

	}
	
	public String addtwodates(Date date1, Date date2)
	{
		ClassForSerialisation temp2=new ClassForSerialisation();
		int myvalue=7;
		
		/* Adding two dates */
		try
		{
		Instant sumdate=new Date( date1.getTime()+ date2.getTime()).toInstant();
		ZoneId zone=ZoneId.systemDefault();
		LocalDate sum=LocalDate.ofInstant(sumdate, zone);
		temp2.l=sum;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
		
		
		return Synchronistaion_in_ouput("Resultant date is", temp2, myvalue);
		
		
	}

	public String DayOfTheDate(LocalDate l) 
	{
		
		ClassForSerialisation temp2=new ClassForSerialisation();
		int myvalue=8;
		
		temp2.dayofweek=l.getDayOfWeek();
		
		return Synchronistaion_in_ouput( "Day of the date is", temp2, myvalue);

	}


	public String WeekNoOfYear(LocalDate l)
	{
		ClassForSerialisation temp2=new ClassForSerialisation();
		int myvalue=9;
		
		
		temp2.n=((l.getDayOfYear())/7)+1;
		
		return Synchronistaion_in_ouput("Week number is", temp2, myvalue);
		
	}

	public String NLP(String st) 
	{
		LanguageTranslatorInEnglish temp3=new LanguageTranslatorInEnglish();
		ClassForSerialisation temp2=new ClassForSerialisation();
		int myvalue=10;
		
		
		temp2.l=temp3.Translate(st);
		
		
		return Synchronistaion_in_ouput("Resultant date is", temp2, myvalue);

		
	}

	public List<ClassForSerialisation> ReadHistory() 
	{
		
		List<ClassForSerialisation> list=new ArrayList<ClassForSerialisation>();
		try {
			
				WriteFile(object);
			} 
		catch (IOException e1) 
			{
			e1.printStackTrace();
				}
		
		FileInputStream fis = null;
		ObjectInputStream ois=null;
		try {
			fis = new FileInputStream(f);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try {
			ois=new ObjectInputStream(fis);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		

			
		try {
			list=(List<ClassForSerialisation>)ois.readObject();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		 
	return list;
	}

	
	


}
