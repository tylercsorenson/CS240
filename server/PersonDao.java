package dao;

import java.util.Set;

/** Class that contains a set of all the persons */
public class PersonDao {
   /** Default constructor */
   public PersonDao() {}
   
   /** Adds a person to the database
    * @param newPerson The person to add to the database
    */
   public void addPerson(model.Person newPerson) {}
   
   /** Removes a person from the database
    * @param personToRemove The person to remove from the database
    */
   public void removePerson(model.Person personToRemove) {}
   
   /** Removes multiple people from the database
    * @param personSet Set of people to remove from the database, if the set is empty all the people in the database are removed
    */
   public void removeMultiplePeople(Set<model.Person> personSet) {}
   
   /** Adds multiple people to the database
    * @param personSet Set of people to add to the database
    */
   public void addMultiplePeople(Set<model.Person> personSet) {}
   
   /** Retrieves a single person from the database
    * @param personID The ID number of the person to retrieve
    * @return The person retrieved from the database
    */
   public model.Person retrievePerson(String personID) {return null;}
   
   /** Retrieves multiple people from the database
    * @param IDSet Set of ID numbers corresponding to the people to retrieve
    * @return The set of people specified
    */
   public Set<model.Person> retrieveMultiplePeople(Set<String> IDSet) {return null;}
}