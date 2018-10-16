package response;

/** Class representing the reponse from calling an event service function */
public class EventResponse {
   /** User name of the user to which this event's corresponding person belongs */
   private String descendant;
   /** ID number of the event */
   private String eventID;
   /** ID number of this event's corresponding person */
   private String personID;
   /** Latitude where this event's location */
   private double latitude;
   /** Longitude of this event's location */
   private double longitude;
   /** Country where this event occurred */
   private String country;
   /** City where this this event occurred */
   private String city;
   /** Type of event, such as baptism, marriage, or death */
   private String eventType;
   /** Year when this event occurred */
   private int year;
   /** The reponse's message */
   private String message;
   /** Array of all the events for all the ancestors of the current user */
   private model.Event[] events;
   
   /** Default constructor */
   public EventResponse() {}
   
   /** Parameterized constructor
    * @param descendant User name of the user to which this event's corresponding person belongs
    * @param eventID ID number of the event
    * @param personID ID number of this event's corresponding person
    * @param latitude Latitude where this event's location
    * @param longitude Longitude of this event's location
    * @param country Country where this event occurred
    * @param city City where this this event occurred
    * @param eventType Type of event, such as baptism, marriage, or death
    * @param year Year when this event occurred
    */
   public EventResponse(String descendant, String eventID, String personID, double latitude, double longitude, String country, String city, String eventType, int year) {}
   
   /** Parameterized constructor
    * @param message Message to display
    */
   public EventResponse(String message) {}
      
   /** Parameterized constructor
    * @param events Array of events to be contained in the response
    */
   public EventResponse(model.Event[] events) {}
      
   /** Sets a new descendant
    * @param descendant User name of the user to which this event's corresponding person belongs
    */
   public void setDescendant(String descendant) {}
      
   /** Sets a new eventID
    * @param eventID ID number of the event
    */
   public void setEventID(String eventID) {}
      
   /** Sets a new personID
    * @param personID ID number of this event's corresponding person
    */
   public void setPersonID(String personID) {}
      
   /** Sets a new latitude
    * @param latitude Latitude where this event's location
    */
   public void setLatitude(double latitude) {}
      
   /** Sets a new longitude
    * @param longitude Longitude of this event's location
    */
   public void setLongitude(double longitude) {}
      
   /** Sets a new country
    * @param country Country where this event occurred
    */
   public void setCountry(String country) {}
      
   /** Sets a new city
    * @param city City where this this event occurred
    */
   public void setCity(String city) {}
      
   /** Sets a new eventType
    * @param eventType Type of event, such as baptism, marriage, or death
    */
   public void setEventType(String eventType) {}

   /** Sets a new year
    * @param year Year when this event occurred
    */
   public void setYear(int year) {}
      
   /** Sets a new message
    * @param message New message to be put in the object
    */
   public void setMessage(String message) {}
      
   /** Sets a new array of events
    * @param events new array of events to be put in the object
    */
   public void setEvents(model.Event[] events) {}
      
   /** Returns the user name of the user to which this event's corresponding person belongs
    * @return The user name of the user to which this event's corresponding person belongs
    */
   public String getDescendant() {return descendant;}
   
   /** Returns the ID number of the event
    * @return ID number of the event
    */
   public String getEventID() {return eventID;}
      
   /** Returns the ID number of this event's corresponding person
    * @return The ID number of this event's corresponding person
    */
   public String getPersonID() {return personID;}
      
   /** Returns the latitude where this event's location
    * @return The latitude where this event's location
    */
   public double getLatitude() {return latitude;}
      
   /** Returns the longitude of this event's location
    * @return The longitude of this event's location
    */
   public double getLongitude() {return longitude;}
   
   /** Returns country where this event occurred
    * @return The country where this event occurred
    */
   public String getCountry() {return country;}
   
   /** Returns the city where this this event occurred
    * @return The city where this this event occurred
    */
   public String getCity() {return city;}
   
   /** Returns the type of event, such as baptism, marriage, or death
    * @return The type of event, such as baptism, marriage, or deathe
    */
   public String getEventType() {return eventType;}
   
   /** Returns the year when this event occurred
    * @return The year when this event occurred
    */
   public int getYear() {return year;}
   
   /** Returns the message
    * @return The message
    */
   public String getMessage() {return message;}
   
   /** Returns the array of events
    * @return The array of events
    */
   public model.Event[] getEvents() {return events;}
}