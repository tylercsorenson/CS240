package request;

/** Class containing the data to load into the database */
public class LoadRequest {
   /** Array of the users to load */
   private model.User[] users;
   /** Array of the persons to load */
   private model.Person[] persons;
   /** Array of the events to load */
   private model.Event[] events;
   
   /** Default constructor */
   public LoadRequest() {}
      
   /** Parameterized constructor
    * @param users The array of users to load
    * @param persons The array of persons to load
    * @param events The array of events to load
    */
   public LoadRequest(model.User[] users, model.Person[] persons, model.Event[] events) {}
      
   /** Sets a new array of users
    * @param users new array of users to be put in the object
    */
   public void setUsers(model.User[] users) {}
      
   /** Sets a new array of persons
    * @param persons new array of persons to be put in the object
    */
   public void setPersons(model.Person[] persons) {}
      
   /** Sets a new array of events
    * @param events new array of events to be put in the object
    */
   public void setEvents(model.Event[] events) {}
      
   /** Returns the array of users
    * @return The array of users
    */
   public model.User[] getUsers() {return users;}
   
   /** Returns the array of persons
    * @return The array of persons
    */
   public model.Person[] getPersons() {return persons;}
   
   /** Returns the array of events
    * @return The array of events
    */
   public model.Event[] getEvents() {return events;}
}