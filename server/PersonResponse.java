package response;

public class PersonResponse {
   private String descendant;
   private String personID;
   private String firstName;
   private String lastName;
   private String gender;
   private String father;
   private String mother;
   private String spouse;
   private String message;
   private model.Person[] persons;
   
   public PersonResponse() {}
      
   public PersonResponse(String descendant, String personID, String firstName, String lastName, String gender, String father, String mother, String spouse) {}
      
   public PersonResponse(String message) {}
   
   public PersonResponse(model.Person[] persons) {}
      
   public void setDescendant(String descendant) {}
      
   public void setPersonID(String personID) {}
      
   public void setFirstName(String firstName) {}
      
   public void setLastName(String lastName) {}
      
   public void setGender(String gender) {}
      
   public void setFather(String father) {}
      
   public void setMother(String mother) {}
      
   public void setSpouse(String spouse) {}
      
   public void setMessage(String message) {}
      
   public void setPersons(model.Person[] persons) {}
      
   public String getDescendant() {return descendant;}
   
   public String getPersonID() {return personID;}
      
   public String getFirstName() {return firstName;}
      
   public String getLastName() {return lastName;}
      
   public String getGender() {return gender;}
      
   public String getFather() {return father;}
      
   public String getMother() {return mother;}
      
   public String getSpouse() {return spouse;}
   
   public String getMessage() {return message;}
   
   public model.Person[] getPersons() {return persons;}
}