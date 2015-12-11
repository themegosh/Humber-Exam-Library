
package humber.exam.library;

import org.joda.time.LocalTime;
import java.sql.Timestamp;
import humber.exam.database.*;
import java.sql.ResultSet;

public class Exam {
    String courseCode;
    String roomId;
    LocalTime startTime;
    LocalTime endTime;
    int teacherId;
    
    public Exam(String courseCode, String roomId, String startTime, String endTime, int teacherId)throws Exception {
        this.courseCode = courseCode;
        this.roomId = roomId;
        this.startTime = new LocalTime(Timestamp.valueOf(startTime).getNanos());;
        this.endTime = new LocalTime(Timestamp.valueOf(endTime).getNanos());;
        this.teacherId = teacherId;
        if (courseCode.isEmpty() || roomId.isEmpty()|| startTime.isEmpty()|| endTime.isEmpty()|| roomId.isEmpty())
            throw new UserException("Username and/or password cannot be empty!");
        //save();
    }
    public Exam(String courseCode) throws Exception{
        DatabaseConnection conn = DatabaseConnection.open();
        Result result = conn.getExamForCourseCode(courseCode);

        if (result != null && result.hasNext()) {
            ResultSet set = result.next();
            this.courseCode = courseCode;
            this.roomId = set.getString("ROOM_NUM");
            this.startTime = new LocalTime(Timestamp.valueOf(set.getString("START_TIME")).getNanos());// why are we even using LocalTime?
            this.endTime = new LocalTime(Timestamp.valueOf(set.getString("END_TIME")).getNanos());
            this.teacherId = set.getInt("TEACHER_ID");
        }
        else {
            throw new Exception("Error: Class Exam ("+courseCode+") could not be found in DB!");
        }  
        conn.close();
    }
    private void save() {
        DatabaseConnection conn = DatabaseConnection.open();
        conn.addExam(courseCode, null, null, null, null);
        conn.close();
    }    
    public void setCourse(String courseCode) {
        this.courseCode = courseCode;
    }
    public void setStartTime(LocalTime time) {
        this.startTime = time;
    }
    public void setEndTime(LocalTime time) {
        this.endTime = time;
    }
    public void setRoom(String roomId) {
        this.roomId = roomId;
    }
    public void setTeacherId(int teacherId){
        this.teacherId = teacherId;
    }
    public String getCourseCode(){
        return courseCode;
    }
    public LocalTime getStartTime(){
        return startTime;
    }
    public LocalTime getEndTime(){
        return endTime;
    }
    public String getRoomId(){
        return roomId;
    }
    public int getTeacherId(){
        return teacherId;
    }
    public String toString() {
        return courseCode;
    }
}
