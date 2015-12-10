package scheduletest;

import com.database.config.DatabaseConfiguration;
import com.database.config.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ScheduleTestMain {
	
    public static void main(String[] args) throws SQLException {
    	
        Administrator admin = new Administrator();
        UserMap u = admin.getMap(School.PROGRAM);
        HashMap<String, Program> programs = u.returnList();
        
        for (String key : programs.keySet()){
            System.out.println(programs.get(key).getProgramName());
        }
    }   
}
