/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humber.exam.library;

import humber.exam.database.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author n00024233
 */
public class Administrator extends User {

    public Administrator(String username, String password) throws Exception {
        super(username, password);
    }
    
    public AdminMap getAdminMap(School school) throws SQLException{
        switch (school) {
        case COURSE:
            return new AdminMap<Course>(school);
        case PROGRAM:
            return new AdminMap<Program>(school);
        case ROOM:
            return new AdminMap<Room>(school);
        //case STUDENT_GROUP:
          //  return new UserMap<StudentGroup>(school);
        default:
            return null;
    }
    }
        
    public AdminSchedule getAdminSchedule() {
        return new AdminSchedule();
    }
    
    
}
