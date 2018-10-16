package request;

public class LoginRequest {
   private String userName;
   private String password;
   
   public LoginRequest() {}
   
   public LoginRequest(String userName, String password) {}
   
   public void setUserName(String userName) {}
      
   public void setPassword(String password) {}
      
   public String getUserName() {return userName;}
         
   public String getPassword() {return password;}
}