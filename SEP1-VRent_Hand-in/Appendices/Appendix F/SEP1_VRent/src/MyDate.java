
import java.io.Serializable;
import java.util.GregorianCalendar;

public class MyDate implements Serializable
{

   
   
   private int startDay;
   private int endDay;
   private int startMonth;
   private int endMonth;
   private int startYear;
   private int endYear;
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   
   /**
    * Constructor that sets all veriable values to match the ones provided as parameters 
    * @param startDay
    * @param endDay
    * @param startMonth
    * @param endMonth
    * @param startYear
    * @param endYear
    */
   public MyDate( int startDay, int endDay, int startMonth, int endMonth, int startYear, int endYear)
   {
      this.startDay = startDay;
      this.endDay = endDay;
      this.startMonth = startMonth;
      this.endMonth = endMonth;
      this.startYear = startYear;
      this.endYear = endYear;
   }
   
      /**
    * // This constructor is only made so we can implement the NOW method ( aka current day setter method )

    * @param startDay
    * @param startMonth
    * @param startYear
    */
   public MyDate(int startDay, int startMonth,int startYear)
   {
      this.startDay = startDay;
      this.startMonth = startMonth;
      this.startYear = startYear;
   }
   
  
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   
   /**
    * // Standard isBeofre method, similar to one used during classes
   // It is tailored to suit our needs, see start - end node diagrams / sketches for more details
    * @param date that is supposed to be checked
    * @return true or false value
    */
   public boolean isBefore(MyDate date)
   {
      if (endDay == date.startDay && endMonth == date.startMonth && endYear == date.startYear)
      {
         // We could be more precise, but implementing the hours also seems like a bit of a drag
         return false;
      }
      else if (endYear == date.startYear)
      {
         if ( endMonth == date.startMonth)
         {
            if ( endDay < date.startDay)
            {
               return true;
            }
            else return false;
         }
         else
         {
            if ( endMonth < date.startMonth)
            {
               return true;
            }
            else return false;
         }
      }
      else
      {
         if ( endYear < date.startYear)
         {
            return true;
         }
         else return false;
      }
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   
   /**
    * // Same thing as isBefore, just for checking if the certain date is after, suited for out problem ofc
   // Anyhow I think its self-explanatory, there should be a diagram somewhere explaining graphically the position of end and start nodes
    * @param date that is compared 
    * @return true or false value, depending if the date is after or not
    */
   public boolean isAfter(MyDate date)
   {
      if ( startDay == date.endDay && startMonth == date.endMonth && startYear == date.endYear)
      {
         return false;
      }
      else if (startYear == date.endYear)
      {
         if ( startMonth == date.endMonth )
         {
            if ( startDay > date.endDay)
            {
               return true;
            }
            else return false;
         }
         else
         {
            if ( startMonth > date.endMonth)
            {
               return true;
            }
            else return false;
         }
      }
      else
      {
         if (startYear > date.endYear)
         {
            return true;
         }
         else return false;
      }
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   

   /**
    *    // This method calculates the number of days in the given interval ( used for price calculation )
   // In other words it calculates the number of days from the start date to the end date [ up to 1 day error margin in a specific case ]
   // If the reserved period goes into the next year, and lasts until after the whole February, there is a possibility that price wont be calculated properly ( because of days in February )
    * @return number of days in interval
    */
   
   public int daysInInterval()
   {
      if(startYear == endYear && startMonth == endMonth)
      {
         return endDay - startDay;
      }
      else if(startYear == endYear && startMonth != endMonth)
      {
         int tempMonth = startMonth + 1;
         int returnValue = daysTilMonthEnd(startMonth, startDay);
         for (int i = tempMonth; i < endMonth ; i++)
         {
            returnValue += daysTilMonthEnd(i, 1);
            
         }
         returnValue += endDay;
         
         return returnValue;
      }
      else
      {
         int returnValue = daysTilMonthEnd(startMonth, startDay);
         for (int i = startMonth + 1; i != endMonth ; i++)
         {
            if ( i >= 12)
            {
               i = 1;
            }
            returnValue += daysInMonth(i);
         }
         returnValue += endDay;
         
         return returnValue;
      }
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   
  
   /**
    *  // Returns the number of days in the given month 
    * @param month representing which month it is
    * @return number of days in the given month 
    */
   public int daysInMonth(int month)
   {
      if ( month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )
      {
         return 31;
      }
      else if ( month == 4 || month == 6 || month == 9 || month == 11 )
      {
         return 30;
         
      }
      else 
      {
         if ( startYear % 4 == 0  )
         {
            if ( startYear % 100 != 0)
            {
               return 29;
            }
            else
            {
               if ( startYear % 400 == 0)
               {
                  return 29;
               }
               else
               {
                  return 28;
               }
            }
         }
         else
         {
            return 28;
         } 
      }
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   

   
   /**
    *    // Calculates how many days are left until the end of the month ( in the given month from the starting date )
    * @param month
    * @param day
    * @return
    */
   public int daysTilMonthEnd(int month, int day)
   {
      return daysInMonth(month) - day;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // Standard equals method [ check if 2 objects are the same ]
   
   public boolean equals(Object obj)
   {
      if ( obj instanceof MyDate)
      {
         MyDate date = (MyDate)obj;
         
         if (startDay == date.startDay && startMonth == date.startMonth && startYear == date.startYear &&
               endDay == date.endDay && endMonth == date.endMonth && endYear == date.endYear)
         {
            return true;
         }
         else return false;
      }
      else return false;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
  
   /**
    * // This method sets the start day to the current system date 
    * @return
    */
   
   public MyDate nowSet()
   {
      GregorianCalendar currentDate = new GregorianCalendar();
      int currentDay = currentDate.get(GregorianCalendar.DATE);
      int currentMonth = currentDate.get(GregorianCalendar.MONTH)+1;
      int currentYear = currentDate.get(GregorianCalendar.YEAR);
       
       
       return new MyDate(currentDay,currentMonth,currentYear);
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // Setter methods ( again, these are meant to be used with nowSet method )
   
   public void setEndDay(int endDay)
   {
      this.endDay = endDay;
   }
   
   public void setEndMonth(int endMonth)
   {
      this.endMonth = endMonth;
   }
   
   public void setEndYear(int endYear)
   {
      this.endYear = endYear;
   }
   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // toString method used to print out the information of the object of MyDate class
   
  /* public String toString()
   {
      return  startDay + " " + endDay + " " + startMonth + " " + endMonth + " " + startYear + " " + endYear;
   }
   */
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
   
   // Printing out methods used to display selected time in the box when making date selection
   
   public String nowStartDateToString()
   {
      return  startDay + "/" + startMonth + "/" + startYear+"\n";
   }
   
   public String nowEndDateToString()
   {
      return  endDay + "/" + endMonth + "/" + endYear+"\n";
   }
   

   
   // - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *
}
