package application;

import java.sql.DriverManager;
import java.sql.*;

public class Sqliteconnection {
  public static Connection connector(){
	  try{
		  Class.forName("org.sqlite.JDBC");
		  Connection conn = DriverManager.getConnection("jdbc:sqlite:bobby.sqlite");
		  return conn;
	  }catch(Exception e)
	  {
		  return null;
	  }
  }
}
