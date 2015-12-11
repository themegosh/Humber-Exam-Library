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
        if (username.isEmpty() || password.isEmpty())
            throw new UserException("Username and/or password cannot be empty!");
        
        try {
            id = Integer.valueOf(username);
            DatabaseConnection conn = DatabaseConnection.open();
            Result result = conn.getUser(id, password);
            
            if (result != null && result.hasNext()) {
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
    
    public int getId(){
        return id;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public int getAccessLevel(){
        return accessLevel;
    }
    
    public Schedule getSchedule() {
        return new Schedule();
    }
    
}
