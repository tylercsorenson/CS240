package model;

public class Event {
   private String eventID;
   private String descendant;
   private String personID;
   private double latitude;
   private double longitude;
   private String country;
   private String city;
   private String eventType;
   private int year;
   
   public Event() {}
   
   public Event(String eventID, String descendant, String personID, double latitude, double longitude, String country, String city, String eventType, int year) {}
      
   public void setEventID(String eventID) {}
   
   public void setDescendant(String descendant) {}
      
   public void setPersonID(String personID) {}
      
   public void setLatitude(double latitude) {}
      
   public void setLongitude(double longitude) {}
      
   public void setCountry(String country) {}
      
   public void setCity(String city) {}
      
   public void setEventType(String eventType) {}

   public void setYear(int year) {}
      
   public String getEventID() {return eventID;}
      
   public String getDescendant() {return descendant;}
      
   public String getPersonID() {return personID;}
      
   public double getLatitude() {return latitude;}
      
   public double getLongitude() {return longitude;}
   
   public String getCountry() {return country;}
   
   public String getCity() {return city;}
   
   public String getEventType() {return eventType;}
   
   public int getYear() {return year;}
}