package model;

public class User {
   private String userName;
   private String password;
   private String email;
   private String firstName;
   private String lastName;
   private String gender;
   private String personID;
   /**
   *Default Constuctor
   */
   public User() {}
   
   public User(String userName, String password, String email, String firstName, String lastName, String gender, String personID) {}
   
   public void setUserName(String userName) {}
      
   public void setPassword(String password) {}
      
   public void setEmail(String email) {}
      
   public void setFirstName(String firstName) {}
      
   public void setLastName(String lastName) {}
      
   public void setGender(String gender) {}
      
   public void setPersonID(String personID) {}
      
   public String getUserName() {return userName;}
      
   public String getPassword() {return password;}
      
   public String getEmail() {return email;}
   
   public String getFirstName() {return firstName;}
      
   public String getLastName() {return lastName;}
      
   public String getGender() {return gender;}
      
   public String getPersonID() {return personID;}
}