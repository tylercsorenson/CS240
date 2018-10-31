package model;

/** Class representing an authentication token */
public class AuthToken {
   /** The actual value of the token */
   private String authToken;
   /** User name of the person who the authentication token belongs to */
   private String userName;
   /** The ID number of the person who the authentication token belongs to */
   private String personID;
   
   /** Default constructor */
   public AuthToken() {}
   
   /** Parameterized constructor
    * @param authToken Value of the token being created
    * @param userName user name of the person who's token is being created
    * @param personID ID number of the person who's token is being created
    */
   public AuthToken(String authToken, String userName, String personID) {
      this.authToken = authToken;
      this.userName = userName;
      this.personID = personID;
   }
   
   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      else if (!(o instanceof AuthToken)) {
         return false;
      }
      
      AuthToken token = (AuthToken) o;
      
      if (this.authToken.equals(token.authToken) && this.userName.equals(token.userName) && this.personID.equals(token.personID)) {
         return true;
      }
      else {
         return false;
      }
   }
      
   /** Sets a new user name
    * @param userName Value to set this token's corresponding user name to
    */
   public void setUserName(String userName) {
      this.userName = userName;
   }
   
   /** Sets a new token value
    * @param authToken Value to set this token's value to
    */
   public void setAuthToken(String authToken) {
      this.authToken = authToken;
   }
   
   /** Sets a new ID number
    * @param personID Value to set this token's corresponding ID number to
    */
   public void setPersonID(String personID) {
      this.personID = personID;
   }
   
   /** Returns the user name
    * @return The token's corresponding user name
    */
   public String getUserName() {
      return userName;
   }
   
   /** Returns the token's value
    * @return The token's value
    */
   public String getAuthToken() {
      return authToken;
   }
   
   /** Returns the ID number
    * @return The token's corresponding ID number
    */
   public String getPersonID() {
      return personID;
   }
}