package services;

/** Service class that populates the database with mock data */
public class Fill {
   /** Default constructor */
   public Fill() {}
      
   /** Populates the database with data for the specified user name, for 4 generations
    * @param userName The user name to populate data for
    * @return The result of the execution
    */
   public response.FillResponse fill(String userName) {return null;}
   
   /** Populates the database with data for the specified user name, for the desired number of generations
    * @param userName The user name to populate data for
    * @param generations The number of generations to generate data for
    * @return The result of the execution
    */
   public response.FillResponse fill(String userName, int generations) {return null;}
   
}