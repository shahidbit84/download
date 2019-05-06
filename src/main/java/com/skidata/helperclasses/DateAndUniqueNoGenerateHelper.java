package com.skidata.helperclasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import com.skidata.testBase.TestBase;

/**
 *************************************************************************************************************
 * @Project SSP - CHBACKOFFICE AND PORTAL
 * @Description
 * DateAndUniqueNoGenerateHelper class will be used to generate the date or date functions and also generate 
 * unique no which can be used in the Test cases.
 * @author mavh
 * @version 1.0
 *************************************************************************************************************
 */
public class DateAndUniqueNoGenerateHelper extends TestBase{
	
	public static final Logger log = Logger.getLogger(BrowserHelper.class.getName());

	/**
	 * Method which will accept the parameters as "day","month","year","time","minute","millisecond","AMPM"
	 *</br> user can pass any one of the parameters mentioned as string
	 * @param parameter
	 * @return
	 */
    public String get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM(String parameter) {

          String day=null;
          String month=null;
          String year=null;
          String hour=null;
          String minute=null;
          String milisecond=null;
          String AMPM=null;
          String formatter1 = get_System_date_month_year_time_am_pm();
          String Systemdateandtime = formatter1;    
         

          String[] mainUrl = Systemdateandtime.split("/");
          day = mainUrl[0];   // day
          month = mainUrl[1];   // month
          year = mainUrl[2];   // year
          hour = mainUrl[3];   // time
          minute = mainUrl[4];   // minute
          milisecond = mainUrl[5];   // milisecond
          AMPM = mainUrl[6];   // AM or PM
   

          if(parameter.equalsIgnoreCase("day")){
                return day;
          }else if(parameter.equalsIgnoreCase("month")){
                return month;
          }else if(parameter.equalsIgnoreCase("year")){
                return year;
          }else if(parameter.equalsIgnoreCase("hour")){
                return hour;
          }else if(parameter.equalsIgnoreCase("minute")){
                return minute;
          }else if(parameter.equalsIgnoreCase("milisecond")){
                return milisecond;
          }else if(parameter.equalsIgnoreCase("AMPM")){
                return AMPM;      
          }else{
                System.out.println("Please provide a valid parameter as the following day,month, year,hour,minute,milisecond,AMPM else it will return null");
                return null;
          }
  
    }
    
    
    
    
    /**
     * Pass the parameter as ("month","dd/MMMMMMMMMMM/yy/HH/mm/ss/a") -> the output will be example : February</br>
     * Pass the parameter as ("year","dd/MM/yyyy/HH/mm/ss/a") -> the output will be example : 2018</br>
     * @param parameter
     * @param format
     * @return 
     */
    public String get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM(String parameter,String format) {

        String day=null;
        String month=null;
        String year=null;
        String hour=null;
        String minute=null;
        String milisecond=null;
        String AMPM=null;
       
  
        
        String formatter1 = get_System_date_month_year_time_am_pm(format);
        String Systemdateandtime = formatter1;    

        String[] mainUrl = Systemdateandtime.split("/");
        day = mainUrl[0];   // day
        month = mainUrl[1];   // month
        year = mainUrl[2];   // year
        hour = mainUrl[3];   // time
        minute = mainUrl[4];   // minute
        milisecond = mainUrl[5];   // milisecond
        AMPM = mainUrl[6];   // AM or PM
       
        

        if(parameter.equalsIgnoreCase("day")){
              return day;
        }else if(parameter.equalsIgnoreCase("month")){
              return month;
        }else if(parameter.equalsIgnoreCase("year")){
              return year;
        }else if(parameter.equalsIgnoreCase("hour")){
              return hour;
        }else if(parameter.equalsIgnoreCase("minute")){
              return minute;
        }else if(parameter.equalsIgnoreCase("milisecond")){
              return milisecond;
        }else if(parameter.equalsIgnoreCase("AMPM")){
              return AMPM;       
        }
        
        else{
              System.out.println("Please provide a valid parameter for date");
              return null;
        }



  }
    /**
     * Retrieve any Month either previous or next from the current month by providing the integer value for previous use -1 and future use +1
     * @param formatOfMonth
     * @param _PlusOrMinusValueFromCurrentMonth
     * @return Month in the format specified as parameter
     */
    public String get_PreviousMonthNames_OrFutureMonthName_FromCurrentMonth(String formatOfMonth,int _PlusOrMinusValueFromCurrentMonth) {
    	Calendar c = new GregorianCalendar();
    	c.setTime(new Date());
    	SimpleDateFormat sdf = new SimpleDateFormat(formatOfMonth);
    	System.out.println(sdf.format(c.getTime()));   // One month ago
    	c.add(Calendar.MONTH, _PlusOrMinusValueFromCurrentMonth);
    	return sdf.format(c.getTime());
    }
    
    
    
