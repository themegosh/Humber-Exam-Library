
package humber.exam.library;

import java.util.HashMap;
import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import humber.exam.library.Schedule.Day;

public class SchedulePeriod {
    
    private LocalTime startTime, endTime;
    private Map<Day, ExamMap> subSlots;
    
    protected SchedulePeriod(int startHour, int startMin, int endHour, int endMin) {
        
        this.startTime = new LocalTime(startHour, startMin);
        this.endTime = new LocalTime(endHour, endMin);
              
        this.subSlots = new HashMap<Day, ExamMap>();
        for (Day day : Day.values()) {
            this.subSlots.put(day, new ExamMap());
        }
        
    }
    
    protected void addExam(Day day, Exam exam) {
        
    }
    
    protected void removeExam(Day day, String examID) {
        
    }
    
    protected Exam getExam(Day day, String examID) {
        return new Exam();
    }
    
    protected void addExamMap(Day day, ExamMap examList) {
        
    }
    
    protected void removeExamMap(Day day) {
        
    }
    
    protected ExamMap getExamMap(Day day) {
        return subSlots.get(day);
    }
    
    protected String getStartTime() {
        
        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        String startTime = formatter.print(this.startTime);
        return startTime;
    
    }
    
    protected String getEndTime() {
        
        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        String endTime = formatter.print(this.endTime);
        return endTime;
        
    }
    
    protected void changeStartTime(int numOfHours, int numOfMin) {
       
        if (numOfHours < 0 && numOfMin < 0) {
            int hoursToSubtract = numOfHours * -1;
            startTime = startTime.minusHours(hoursToSubtract);
            int minToSubtract = numOfMin * -1;
            startTime = startTime.minusHours(minToSubtract);
        }
        else if (numOfHours < 0 && numOfMin >= 0) {
            int hoursToSubtract = numOfHours * -1;
            startTime = startTime.minusHours(hoursToSubtract);
            int minToAdd = numOfMin;
            startTime = startTime.plusMinutes(minToAdd);
        }
        else if (numOfHours >= 0 && numOfMin < 0) {
            int hoursToAdd = numOfHours;
            startTime = startTime.plusHours(hoursToAdd);
            int minToSubtract = numOfMin * -1;
            startTime = startTime.minusMinutes(minToSubtract);
        }
        else {
            startTime = startTime.plusHours(numOfHours);
            startTime = startTime.plusMinutes(numOfMin);
        }
        
    }
    
    protected void changeEndTime(int numOfHours, int numOfMin) {
        
        if (numOfHours < 0 && numOfMin < 0) {
            int hoursToSubtract = numOfHours * -1;
            endTime = endTime.minusHours(hoursToSubtract);
            int minToSubtract = numOfMin * -1;
            endTime = endTime.minusHours(minToSubtract);
        }
        else if (numOfHours < 0 && numOfMin >= 0) {
            int hoursToSubtract = numOfHours * -1;
            endTime = endTime.minusHours(hoursToSubtract);
            int minToAdd = numOfMin;
            endTime = endTime.plusMinutes(minToAdd);
        }
        else if (numOfHours >= 0 && numOfMin < 0) {
            int hoursToAdd = numOfHours;
            endTime = endTime.plusHours(hoursToAdd);
            int minToSubtract = numOfMin * -1;
            endTime = endTime.minusMinutes(minToSubtract);
        }
        else {
            endTime = endTime.plusHours(numOfHours);
            endTime = endTime.plusMinutes(numOfMin);
        }
    }
    
    
}
