package com.sapient;

import java.time.LocalDate;
import java.util.HashMap;

public class PhrasesInenglish {
	LocalDate localdate=LocalDate.now();

	HashMap<String, LocalDate> ma = new HashMap<>(); 

	public HashMap<String, LocalDate> createMap()
	 {
		 ma.put("Today",localdate);
		 ma.put("Tomorrow", localdate.plusDays(1)) ;
		 ma.put("Day-after-tomorrow", localdate.plusDays(2));
		 ma.put("Yesterday",localdate.minusDays(1));
		 ma.put("Day-before-yesterday",localdate.minusDays(2));
		 ma.put("Last-week",localdate.minusWeeks(1));
		 ma.put("Next-week",localdate.plusWeeks(1));
		 ma.put("Next-month",localdate.plusMonths(1));
		 ma.put("Last-month",localdate.minusMonths(1));
		 ma.put("Last-year",localdate.minusYears(1));
		 ma.put("Next-year",localdate.plusYears(1));
		
		 return ma;
	 }

	
}
