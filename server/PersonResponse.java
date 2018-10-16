package response;

/** Class representing the reponse from executing clear */
public class PersonResponse {
   /** User name of the user connected to this person */
   private String descendant;
   /** ID number of this person */
   private String personID;
   /** First name of this person */
   private String firstName;
   /** Last name of this person */
   private String lastName;
   /** Gender of this person, either "m" or "f" */
   private String gender;
   /** ID number of this person's father, if applicable */
   private String father;
   /* ID number of this person's mother, if applicable */
   private String mother;
   /* ID number of this person's spouse, if applicable */
   private String spouse;
   /** The reponse's message */
   private String message;
   /** Array of all the ancestors of the current user */
   private model.Person[] persons;
   
   /** Default constructor */
   public PersonResponse() {}

   /** Parameterized constructor
    * @param descendant User name of the user connected to this person
    * @param personID ID number of this person
    * @param firstName First name of this person
    * @param lastName Last name of this person
    * @param gender Gender of this person, either "m" or "f"
    * @param father ID number of this persons father, if applicable
    * @param mother ID number of this person's mother, if applicable
    * @param spouse ID number of this person's spouse, if applicable
    */
   public PersonResponse(String descendant, String personID, String firstName, String lastName, String gender, String father, String mother, String spouse) {}
      
   /** Parameterized constructor
    * @param message Message to display
    */
   public PersonResponse(String message) {}
   
   /** Parameterized constructor
    * @param persons Array of persons to be contained in the response
    */
   public PersonResponse(model.Person[] persons) {}
      
   /** Sets a new descendant user name
    * @param descendant Value to set the descendant's user name to
    */   
   public void setDescendant(String descendant) {}
      
   /** Sets a new ID number
    * @param personID Value to set the ID number to
    */
   public void setPersonID(String personID) {}
      
   /** Sets a new first name
    * @param firstName Value to set the first name to
    */
   public void setFirstName(String firstName) {}
      
   /** Sets a new last name
    * @param lastName Value to set the last name to
    */
   public void setLastName(String lastName) {}
   
   /** Sets a new gender
    * @param gender Value to set the gender to
    */   
   public void setGender(String gender) {}
      
   /** Sets a new father
    * @param father Value to set the father's ID number to
    */
   public void setFather(String father) {}
      
   /** Sets a new mother
    * @param mother Value to set the mother's ID number to
    */
   public void setMother(String mother) {}
      
   /** Sets a new spouse
    * @param spouse Value to set the spouse's ID number to
    */
   public void setSpouse(String spouse) {}
      
   /** Sets a new message
    * @param message New message to be put in the object
    */
   public void setMessage(String message) {}
      
   /** Sets a new array of persons
    * @param persons new array of persons to be put in the object
    */
   public void setPersons(model.Person[] persons) {}
      
   /** Returns the user name of the user connected to this person
    * @return User name of the user connected to this person
    */
   public String getDescendant() {return descendant;}
   
   /** Returns ID number of this person
    * @return ID number of this person
    */
   public String getPersonID() {return personID;}
      
   /** Returns the first name of this person
    * @return First name of this person
    */
   public String getFirstName() {return firstName;}
      
   /** Returns the last name of this person
    * @return Last name of this person
    */
   public String getLastName() {return lastName;}
      
   /** Returns the gender of this person, either "m" or "f"
    * @return Gender of this person, either "m" or "f"
    */
   public String getGender() {return gender;}
      
   /** Returns the ID number of this person's father, if applicable
    * @return ID number of this person's father, if applicable
    */
   public String getFather() {return father;}
      
   /** Returns the ID number of this person's mother, if applicable
    * @return ID number of this person's mother, if applicable
    */
   public String getMother() {return mother;}
      
   /** Returns the ID number of this person's spouse, if applicable
    * @return ID number of this person's spouse, if applicable
    */
   public String getSpouse() {return spouse;}
   
   /** Returns the set of tokens
    * @return The set of tokens
    */
   public String getMessage() {return message;}
   
   /** Returns the array of persons
    * @return The array of persons
    */
   public model.Person[] getPersons() {return persons;}
}