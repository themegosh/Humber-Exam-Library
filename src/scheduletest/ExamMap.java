package scheduletest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

}
