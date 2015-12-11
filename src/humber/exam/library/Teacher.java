/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humber.exam.library;

import humber.exam.database.DatabaseConnection;
import humber.exam.database.Result;
import java.sql.ResultSet;

/**
 *
 * @author mathe_000
 */
public class Teacher {
    private int id;
    private String name;
    
    public Teacher(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public Teacher(int id){
        try {
            DatabaseConnection conn = DatabaseConnection.open();
            Result result = conn(code);
            
            if (result != null && result.hasNext()) {
                ResultSet set = result.next();
                c = new Course(set.getString("COURSE_CODE"), set.getString("COURSE_NAME"), string.getString("COURSE_"))
                
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
        
        
        return c;
    }
}
