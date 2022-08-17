
package com.fileutiliy.dto;
public class User {
    
   private String firstName;
   private String lastName;
   private String emailId;
   private String secretkey;
   
   public void setFirstName(String firstName) {
       this.firstName = firstName;
    } 
   
   public String getFirstName() {
       return this.firstName;
   }
   
   public void setLastName(String lastName) {
       this.lastName = lastName;
       
   } 
   
   public String getLastName() {
       return this.lastName;
   }
   
    public void setEmailId(String emailId) {
       this.emailId = emailId;
       
   } 
   
   public String getEmailId() {
       return this.emailId;
   }
   
    public void setSecretkey(String secretkey) {
       this.secretkey = secretkey;
       
   } 
   
   public String getSecretkey() {
       return this.secretkey;
   }
    
}
