package humber.exam.library;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import humber.exam.database.*;
import java.sql.ResultSet;

class ExamMap 
{

    Map<String, Exam> allExams = new HashMap<String, Exam>();

    public ExamMap()
    {

    }

    public boolean addExam(Exam exam)
    {
        allExams.put(exam.toString(), exam);
        return true;
    }

    public boolean removeExam(Exam exam)
    {
        allExams.remove(exam.toString());
        return true;
    }

    public int returnTotalExams()
    {
        int totalNumber = allExams.size();
        return totalNumber;
    }

    public Map returnExamsByCourse(Course tempCourse)
    {
        Map<String, Exam> allExamsByCourse = new HashMap<String, Exam>();

        Iterator it = allExams.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry pair = (Map.Entry) it.next();
            if(((Exam) pair.getValue()).course.code.equals(tempCourse.code))
            {
                allExamsByCourse.put((String)pair.getKey(), (Exam)pair.getValue());
            }
            it.remove(); // avoids a ConcurrentModificationException
        }

        return allExamsByCourse;
    }

    public Map returnExamMap()
    {
        return allExams;
    }
    
    public ArrayList<Exam> getExamsByDay(String day) { 
        ArrayList<Exam> ae = new ArrayList();
        DatabaseConnection conn = DatabaseConnection.open();
        Result result = conn.getExamsOnDay(day);
        Exam e;
            
        while (result.hasNext()){
            ResultSet set = result.next();
            //e = new Exam(set.getString("course_code"), set.getString("local"))
                    //public Exam(Course course, LocalTime date, LocalTime starTime, LocalTime endTime, Room room)
            
            
            /*id = set.getInt("id");
            firstName = set.getString("first_name");
            lastName = set.getString("last_name");
            accessLevel = set.getInt("access_level");*/
        }
        
        
        return ae;
    }

}
