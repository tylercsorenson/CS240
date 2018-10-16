package response;

public class EventResponse {
   private String descendant;
   private String eventID;
   private String personID;
   private double latitude;
   private double longitude;
   private String country;
   private String city;
   private String eventType;
   private int year;
   private String message;
   private model.Event[] events;
   
   public EventResponse() {}
   
   public EventResponse(String descendant, String eventID, String personID, double latitude, double longitude, String country, String city, String eventType, int year) {}
      
   public EventResponse(String message) {}
      
   public EventResponse(model.Event[] events) {}
      
   public void setDescendant(String descendant) {}
      
   public void setEventID(String eventID) {}
      
   public void setPersonID(String personID) {}
      
   public void setLatitude(double latitude) {}
      
   public void setLongitude(double longitude) {}
      
   public void setCountry(String country) {}
      
   public void setCity(String city) {}
      
   public void setEventType(String eventType) {}

   public void setYear(int year) {}
      
   public void setMessage(String message) {}
      
   public void setEvents(model.Event[] events) {}
      
   public String getDescendant() {return descendant;}
      
   public String getEventID() {return eventID;}
      
   public String getPersonID() {return personID;}
      
   public double getLatitude() {return latitude;}
      
   public double getLongitude() {return longitude;}
   
   public String getCountry() {return country;}
   
   public String getCity() {return city;}
   
   public String getEventType() {return eventType;}
   
   public int getYear() {return year;}
   
   public String getMessage() {return message;}
   
   public model.Event[] getEvents() {return events;}
}