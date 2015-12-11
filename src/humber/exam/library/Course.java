/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humber.exam.library;

/**
 *
 * @author n00024233
 */
public class Course {
  String code, cName, teacher, time, room;

   public Course(){
       this.code = "";
       this.cName = "";
       this.teacher = "";
       this.time = "";
       this.room = "";
   }
  
    public Course(String code, String cName, String teacher, String time, String room) {
        this.code = code;
        this.cName = cName;
        this.teacher = teacher;
        this.time = time;
        this.room = room;
    }
    
    public Course(){
        this.code = "";
        this.cName = "";
        this.teacher = "";
        this.time = "";
        this.room = "";
    }
    
    public static Course getCourseById(){
        Course c = new Course();
        
        
        
        return c;
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


