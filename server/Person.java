package model;

public class Person {
   private String personID;
   private String descendant;
   private String firstName;
   private String lastName;
   private String gender;
   private String father;
   private String mother;
   private String spouse;
   
   public Person() {}
   
   public Person(String personID, String descendant, String firstName, String lastName, String gender, String father, String mother, String spouse) {}
      
   public void setPersonID(String personID) {}
      
   public void setDescendant(String descendant) {}
      
   public void setFirstName(String firstName) {}
      
   public void setLastName(String lastName) {}
      
   public void setGender(String gender) {}
      
   public void setFather(String father) {}
      
   public void setMother(String mother) {}
      
   public void setSpouse(String spouse) {}
      
   public String getPersonID() {return personID;}
      
   public String getDescendant() {return descendant;}
      
   public String getFirstName() {return firstName;}
      
   public String getLastName() {return lastName;}
      
   public String getGender() {return gender;}
      
   public String getFather() {return father;}
      
   public String getMother() {return mother;}
      
   public String getSpouse() {return spouse;}               
}