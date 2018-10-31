package dao;

import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/** Class that contains a set of all the authentication tokens */
public class AuthTokenDao {
   /** Object representing the connection to the database */
   private Connection databaseConnection;
   
   /** Default constructor */
   public AuthTokenDao() {
      try {
         String url = "jdbc:sqlite:test.db";
         databaseConnection = DriverManager.getConnection(url);
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
   }
   
   /** Adds a token to the database
    * @param newToken The token to add to the database
    */
   public void addToken(model.AuthToken newToken) {
      String insertStatement = "insert into tokens(authToken,userName,personID) values(?,?,?)";
      
      try {
         PreparedStatement preparedStatement = databaseConnection.prepareStatement(insertStatement);
         preparedStatement.setString(1, newToken.getAuthToken());
         preparedStatement.setString(2, newToken.getUserName());
         preparedStatement.setString(3, newToken.getPersonID());
         preparedStatement.executeUpdate();
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
   }
   
   /** Removes a token from the database
    * @param tokenToRemove The token to remove from the database
    */
   public void removeToken(model.AuthToken tokenToRemove) {
      String deleteStatement = "delete from tokens where authToken = ?";
      
      try {
         PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteStatement);
         preparedStatement.setString(1, tokenToRemove.getAuthToken());
         preparedStatement.executeUpdate();
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
   }
   
   /** Removes a specified number of tokens from the database
    * @param tokenSet Set of tokens to remove, if the set is empty all the tokens in the database are removed
    */
   public void removeMultipleTokens(Set<model.AuthToken> tokenSet) {
      if (tokenSet.size() == 0) {
         try {
            String deleteStatement = "delete from tokens";
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteStatement);
            preparedStatement.executeUpdate();
         }
         catch (SQLException exception) {
            System.out.println(exception.getMessage());
         }
      }
      else {
         for (model.AuthToken token : tokenSet) {
            removeToken(token);
         }
      }
   }
   
   /** Retrieves the specified token from the database
    * @param tokenValue The value of the token to retrieve
    * @return The token corresponding to the value provided
    */
   public model.AuthToken retrieveToken(String tokenValue) {
      String selectStatement = "select authToken, userName, personID from tokens where authToken = ?";
      
      try {
         PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectStatement);
         preparedStatement.setString(1, tokenValue);
         
         ResultSet resultSet = preparedStatement.executeQuery();
         resultSet.next();
         return new model.AuthToken(resultSet.getString("authToken"), resultSet.getString("userName"), resultSet.getString("personID"));
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
      
      return null;
   }
}