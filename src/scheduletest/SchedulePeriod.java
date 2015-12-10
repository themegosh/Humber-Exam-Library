
package scheduletest;

import java.util.HashMap;
import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import scheduletest.Schedule.Day;

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
    
    public void addExam(Day day, Exam exam) {
        
    }
    
    public void removeExam(Day day, String examID) {
        
    }
    
    public Exam getExam(Day day, String examID) {
        return new Exam();
    }
    
    public void addExamMap(Day day, ExamMap examList) {
        
    }
    
    public void removeExamMap(Day day) {
        
    }
    
    public ExamMap getExamMap(Day day) {
        return subSlots.get(day);
    }
    
    public String getStartTime() {
        
        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        String startTime = formatter.print(this.startTime);
        return startTime;
    
    }
    
    public String getEndTime() {
        
        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        String endTime = formatter.print(this.endTime);
        return endTime;
        
    }
    
    public void changeStartTime(int numOfHours, int numOfMin) {
       
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
    
    public void changeEndTime(int numOfHours, int numOfMin) {
        
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
