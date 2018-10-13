package dao;

import java.util.Set;

public class PersonDao {
   private Set<model.Person> persons;
   
   public PersonDao() {}
      
   public PersonDao(Set<model.Person> persons) {}
      
   public void setPersons(Set<model.Person> persons) {}
      
   public Set<model.Person> getPersons() {return persons;}
}