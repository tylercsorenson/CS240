package dao;

import java.util.Set;

public class EventDao {
   private Set<model.Event> events;
   
   public EventDao() {}
      
   public EventDao(Set<model.Event> events) {}
      
   public void setEvents(Set<model.Event> events) {}
      
   public Set<model.Event> getEvents() {return events;}
}