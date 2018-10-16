package response;

public class RegisterResponse {
   private String userName;
   private String authToken;
   private String personID;
   private String message;
   
   public RegisterResponse() {}
      
   public RegisterResponse(String userName, String authToken, String personID) {}
      
   public RegisterResponse(String message) {}
      
   public void setUserName(String userName) {}
   
   public void setAuthToken(String authToken) {}
   
   public void setPersonID(String personID) {}
      
   public void setMessage(String message) {}
      
   public String getUserName() {return userName;}
   
   public String getAuthToken() {return authToken;}
   
   public String getPersonID() {return personID;}
   
   public String getMessage() {return message;}
}