package dao;

import java.util.Set;

/** Class that contains a set of all the events */
public class EventDao {
   /** Set of all the events */
   private Set<model.Event> events;
   
   /** Default constructor */
   public EventDao() {}
      
   /** Parameterized constructor
    * @param events Set of events to be put in the object
    */
   public EventDao(Set<model.Event> events) {}
      
   /** Sets a new set of tokens
    * @param events new set of events to be put in the object
    */
   public void setEvents(Set<model.Event> events) {}
      
   /** Returns the set of events
    * @return The set of events
    */
   public Set<model.Event> getEvents() {return events;}
}