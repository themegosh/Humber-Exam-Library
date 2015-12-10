/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduletest;

import com.database.config.DatabaseConfiguration;
import com.database.config.DatabaseConnection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Danny Ardona
 */
public class ProgramMap {
    Map<String, Program> programs = new HashMap<String, Program>();
    
    public boolean addProgram(Program program){
        programs.put(program.programCode, program);
        return true;
    }
    
    public boolean deleteProgram(Program program){
        programs.remove(program.programCode);
        return true;
    }
    
    public boolean checkIfProgramExists(String programCode){
        if (programs.containsKey(programCode)){
            programs.remove(programCode);
            return true;
        }
        return false;
    }

    public void getMap(){
        DatabaseConnection connection = DatabaseConnection.open();
        connection.connect();
        //connection.execute("SELECT * FROM PROGRAM").
    }
}
