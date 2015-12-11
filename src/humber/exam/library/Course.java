/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humber.exam.library;

import humber.exam.database.DatabaseConnection;
import humber.exam.database.Result;
import java.sql.ResultSet;

/**
 *
 * @author n00024233
 */
public class Course {
    private String code, courseName, time, room;
    private int teacherId;
  
    public Course(String code, String courseName, int teacher, String time, String room) {
        this.code = code;
        this.courseName = courseName;
        this.teacherId = teacher;
        this.time = time;
        this.room = room;
    }
    
    public Course(String code){
        try {
            DatabaseConnection conn = DatabaseConnection.open();
            Result result = conn.getCourseForCourseCode(code);
            
            if (result != null && result.hasNext()) {
                ResultSet set = result.next();
                
                Result resTeacher = conn.getUserById(Integer.valueOf(set.getString("TEACHER_ID")));
                
                c = new Course(set.getString("COURSE_CODE"), set.getString("COURSE_NAME"), set.getString("COURSE_"));
                
                id = set.getInt("id");
                firstName = set.getString("first_name");
                lastName = set.getString("last_name");
                accessLevel = set.getInt("access_level");
            }
            else {
                throw new UserException("Invalid username and/or password.");
            }
            
            conn.close();
        }
        catch (Exception e){
            throw e;
        }
    }
      
    public String getCode() {
        return code;
    }

    public String getcName() {
        return cName;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }


    public boolean setTime(String time) {
        this.time = time;
        return true;
    }

 
    public boolean setCode(String code) {
        this.code = code;
        return true;
    }


    public boolean setcName(String cName) {
        this.cName = cName;
        return true;
    }

    public boolean setTeacher(String teacher) {
        this.teacher = teacher;
        return true;
    }


    public boolean setRoom(String room) {
        this.room = room;
        return true;
    }
   
   public String toString(){
       return code;
   }
  
    
}


