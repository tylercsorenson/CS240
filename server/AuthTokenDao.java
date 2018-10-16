package dao;

import java.util.Set;

/** Class that contains a set of all the authentication tokens */
public class AuthTokenDao {
   /** Set of all the tokens */
   private Set<model.AuthToken> authTokens;
   
   /** Default constructor */
   public AuthTokenDao() {}
   
   /** Parameterized constructor
    * @param authTokens Set of tokens to be put in the object
    */
   public AuthTokenDao(Set<model.AuthToken> authTokens) {}
   
   /** Sets a new set of tokens
    * @param authTokens New set of tokens to be put in the object
    */
   public void setTokens(Set<model.AuthToken> authTokens) {}
   
   /** Returns the set of tokens
    * @return The set of tokens
    */
   public Set<model.AuthToken> getTokens() {return authTokens;}
}