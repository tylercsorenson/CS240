package response;

/** Class representing the reponse from executing register */
public class RegisterResponse {
   /** User name of the user */
   private String userName;
   /** Authentication token of the user */
   private String authToken;
   /** ID number of the user */
   private String personID;
   /** The reponse's message */
   private String message;
   
   /** Default constructor */
   public RegisterResponse() {}
      
   /** Parameterized constructor
    * @param userName User name of the user
    * @param authToken Authentication token of the user
    * @param personID ID number of the user
    */
   public RegisterResponse(String userName, String authToken, String personID) {}
      
   /** Parameterized constructor
    * @param message Message to display
    */
   public RegisterResponse(String message) {}
      
   /** Sets a new user name
    * @param userName new user name to be put in the object
    */
   public void setUserName(String userName) {}
   
   /** Sets a new token
    * @param authToken new token to be put in the object
    */
   public void setAuthToken(String authToken) {}
   
   /** Sets a new ID number
    * @param personID new ID number to be put in the object
    */
   public void setPersonID(String personID) {}
      
   /** Sets a new message
    * @param message New message to be put in the object
    */
   public void setMessage(String message) {}
      
   /** Returns the user name
    * @return The user name
    */
   public String getUserName() {return userName;}
   
   /** Returns the token
    * @return The token
    */
   public String getAuthToken() {return authToken;}
   
   /** Returns the ID number
    * @return The ID number
    */
   public String getPersonID() {return personID;}
   
   /** Returns the set of tokens
    * @return The set of tokens
    */
   public String getMessage() {return message;}
}