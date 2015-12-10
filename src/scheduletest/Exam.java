
package scheduletest;

import org.joda.time.LocalTime;

class Exam
{
    Course course;
    LocalTime date;
    LocalTime startTime;
    LocalTime endTime;
    Room room;
    int ID;
    static int examIdentifier = 1923840;

    public Exam() {
    }
    
    public Exam(Course course, LocalTime date, LocalTime starTime, LocalTime endTime, Room room)
    {
        ID = examIdentifier++;
        this.course = course;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
    }
    public boolean setCourse(Course course)
    {
        this.course = course;
        return true;
    }
    public boolean setDate(LocalTime time)
    {
        this.date = time;
        return true;
    }
    public boolean setStartTime(LocalTime time)
    {
        this.startTime = time;
        return true;
    }
    public boolean setEndTime(LocalTime time)
    {
        this.endTime = time;
        return true;
    }
    public boolean setRoom(Room room)
    {
        this.room = room;
        return true;
    }
    public String toString()
    {
        return ID+"";
    }
}
