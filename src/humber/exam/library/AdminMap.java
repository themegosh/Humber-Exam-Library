package humber.exam.library;

import java.sql.SQLException;

/**
*
* @author Trevor Smart
*/

public class AdminMap<T> extends UserMap<T> {
    
    public AdminMap(School school) throws SQLException {
        super(school);
    }
    
    public void add(School school) throws KeyConflictException {
        //add to hashmap
        //insert into database
        switch (school) {
        case COURSE:
            dbconn.addCourse("CPAN-205-0NB", "Computer Programming", "description", "Exam", "J140", "CPAN-205-0NB", 7458);
            Course course = new Course();
           // map.put(course.getCourseID(), (T)course.getMap());
            break;
        case PROGRAM:
            dbconn.addProgram("CPAN-205-0NB", "CPAN");
            break;
        case ROOM:
            dbconn.addRoom("J140", "Lab", "J Building");
            break;
        case STUDENT_GROUP:
            dbconn.addStudent("Trevor", "Smart", 2345);
            break;
        default:
            break;
        }
    }
    
    public void remove(T type) {
        if (type.equals(Course.class)) {
            Course course = (Course)type;
            map.remove(course.cName);
        } else if (type.equals(Program.class)) {
            Program program = (Program)type;
            map.remove(program.programCode);
        } else if (type.equals(Room.class)) {
            Room room = (Room)type;
            map.remove(room.getClass().getName());
        } /*else if (type.equals(StudentGroup.class)) {
            StudentGroup sg = (StudentGroup)type;
            map.remove(sg.getClass().getName());
        }*/       
    }
}
