package model;

public class Date{
	
        // Atributos //
        public static int MAX_DAY = 30;
        public static int MAX_MONTH = 12;
        private int day ;
        private int month;
        private int year;
        
        public static Date currentDate = new Date(00, 00, 0000);
        
        // Metodos //
        public Date(int d, int m, int y){
		day = d;
		month = m;
		year = y;
	}
        
        public int getDay(){
		return day;
	}
        public int getMonth(){
		return month;
	}
        public int getYear(){
		return year;
	}
	
        public void setDay(int newDay){
		day = newDay;
	}
        public void setMonth(int newMonth){
		month = newMonth;
	}
        public void setYear(int newYear){
		year = newYear;
	}
} 