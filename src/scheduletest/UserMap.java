package scheduletest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.database.config.DatabaseConnection;
import java.util.Iterator;
import java.util.Map;

/**
*
* @author Trevor Smart
*/

public class UserMap<T> {
    protected HashMap<String, T> map;
    protected DatabaseConnection dbconn;
    
    protected UserMap(School school) throws SQLException {
        this.map = new HashMap<String, T>();
        //copy data from db to hashmap
        switch (school) {
        case COURSE:
            break;
        case PROGRAM:
            Program p = new Program("DSD", "SADSAD");
            map.put("PMap", (T) p.getMap());
            break;
        case ROOM:
            break;
        case STUDENT_GROUP:
            break;
        default:
            break;
        }
    }
    
    public T get(String pk) {
        return map.get(pk);
    }
    
    public HashMap<String, T> returnList() {
        HashMap<String, T> list = new HashMap<String, T>();
        
        Iterator iterator = map.entrySet().iterator();
        
        if (iterator.hasNext()){
            Map.Entry pair = (Map.Entry) iterator.next();
            return (HashMap<String, T>) (T) pair.getValue();
        }
        
        return list;
    }
}
