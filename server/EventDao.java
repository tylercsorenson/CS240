package dao;

import java.util.Set;
import java.util.HashSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/** Class that contains a set of all the events */
public class EventDao {
   /** Object representing the connection to the database */
   private Connection databaseConnection;
   
   /** Default constructor */
   public EventDao() {
      try {
         String url = "jdbc:sqlite:test.db";
         databaseConnection = DriverManager.getConnection(url);
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
   }
      
   /** Adds an event to the database
    * @param newEvent The event to add to the database
    */
   public void addEvent(model.Event newEvent) {
      String insertStatement = "insert into persons(EventID, descendant, personID, latitude, longitude, country, city, eventType, year) values(?,?,?,?,?,?,?,?,?)";
      
      try {
         PreparedStatement preparedStatement = databaseConnection.prepareStatement(insertStatement);
         preparedStatement.setString(1, newEvent.getEventID());
         preparedStatement.setString(2, newEvent.getDescendant());
         preparedStatement.setString(3, newEvent.getPersonID());
         preparedStatement.setDouble(4, newEvent.getLatitude());
         preparedStatement.setDouble(5, newEvent.getLongitude());
         preparedStatement.setString(6, newEvent.getCountry());
         preparedStatement.setString(7, newEvent.getCity());
         preparedStatement.setString(8, newEvent.getEventType());
         preparedStatement.setInt(9, newEvent.getYear());
         preparedStatement.executeUpdate();
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
   }
   
   /** Removes an event from the database
    * @param eventToRemove The event to remove from the database
    */
   public void removeEvent(model.Event eventToRemove) {
      String deleteStatement = "delete from events where eventID = ?";
      
      try {
         PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteStatement);
         preparedStatement.setString(1, eventToRemove.getEventID());
         preparedStatement.executeUpdate();
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
   }
   
   /** Removes multiple events from the database
    * @param rootUser User name of the user whose ancestors' events are to be removed
    */
   public void removeMultipleEvents(String rootUser) {
      String deleteStatement = "delete from events where userName = ?";
      
      try {
         PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteStatement);
         preparedStatement.setString(1, rootUser);
         preparedStatement.executeUpdate();
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
   }
   
   /** Adds multiple events to the database
    * @param eventSet Set of events to add to the database
    */
   public void addMultipleEvents(Set<model.Event> eventSet) {
      for (model.Event event : eventSet) {
         addEvent(event);
      }
   }
   
   /** Retrieves a single event from the database
    * @param eventID The ID number of the event to retrieve
    * @return The event retrieved from the database
    */
   public model.Event retrieveEvent(String eventID) {
      String selectStatement = "select eventID, descendant, personID, latitude, longitude, country, city, eventType, year from events where eventID = ?";
      
      try {
         PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectStatement);
         preparedStatement.setString(1, eventID);
         
         ResultSet resultSet = preparedStatement.executeQuery();
         resultSet.next();
         return new model.Event(resultSet.getString("eventID"), resultSet.getString("descendant"), resultSet.getString("personID"), resultSet.getDouble("latitude"), resultSet.getDouble("longitude"), resultSet.getString("country"), resultSet.getString("city"), resultSet.getString("eventType"), resultSet.getInt("year"));
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
      
      return null;
   }
   
   /** Retrieves multiple events from the database
    * @param rootUser User name of the user whose ancestors' events are to be retrieved
    * @return The set of events specified
    */
   public Set<model.Event> retrieveMultipleEvents(String rootUser) {
      String selectStatement = "select eventID, descendant, personID, latitude, longitude, country, city, eventType, year from events where userName = ?";
      HashSet<model.Event> eventSet = new HashSet<>();
      
      try {
         PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectStatement);
         preparedStatement.setString(1, rootUser);
         
         ResultSet resultSet = preparedStatement.executeQuery();
         
         while (resultSet.next()) {
            eventSet.add(new model.Event(resultSet.getString("eventID"), resultSet.getString("descendant"), resultSet.getString("personID"), resultSet.getDouble("latitude"), resultSet.getDouble("longitude"), resultSet.getString("country"), resultSet.getString("city"), resultSet.getString("eventType"), resultSet.getInt("year")));
         }
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
      
      return eventSet;
   }
}