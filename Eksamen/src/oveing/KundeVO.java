/*
 * KundeVO.java
 *
 * Created on 5. juni 2005, 20:42
 */

package oveing;

public class KundeVO {
   private String navn;
   private String adresse;
   
   public KundeVO(String navn, String adresse) {
	  this.navn = navn;
	  this.adresse = adresse;
   }

   public String getNavn() {return navn;}
   
   public String getAdresse(){return adresse;}

   public String toString() {
	  return navn + ", " + adresse;
   }

}

