package services;

/** Service class that retrives event data */
public class EventServices {
   /** Default constructor */
   public EventServices() {}
      
   /** Returns all the events connected to the current user's ancestors
    * @return A response containing the array of events
    */
   public response.EventResponse event() {return null;}
   
   /** Returns the information for a specific event
    * @param eventID The ID number for the desired event
    * @return A reponse containing the information for the desired event
    */
   public response.EventResponse event(String eventID) {return null;}
}