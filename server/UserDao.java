package dao;

import java.util.Set;

/** Class that contains a set of all the authentication users */
public class UserDao {
   /** Default constructor */
   public UserDao() {}
   
   /** Adds a user to the database
    * @param newUser The user to add to the database
    */
   public void addUser(model.User newUser) {}
      
   /** Adds multiple users to the database
    * @param userSet Set of users to add to the database
    */
   public void addMultipleUsers(Set<model.User> userSet) {}
      
   /** Removes a user from the database
    * @param userToRemove The user to remove from the database
    */
   public void removeUser(model.User userToRemove) {}
      
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