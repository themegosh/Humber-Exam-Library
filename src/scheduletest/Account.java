/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduletest;

import java.sql.SQLException;

/**
 *
 * @author Trevor Smart
 */

public abstract class Account {

    public UserMap getMap(School school) throws SQLException {
        switch (school) {
        case COURSE:
            return new UserMap<Course>(school);
        case PROGRAM:
            return new UserMap<Program>(school);
        case ROOM:
            return new UserMap<Room>(school);
       // case STUDENT_GROUP:
         //   return new UserMap<StudentGroup>(school);
        default:
            return null;
        }
    }
}