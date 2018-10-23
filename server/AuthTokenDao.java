package dao;

import java.util.ArrayList;

/** Class that contains a set of all the authentication tokens */
public class AuthTokenDao {
   /** Default constructor */
   public AuthTokenDao() {}
   
   /**  Adds a token to the database
    * @param newToken The token to add to the database
    */
   public void addToken(model.AuthToken newToken) {}
   
   /** Removes a token from the database
    * @param tokenToRemove The token to remove from the database
    */
   public void removeToken(model.AuthToken tokenToRemove) {}
   
   /** Removes a specified number of tokens from the database
    * @param tokenList List of tokens to remove, if the list is empty all the tokens in the database are removed
    */
   public void removeManyTokens(ArrayList<model.AuthToken> tokenList) {}
   
   /** Retrieves the specified token from the database
    * @param tokenValue The value of the token to retrieve
    */
   public model.AuthToken retrieveToken(String tokenValue) {return null;}
}