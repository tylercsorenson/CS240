package dao;

import java.util.Set;

public class AuthTokenDao {
   private Set<model.AuthToken> authTokens;
   
   public AuthTokenDao() {}
   
   public AuthTokenDao(Set<model.AuthToken> authTokens) {}
      
   public void setTokens(Set<model.AuthToken> authTokens) {}
      
   public Set<model.AuthToken> getTokens() {return authTokens;}
}