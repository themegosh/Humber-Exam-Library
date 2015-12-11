package humber.exam.library;

import humber.exam.database.DatabaseConnection;
import humber.exam.database.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users
{
  ArrayList<User> userList;
  DatabaseConnection dbconn;
  
  public Users()
  {
    userList = new ArrayList();
  }
  
  public ArrayList<User> getAllUser()
    throws SQLException
  {
    dbconn = DatabaseConnection.open();
    dbconn.connect();
    Result result = dbconn.getAllUsers();
    while (result.hasNext())
    {
      ResultSet set = result.next();
      try
      {
        userList.add(new User(set.getInt("id"), set.getString("first_name"), set
          .getString("last_name"), set.getInt("access_level")));
      }
      catch (SQLException se)
      {
        throw se;
      }
    }
    dbconn.close();
    return userList;
  }
  
  public ArrayList<User> getUserById(int id)
    throws SQLException
  {
    dbconn = DatabaseConnection.open();
    dbconn.connect();
    Result result = dbconn.getUserById(id);
    while (result.hasNext())
    {
      ResultSet set = result.next();
      try
      {
        userList.add(new User(set.getInt("id"), set.getString("first_name"), set
          .getString("last_name"), set.getInt("access_level")));
      }
      catch (SQLException se)
      {
        throw se;
      }
    }
    dbconn.close();
    return userList;
  }
}