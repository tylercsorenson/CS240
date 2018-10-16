package response;

/** Class representing the reponse from executing login */
public class LoginResponse {
   /** User name of the succesful login */
   private String userName;
   /** Authentication token of the succesful login */
   private String authToken;
   /** ID number corresponding with the user name of the succesful login */
   private String personID;
   /** The reponse's message */
   private String message;
   
   /** Default constructor */
   public LoginResponse() {}
   
   /** Parameterized constructor
    * @param userName User name of the succesful login
    * @param authToken Authentication token of the succesful login
    * @param personID ID number corresponding with the user name of the succesful login
    */
   public LoginResponse(String userName, String authToken, String personID) {}

   /** Parameterized constructor
    * @param message Message to display
    */
   public LoginResponse(String message) {}
      
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
   
   /** Returns the message
    * @return The message
    */
   public String getMessage() {return message;}
}