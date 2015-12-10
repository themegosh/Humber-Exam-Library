/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduletest;

import com.database.config.DatabaseConnection;
import com.database.config.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Danny Ardona
 */
public class Program {
 
    String programCode;
    String programName;
    
    public Program(){
        
    }
    
    public Program(String programCode, String programName){
        this.programCode = programCode;
        this.programName = programName;
    }
    
    public boolean setProgramCode(String programCode){
        this.programCode = programCode;
        return true;
    }
    
    public String getProgramCode(){
        return programCode;
    }
    
    public boolean setProgramName(String programName){
        this.programName = programName;
        return true;
    }
    
    public String getProgramName(){
        return programName;
    }
    
    public void addProgram(){
        DatabaseConnection connection = DatabaseConnection.open();
        connection.addProgram(programCode, programName);
    }
    
    public void removeProgram(){
        DatabaseConnection connection = DatabaseConnection.open();
        connection.removeProgram(programCode);
    }
    
    public Program getProgramByCode(String programCode) throws SQLException{       
        Program program = new Program();

        UserMap<Program> map = new UserMap<Program>(School.PROGRAM);
        HashMap<String, Program> programs = map.returnList();
        /*
        for (Program p : programs){
            if (p.programCode.equals("programCode")){
               return p; 
            }
        }*/
                
        return program;
    }
    
    public HashMap<String, Program> getMap() throws SQLException{
        HashMap<String, Program> programs = new HashMap<String, Program>();
        DatabaseConnection connection = DatabaseConnection.open();
        Result result = connection.getPrograms();
        
        while(result.hasNext()){
            ResultSet set = result.next();
            Program program = new Program(set.getString("program_code"), set.getString("program_name"));
            
            programs.put(program.getProgramCode(), program);
        }
        
        return programs;
    }   
}
