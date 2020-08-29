package com.sapient.DateTimeCalculator;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public interface BasicVariables {
	LocalDate localDate =LocalDate.now();
	LocalTime localTime=LocalTime.now();
	List<ClassForSerialisation> object=new ArrayList<ClassForSerialisation>();
	static File f=new File("History.txt");
	
	
	public default String Synchronistaion_in_ouput(String s,ClassForSerialisation temp2,int operation)  
	{
	
			s+=" ";
			if(operation==2)
				s+=temp2.p;
			else if(operation==8)
				s+=temp2.dayofweek;
			else if(operation==9)
			s+=temp2.n;
			else
				s+=temp2.l;
			
			
		
			object.add(temp2); /*adding result to list*/
			return s;
			
	}


	public default void WriteFile(List<ClassForSerialisation> object) throws IOException
	{
		FileOutputStream fos=new FileOutputStream(f);
		try (var oos = new ObjectOutputStream(fos)) {
			oos.writeObject(object);
		}
		
	}
}
	
	
	

	
	
