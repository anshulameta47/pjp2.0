package com.sapient.DateTimeCalculator;

	import java.time.LocalDate;
	import java.util.HashMap;

	public class LanguageTranslatorInEnglish {

		LocalDate localdate=LocalDate.now(); 
		HashMap<String, LocalDate> ma;
		
		public LanguageTranslatorInEnglish()
		{
		PhrasesInenglish p=new PhrasesInenglish();
		ma=p.createMap();
		}
		public LocalDate Translate(String s)
		{
			
			if(s.matches(".* from now"))
			{
				int d=s.charAt(0)-48;
				if(s.matches(".*Days.*"))
					return localdate.plusDays(d);
				else if(s.matches(".*Weeks.*"))
					return localdate.plusWeeks(d);
				else if(s.matches(".*Months.*"))
					return localdate.plusMonths(d);
				else if(s.matches(".*Years.*"))
					return localdate.plusYears(d);
			}
			else if(s.matches(".* earlier"))
			{
				int d=s.charAt(0)-48;
				if(s.matches(".*Days.*"))
					return localdate.minusDays(d);
				else if(s.matches(".*Weeks.*"))
					return localdate.minusWeeks(d);
				else if(s.matches(".*Months.*"))
					return localdate.minusMonths(d);
				else if(s.matches(".*Years.*"))
					return localdate.minusYears(d);
			
			}
			else
			{
			
			for(var e: ma.entrySet())
			{
				
				if(s.equals(e.getKey()))
				{
					return e.getValue();
				}
			}
			
			}
			return null;
			
		}
	}

