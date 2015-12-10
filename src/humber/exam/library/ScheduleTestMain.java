package humber.exam.library;

import humber.exam.database.DatabaseConfiguration;
import humber.exam.database.DatabaseConnection;
import humber.exam.library.Schedule.Day;
import humber.exam.library.Schedule.Period;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ScheduleTestMain {
	
    public static void main(String[] args) throws SQLException {
    	
        User user = new User("", "");
        Schedule schedule = user.getSchedule();
        ExamMap exams = schedule.getExams(Period.A, Day.MONDAY);
        UserMap<Course> userMapCourses = user.getMap(School.COURSE);
        Course course = userMapCourses.get("");
        ExamMap exams2 = schedule.getExams(Period.A, Day.MONDAY, course);
        
        Administrator admin = new Administrator("", "");
        AdminSchedule adminSchedule = admin.getAdminSchedule();
        AdminMap<Room> adminMapRooms = admin.getAdminMap(School.ROOM);
        Room room = adminMapRooms.get("");
        ExamMap exams3 = adminSchedule.getExams(Period.A, Day.MONDAY, room);
        
        
        
        
    }   
}
