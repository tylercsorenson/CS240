package dao;

import java.util.Set;

public class UserDao {
   private Set<model.User> users;
   
   public UserDao() {}
      
   public UserDao(Set<model.User> users) {}
      
   public void setUsers(Set<model.User> users) {}
      
   public Set<model.User> getUsers() {return users;}
}