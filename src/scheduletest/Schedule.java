package scheduletest;

import com.database.config.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Schedule
{

    public enum Period
    {
        A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P
    };

    public enum Day
    {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    };

    private Map<Period, SchedulePeriod> schedule;

    public Schedule()
    {

    }
    
    public void addExam(Exam exam)
    {
        DatabaseConnection connection = DatabaseConnection.open();
        connection.connect();
        
        //public boolean addExam(String courseCode, String roomNumber, String periodId, String day_of_week, Timestamp start_time, Timestamp end_time)
        connection.addExam(exam.course, exam.room, 0, exam., convertStoT(exam.startTime), convertStoT(exam.endTime));
        connection.close();

    }
    
    public static Timestamp convertStoT(String str_date) {
    try {
      DateFormat formatter;
      formatter = new SimpleDateFormat("dd/MM/yyyy");
      Date date = (Date) formatter.parse(str_date);
      java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

      return timeStampDate;
    } catch (ParseException e) {
      System.out.println("Exception :" + e);
      return null;
    }
  }
    
    public ExamMap searchForExams(Period period, Day day)
    {
        DatabaseConnection connection = DatabaseConnection.open();
        connection.connect();
        
        ExamMap listOfExams = new ExamMap();
        
        connection.getExamFor(day.name(), period.name()).forEachRemaining(r ->
        {
            try
            {
                String course = (r.getString("COURSE_CODE"));
                String room = (r.getString("ROOM_NUM"));
                String day_of_week = (r.getString("DAY_OF_WEEK"));
                String start_time = (r.getString("START_TIME"));
                String end_time = (r.getString("END_TIME"));
                
                //listOfExams.addExam(new Exam(course, room, period.name(), day_of_week, start_time, end_time));
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        });
        connection.close();
        return listOfExams;
    }
    
    public ExamMap searchForExams(Period period, Day day, int username)
    {
        DatabaseConnection connection = DatabaseConnection.open();
        connection.connect();
        
        ExamMap listOfExams = new ExamMap();
        
        connection.getExamFor(day.name(), period.name(), username).forEachRemaining(r ->
        {
            try
            {
                String course = (r.getString("COURSE_CODE"));
                String room = (r.getString("ROOM_NUM"));
                String day_of_week = (r.getString("DAY_OF_WEEK"));
                String start_time = (r.getString("START_TIME"));
                String end_time = (r.getString("END_TIME"));
                String teacher = (r.getString("TEACHER_ID"));
                
                //listOfExams.addExam(new Exam(course, room, period.name(), day_of_week, start_time, end_time));
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        });
        connection.close();
        return listOfExams;
    }

    public void removeExam(Period period, Day day, String examID)
    {

    }

    public Exam getExam(Period period, Day day, String examID)
    {
        return new Exam();
    }

    public void addExamMap(Period period, Day day, ExamMap examMap)
    {

    }

    public void removeExamMap(Period period, Day day, String examID)
    {
        schedule.get(period).removeExam(day, examID);
    }

    public ExamMap getExamMap(Period period, Day day, String examID)
    {
        return schedule.get(period).getExamMap(day);
    }

    public void removeTimeSlot(Period period)
    {
        schedule.remove(period);
    }

    public void addTimeSlot(Period period, int startHour, int startMin, int endHour, int endMin)
    {

        if (schedule.containsKey(period))
        {
            System.err.println("Slot already exists. Please delete slot or choose an unoccupied slot");
        }
        else
        {
            SchedulePeriod newPeriod = new SchedulePeriod(startHour, startMin, endHour, endMin);
            schedule.put(period, newPeriod);
        }
    }

    public void changeSlotStartTime(Period period, int numOfHours, int numOfMin)
    {
        schedule.get(period).changeStartTime(numOfHours, numOfMin);
    }

    public void changeSlotEndTime(Period period, int numOfHours, int numOfMin)
    {
        schedule.get(period).changeEndTime(numOfHours, numOfMin);
    }

}
