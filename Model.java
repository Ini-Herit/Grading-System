package application;
import java.sql.*;

public class Model {
   Connection connection;
   public Model(){
	   connection = Sqliteconnection.connector();
	   if (connection == null) System.exit(1);
   }
   public boolean isDBconnected(){
	   try{
		   return !connection.isClosed();
	   }catch(SQLException e)
	   {
		   e.printStackTrace();
		   return false;
	   }
   }
   public boolean isLogin(String usern, String passw) throws SQLException{
	   PreparedStatement preparedstatement;
	   ResultSet resultset;
	   String query = "select * from bob where username = ? and password =?";
	   try{
		   preparedstatement = connection.prepareStatement(query);
		   preparedstatement.setString(1, usern);
		   preparedstatement.setString(2, passw);
		   resultset = preparedstatement.executeQuery();
		   if(resultset.next()){
			   return true;
		   }else{return false;}
	   }catch(Exception e){
		   return false;
	   }
   }
   public void Insert(){

   }
}

