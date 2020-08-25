package com.sapient;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

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
