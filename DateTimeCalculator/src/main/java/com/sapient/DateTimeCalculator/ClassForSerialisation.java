package com.sapient.DateTimeCalculator;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;



/*All the output's are converted into this format, so that serialization can be performed to save state of object in file */
@Component
public class ClassForSerialisation implements Serializable{

	public LocalDate l;
	public LocalTime p;
	public DayOfWeek dayofweek;
	public int n;
	@Override
	public String toString() {
		return "ClassForSerialisation [l=" + l + ", p=" + p + ", dayofweek=" + dayofweek + ", n=" + n + "]";
	}
	
	
}