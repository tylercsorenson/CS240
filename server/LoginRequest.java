package request;

/** Class containing login attempt information */
public class LoginRequest {
   /** User name to attempt login with */
   private String userName;
   /** Password corresponding to the provided user name */
   private String password;
   
   /** Default constructor */
   public LoginRequest() {}
   
   /** Parameterized constructor
   * @param userName User name to attempt login with
   * @param password Password corresponding to the provided user name
   */
   public LoginRequest(String userName, String password) {}
   
   /** Sets a new user name
    * @param userName new user name to be put in the object
    */
   public void setUserName(String userName) {}
   
   /** Sets a new password
    * @param password new password to be put in the object
    */   
   public void setPassword(String password) {}
      
   /** Returns the user name
    * @return The user name
    */
   public String getUserName() {return userName;}
         
   /** Returns the password
    * @return The password
    */
   public String getPassword() {return password;}
}