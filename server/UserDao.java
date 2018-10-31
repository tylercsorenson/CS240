package dao;

import java.util.Set;
import java.util.HashSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/** Class that contains a set of all the authentication users */
public class UserDao {
   /** Object representing the connection to the database */
   private Connection databaseConnection;
   
   /** Default constructor */
   public UserDao() {
      try {
         String url = "jdbc:sqlite:test.db";
         databaseConnection = DriverManager.getConnection(url);
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
   }

   /** Adds a user to the database
    * @param newUser The user to add to the database
    */
   public void addUser(model.User newUser) {
      String insertStatement = "insert into users(userName, password, email, firstName, lastName, gender, personID) values(?,?,?,?,?,?,?)";
      
      try {
         PreparedStatement preparedStatement = databaseConnection.prepareStatement(insertStatement);
         preparedStatement.setString(1, newUser.getUserName());
         preparedStatement.setString(2, newUser.getPassword());
         preparedStatement.setString(3, newUser.getEmail());
         preparedStatement.setString(4, newUser.getFirstName());
         preparedStatement.setString(5, newUser.getLastName());
         preparedStatement.setString(6, newUser.getGender());
         preparedStatement.setString(7, newUser.getPersonID());
         preparedStatement.executeUpdate();
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
   }
      
   /** Adds multiple users to the database
    * @param userSet Set of users to add to the database
    */
   public void addMultipleUsers(Set<model.User> userSet) {}
      
   /** Removes a user from the database
    * @param userToRemove The user to remove from the database
    */
   public void removeUser(model.User userToRemove) {
      String deleteStatement = "delete from users where userName = ?";
      
      try {
         PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteStatement);
         preparedStatement.setString(1, userToRemove.getUserName());
         preparedStatement.executeUpdate();
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
   }
      
   /** Removes multiple users from the database
    * @param userSet Set of users to remove from the database, if the set is empty all the users in the database are removed
    */
   public void removeMultipleUsers(Set<model.User> userSet) {}
      
   /** Retrieves a single user from the database
    * @param userName The user name of the user to retrieve
    * @return The user retrieved from the database
    */
   public model.User retrieveUser(String userName) {return null;}
}