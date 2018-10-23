package dao;

import java.util.Set;

/** Class that contains a set of all the persons */
public class PersonDao {
   
   
   // 1. adding a new person into the database
   // 2. removing a person from the database
   // 3. removing many people from the database
   // 3. adding many people into the database
   // 4. retrieving a person from the database
   // 5. retrieving many people from the database
   
   
   /** Set of all the persons */
   private Set<model.Person> persons;
   
   /** Default constructor */
   public PersonDao() {}
      
   /** Parameterized constructor
    * @param persons Set of persons to be put in the object
    */
   public PersonDao(Set<model.Person> persons) {}
      
   /** Sets a new set of persons
    * @param persons new set of persons to be put in the object
    */
   public void setPersons(Set<model.Person> persons) {}
      
   /** Returns the set of persons
    * @return The set of persons
    */
   public Set<model.Person> getPersons() {return persons;}
}