/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduletest;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author n00024233
 */
public class CourseMap {
        Map<String, Course> allCourses = new HashMap<String, Course>();

    public Map<String, Course> returnCourseMap() {
        return allCourses;
    }
        
    private boolean addCourse, removeCourse;

    public boolean isAddCourse() {
        return addCourse;
    }

    public void setAddCourse(boolean addCourse) {
        this.addCourse = addCourse;
    }

    public boolean isRemoveCourse() {
        return removeCourse;
    }

    public void setRemoveCourse(boolean removeCourse) {
        this.removeCourse = removeCourse;
    }
    
}
