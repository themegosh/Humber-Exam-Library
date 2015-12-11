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
    private String code, courseName, description;
    private int teacherId, programId;
  
    public Course(String code, String courseName, String description, int teacher, String time, String room, int programId) {
        this.code = code;
        this.courseName = courseName;
        this.description = description;
        this.teacherId = teacher;
        this.programId = programId;
    }
    
    public Course(String code) throws Exception {
        DatabaseConnection conn = DatabaseConnection.open();
        Result result = conn.getCourseForCourseCode(code);

        if (result != null && result.hasNext()) {
            ResultSet set = result.next();

            this.code = code;
            this.courseName = set.getString("NAME");
            this.description = set.getString("DESCRIPTION");
            this.teacherId = set.getInt("TEACHER_ID");
            this.programId = set.getInt("PROGRAM_ID");
        }
        else {
            throw new Exception("Error: Class Course ("+code+") could not be found in DB!");
        }
            
        conn.close();
    }
      
    public String getCode() {
        return code;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getProgramId() {
        return programId;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }
   
   public String toString(){
       return code;
   }
}


