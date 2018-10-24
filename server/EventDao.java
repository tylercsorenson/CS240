package dao;

import java.util.Set;

/** Class that contains a set of all the events */
public class EventDao {
   /** Default constructor */
   public EventDao() {}
      
   /** Adds an event to the database
    * @param newEvent The event to add to the database
    */
   public void addEvent(model.Event newEvent) {}
   
   /** Removes an event from the database
    * @param eventToRemove The event to remove from the database
    */
   public void removeEvent(model.Event eventToRemove) {}
   
   /** Removes multiple events from the database
    * @param eventSet Set of events to remove from the database, if the set is empty all the events in the database are removed
    */
   public void removeMultiplePeople(Set<model.Event> eventSet) {}
   
   /** Adds multiple events to the database
    * @param eventSet Set of events to add to the database
    */
   public void addMultiplePeople(Set<model.Event> eventSet) {}
   
   /** Retrieves a single event from the database
    * @param eventID The ID number of the event to retrieve
    * @return The event retrieved from the database
    */
   public model.Event retrieveEvent(String eventID) {return null;}
   
   /** Retrieves multiple events from the database
    * @param IDSet Set of ID numbers corresponding to the events to retrieve
    * @return The set of events specified
    */
   public Set<model.Event> retrieveMultiplePeople(Set<String> IDSet) {return null;}
}