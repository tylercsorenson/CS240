package services;

//* Service class that allows a user to login to the server */
public class Login {
   /** Default constructor */
   public Login() {}
      
   /** Attempts to login a user based on the information in the request
    * @param request The request containing the login information
    * @return Response containing the authentication token if succesful, or a message if unsuccesful
    */
   public response.LoginResponse login(request.LoginRequest request) {return null;}
}