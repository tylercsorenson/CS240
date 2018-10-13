package model;

public class AuthToken {
   private String userName;
   private String authToken;
   private String personID;
   
   public AuthToken() {}
   
   public AuthToken(String userName, String authToken, String personID) {}
      
   public void setUserName(String userName) {}
   
   public void setAuthToken(String authToken) {}
   
   public void setPersonID(String personID) {}
      
   public String getUserName() {return userName;}
   
   public String getAuthToken() {return authToken;}
   
   public String getPersonID() {return personID;}
}