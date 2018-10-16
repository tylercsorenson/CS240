package model;

public class User {
   /** User name of the user */
   private String userName;
   /** Password of the user */
   private String password;
   /** E-mail address of the user */
   private String email;
   /** First name of the user */
   private String firstName;
   /** Last name of the user */
   private String lastName;
   /** Gender of the user, either "m" of "f" */
   private String gender;
   /** ID number of the user */
   private String personID;
   
   /** Default constructor */
   public User() {}
   
   /** Parameterized constructor
    * @param userName User name of the user
    * @param password Password of the user
    * @param email E-mail address of the user
    * @param firstName First name of the user
    * @param lastName Last name of the user
    * @param gender Gender of the user, either "m" of "f"
    * @param personID ID number of the user
    */
   public User(String userName, String password, String email, String firstName, String lastName, String gender, String personID) {}
   
   /** Sets a new user name
    * @param userName new user name to be put in the object
    */
   public void setUserName(String userName) {}
      
   /** Sets a new password
    * @param password new password to be put in the object
    */
   public void setPassword(String password) {}
      
   /** Sets a new E-mail
    * @param email new E-mail to be put in the object
    */
   public void setEmail(String email) {}
      
   /** Sets a new first name
    * @param firstName new first name to be put in the object
    */
   public void setFirstName(String firstName) {}
      
   /** Sets a new last name
    * @param lastName new last name to be put in the object
    */
   public void setLastName(String lastName) {}
      
   /** Sets a new gender
    * @param gender new gender to be put in the object
    */
   public void setGender(String gender) {}
      
   /** Sets a new ID number
    * @param personID new ID number to be put in the object
    */
   public void setPersonID(String personID) {}
      
   /** Returns the user name
    * @return The user name
    */
   public String getUserName() {return userName;}
      
   /** Returns the password
    * @return The password
    */
   public String getPassword() {return password;}
      
   /** Returns the E-mail
    * @return The E-mail
    */
   public String getEmail() {return email;}
   
   /** Returns the first name
    * @return The first name
    */
   public String getFirstName() {return firstName;}
      
   /** Returns the last name
    * @return The last name
    */
   public String getLastName() {return lastName;}
      
   /** Returns the gender
    * @return The gender
    */
   public String getGender() {return gender;}
      
   /** Returns the ID Number
    * @return The ID Number
    */
   public String getPersonID() {return personID;}
}