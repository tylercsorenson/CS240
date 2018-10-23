package dao;

import java.util.Set;

/** Class that contains a set of all the authentication users */
public class UserDao {
   
   // 1. adding a new user into the database
   // adding many users into the database
   // 2. removing a user from the database
   // removing many users from the database
   // 4. retrieving a user from the database
   
   /** Set of all the users */
   private Set<model.User> users;
   
   /** Default constructor */
   public UserDao() {}
      
   /** Parameterized constructor
    * @param users Set of users to be put in the object
    */
   public UserDao(Set<model.User> users) {}
      
   /** Sets a new set of users
    * @param users new set of users to be put in the object
    */
   public void setUsers(Set<model.User> users) {}
      
   /** Returns the set of users
    * @return The set of users
    */
   public Set<model.User> getUsers() {return users;}
}