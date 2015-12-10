/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduletest;

/**
 *
 * @author n00024233
 */
class Course {
  String code, cName, teacher, time, room;

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


