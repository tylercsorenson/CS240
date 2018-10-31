package dao;

import java.util.Set;
import java.util.HashSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/** Class that contains a set of all the persons */
public class PersonDao {
   /** Object representing the connection to the database */
   private Connection databaseConnection;
   
   /** Default constructor */
   public PersonDao() {
      try {
         String url = "jdbc:sqlite:test.db";
         databaseConnection = DriverManager.getConnection(url);
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
   }
   
   /** Adds a person to the database
    * @param newPerson The person to add to the database
    */
   public void addPerson(model.Person newPerson) {
      String insertStatement = "insert into events(personID, descendant, firstName, lastName, gender, father, mother, spouse) values(?,?,?,?,?,?,?,?)";
      
      try {
         PreparedStatement preparedStatement = databaseConnection.prepareStatement(insertStatement);
         preparedStatement.setString(1, newPerson.getPersonID());
         preparedStatement.setString(2, newPerson.getDescendant());
         preparedStatement.setString(3, newPerson.getFirstName());
         preparedStatement.setString(4, newPerson.getLastName());
         preparedStatement.setString(5, newPerson.getGender());
         preparedStatement.setString(6, newPerson.getFather());
         preparedStatement.setString(7, newPerson.getMother());
         preparedStatement.setString(8, newPerson.getSpouse());
         preparedStatement.executeUpdate();
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
   }
   
   /** Removes a person from the database
    * @param personToRemove The person to remove from the database
    */
   public void removePerson(model.Person personToRemove) {
      String deleteStatement = "delete from persons where personID = ?";
      
      try {
         PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteStatement);
         preparedStatement.setString(1, personToRemove.getPersonID());
         preparedStatement.executeUpdate();
      }
      catch (SQLException exception) {
         System.out.println(exception.getMessage());
      }
   }
   
   /** Removes multiple people from the database
    * @param rootUser User name of the user whose ancestors are to be removed
    */
   public void removeMultiplePeople(String rootUser) {}
   
   /** Adds multiple people to the database
    * @param personSet Set of people to add to the database
    */
   public void addMultiplePeople(Set<model.Person> personSet) {}
   
   /** Retrieves a single person from the database
    * @param personID The ID number of the person to retrieve
    * @return The person retrieved from the database
    */
   public model.Person retrievePerson(String personID) {return null;}
   
   /** Retrieves multiple people from the database
    * @param rootUser User name of the user whose ancestors are to be retrieved
    * @return The set of people specified
    */
   public Set<model.Person> retrieveMultiplePeople(String rootUser) {return null;}
}