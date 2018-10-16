package request;

public class RegisterRequest {
   private String userName;
   private String password;
   private String email;
   private String firstName;
   private String lastName;
   private String gender;
   
   public RegisterRequest() {}
      
   public RegisterRequest(String userName, String password, String email, String firstName, String lastName, String gender) {}
   
   public void setUserName(String userName) {}
      
   public void setPassword(String password) {}
      
   public void setEmail(String email) {}
      
   public void setFirstName(String firstName) {}
      
   public void setLastName(String lastName) {}
      
   public void setGender(String gender) {}
      
   public String getUserName() {return userName;}
      
   public String getPassword() {return password;}
      
   public String getEmail() {return email;}
   
   public String getFirstName() {return firstName;}
      
   public String getLastName() {return lastName;}
      
   public String getGender() {return gender;}
}