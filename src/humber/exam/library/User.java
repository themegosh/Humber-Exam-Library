/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humber.exam.library;

import java.sql.SQLException;

/**
 *
 * @author mathe_000
 */
public class User extends Account {
    
    private String username;
    private String password;

    public User(String username, String password) {
        super(username, password);
    }
    
    public UserMap getMap(School school) throws SQLException {
        switch (school) {
        case COURSE:
            return new UserMap<Course>(school);
        case PROGRAM:
            return new UserMap<Program>(school);
        case ROOM:
            return new UserMap<Room>(school);
        //case STUDENT_GROUP:
          //  return new UserMap<StudentGroup>(school);
        default:
            return null;
        }
    }
    
    public Schedule getSchedule() {
        return new Schedule();
    }
    
}
