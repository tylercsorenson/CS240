package request;

public class LoadRequest {
   private model.User[] users;
   private model.Person[] persons;
   private model.Event[] events;
   
   public LoadRequest() {}
      
   public LoadRequest(model.User[] users, model.Person[] persons, model.Event[] events) {}
      
   public void setUsers(model.User[] users) {}
      
   public void setPersons(model.Person[] persons) {}
      
   public void setEvents(model.Event[] events) {}
      
   public model.User[] getUsers() {return users;}
   
   public model.Person[] getPersons() {return persons;}
   
   public model.Event[] getEvents() {return events;}
}