package response;

/** Class representing the reponse from executing fill */
public class FillResponse {
   /** The reponse's message */
   private String message;
   
   /** Default constructor */
   public FillResponse() {}
      
   /** Parameterized constructor
    * @param message Message to display
    */
   public FillResponse(String message) {}
         
   /** Sets a new message
    * @param message New message to be put in the object
    */
   public void setMessage(String message) {}
         
   /** Returns the message
    * @return The message
    */
   public String getMessage() {return message;}
}