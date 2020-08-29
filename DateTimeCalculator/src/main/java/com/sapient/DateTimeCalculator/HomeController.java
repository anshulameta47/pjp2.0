package com.sapient.DateTimeCalculator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController 
{
	
@Autowired
DateTimeSevice dts;	

ModelAndView temp=new ModelAndView("Output.jsp");



@RequestMapping("/")
public ModelAndView home()
{
	return new ModelAndView("Home.jsp");
}

@PostMapping("/Call")
public ModelAndView call(@RequestParam int n)
{
	ModelAndView mv=new ModelAndView();
	if(n==1)
		return ShowDate();
	else if(n==2)
		return ShowTime();
	else if(n==3)
		mv.setViewName("page3.jsp");
	else if(n==4)
		mv.setViewName("page4.jsp");
	else if(n==5)
		mv.setViewName("Page5.jsp");
	else if(n==6)
		mv.setViewName("page6.jsp");
	else if(n==7)
		mv.setViewName("page7.jsp");
	else if(n==8)
		mv.setViewName("page8.jsp");
	else if(n==9)
		mv.setViewName("page9.jsp");
	else if(n==10)
		mv.setViewName("page10.jsp");
	else if(n==11)
		return  History();
		
	return mv;
}




@GetMapping("/ShowDate")
public ModelAndView ShowDate()
{
	

	temp.addObject("s",dts.showDate());
	return temp;
}


@GetMapping("/ShowTime")
public ModelAndView ShowTime()
{

	temp.addObject("s",dts.CurrentTime());
	return temp;
}

@GetMapping("/AddDaysToDate")
public ModelAndView AddDaysToDates(@RequestParam int d)
{

	temp.addObject("s",dts.AddDaysToDate(d));
	return temp;

 
	
}

@GetMapping("/AddMonthsToDate")
public ModelAndView AddMonthsToDate(@RequestParam int d)
{

	temp.addObject("s",dts.AddMonthsToDate(d));
	return temp;

	
	
}


@GetMapping("/AddYearsToDate")
public ModelAndView AddYearsToDate(@RequestParam int d)
{

	temp.addObject("s",dts.AddYearsToDate(d));
	return temp;

	 
	
}


@GetMapping("/AddWeeksToDate")
public ModelAndView AddWeeksToDate(@RequestParam int d)
{

	temp.addObject("s",dts.AddWeeksToDate(d));
	return temp;

	
	
}


@GetMapping("/Addtwodates")
public ModelAndView AddingDates(@RequestParam  String s1,@RequestParam String s2)
{

	DateFormat formatter;
	Date date1 = null,date2 = null;
	formatter = new SimpleDateFormat("dd-MM-yyyy");
	
	try {
		date1 = (Date) formatter.parse(s1);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		date2=  (Date) formatter.parse(s2);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	temp.addObject("s",dts.addtwodates(date1,date2));
	return temp;


	
}

@GetMapping("/DayOfTheDate")
public ModelAndView DayOfTheDate(@RequestParam String st)
{

	LocalDate l=LocalDate.parse(st);
	temp.addObject("s",dts.DayOfTheDate(l));
	return temp;

	 
	
}

@GetMapping("/WeekNoOfYear")
public ModelAndView WeekNoOfYear(@RequestParam String st)
{

	LocalDate l=LocalDate.parse(st);
	temp.addObject("s",dts.WeekNoOfYear(l));
	return temp;


	
}


@GetMapping("/NLP")
public ModelAndView NLP(@RequestParam String  st)
{

	temp.addObject("s",dts.NLP(st));
	return temp;


	
}

@GetMapping("/History")
public ModelAndView History()
{

	
	temp.addObject("s",dts.ReadHistory());
	return temp;

	

}

}



