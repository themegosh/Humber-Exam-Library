/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humber.exam.library;

import java.sql.SQLException;
import humber.exam.database.DatabaseConnection;
import humber.exam.database.Result;
import java.sql.ResultSet;

/**
 *
 * @author mathe_000
 */
public class User {
    
    private int id;
    private String firstName;
    private String lastName;
    private int accessLevel;

    public User(String username, String password) throws Exception {
        
        try {
            DatabaseConnection conn = DatabaseConnection.open();
            Result result = conn.getUser(username, password);
            
            if (result.hasNext()){
                ResultSet set = result.next();
                id = set.getInt("id");
                firstName = set.getString("first_name");
                lastName = set.getString("last_name");
                accessLevel = set.getInt("access_level");
            }
            else {
                throw new UserException("Invalid username and/or password.");
            }
            conn.close();
        }
        catch (Exception e){
            throw e;
        }
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