    /**
     * Retrieve any Year either previous or next from the current Year by providing the integer value for previous use -1 and future use +1
     * @param formatOfMonth
     * @param _PlusOrMinusValueFromCurrentMonth
     * @return Year in the format specified as parameter
     */
    public String get_PreviousYear_OrFutureYear(String formatOfMonth,int _PlusOrMinusIntValueForYear) {
    	Calendar c = new GregorianCalendar();
    	c.setTime(new Date());
    	SimpleDateFormat sdf = new SimpleDateFormat(formatOfMonth);
    	c.add(Calendar.YEAR, _PlusOrMinusIntValueForYear);
    	return sdf.format(c.getTime());
    }
    
    /**
     * Retrieve any Date either previous or next from the current Date by providing the integer value for previous use -1 and future use +1
     * @param formatOfDate mm/d/yyyy
     * @param _PlusOrMinusValueFromCurrentMonth
     * @return Year in the format specified as parameter
     */
    public String get_PreviousDate_OrFutureDate(String formatOfDate,String _PlusOrMinusIntValueForDate) {
    	Calendar c = new GregorianCalendar();
    	
    	c.setTime(new Date());
    	SimpleDateFormat sdf = new SimpleDateFormat(formatOfDate);
    	c.add(Calendar.DATE, Integer.parseInt(_PlusOrMinusIntValueForDate));
    	return sdf.format(c.getTime());
    }
    
    
    

    // this method fetches System current date time year and am pm
 	public String get_System_date_month_year_time_am_pm(){
 		Date date=new Date();
 		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yy/hh/mm/ss/a");
 		return formatter.format(date);
 	}
 	
 	public String get_System_date_month_year_time_am_pm(String format){
 		Date date=new Date();
 		SimpleDateFormat formatter=new SimpleDateFormat(format);
 		return formatter.format(date);
 	}
 	
 	/**
 	* Method will generate the Unique no and return
 	* @return uniqueNumber
 	*/
 	public String generateUniqueNo(){
 	String dayInNumber =get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("day");
 	String monthInNumber =get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("month");
 	String yearInNumber =get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("year");
 	String currentHour= get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("hour");
	String currentMinute =get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("minute");
	String currentMilliSec=get_CurrentSystem_Day_Month_Year_Time_Minute_MilliSecond_AMPM("milisecond");
	String uniqueNumber = dayInNumber+monthInNumber+yearInNumber+currentHour+currentMinute+currentMilliSec;
	return uniqueNumber;
 	}

 	
 	public String convertMonthInTextToNumber(String month) {

 		switch(month) {
		
		 case "January": 
	            month = "01"; 
	            break;
		 case "February": 
	            month = "02"; 
	            break;
		 case "March": 
	            month = "03"; 
	            break;
		 case "April": 
	            month = "04"; 
	            break;
		 case "May": 
	            month = "05"; 
	            break;
		 case "June": 
	            month = "06"; 
	            break;
		 case "July": 
	            month = "07"; 
	            break;
		 case "August": 
	            month = "08"; 
	            break;
		 case "September": 
	            month = "09"; 
	            break;
		 case "October": 
	            month = "10"; 
	            break;
		 case "November": 
	            month = "11"; 
	            break;
		 case "December": 
	            month = "12"; 
	            break;
		 default: 
			 month = null; 
	   }
		return month; 
 	}
 	
}
   